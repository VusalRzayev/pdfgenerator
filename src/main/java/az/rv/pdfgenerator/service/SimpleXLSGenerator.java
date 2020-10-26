package az.rv.pdfgenerator.service;

import az.rv.pdfgenerator.Model.TeklifModel;
import az.rv.pdfgenerator.controller.Field;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SimpleXLSGenerator {
    Workbook workbook;
    public byte[] createXls(ArrayList<Field> fields) {

        workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("test");

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
//        headerFont.setColor(IndexedColors.RED.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        int numRow = 0;
        for(int i = 0; i < fields.size(); i++) {
            Row row = sheet.createRow(numRow++);
            row.createCell(0).setCellValue(fields.get(i).getFieldName());
            row.createCell(1).setCellValue(fields.get(i).getFieldDescription());
        }

//        int numRow1 = 0;
//        for(int i = 0; i < fields.size(); i++) {
//            Row row = sheet.createRow(numRow1++);
//
//        }




        Row headerRow = sheet.createRow(fields.size() + 2);

        for (int i = 0; i < fields.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(fields.get(i).getFieldName());
            cell.setCellStyle(headerCellStyle);
        }

        Row row = sheet.createRow(fields.size() + 3);

        for (int i = 0; i < fields.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(fields.get(i).getFieldValue());

        }




        for (int i = 0; i < fields.size(); i++) {
            sheet.autoSizeColumn(i);
        }
        ByteArrayOutputStream fileOut = new ByteArrayOutputStream();

        try {
            workbook.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        byte[] bytes = fileOut.toByteArray();

        System.out.println(bytes + " I AM BYTES");
        return bytes;
    }
}
