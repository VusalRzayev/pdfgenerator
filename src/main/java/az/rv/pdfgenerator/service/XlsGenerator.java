package az.rv.pdfgenerator.service;

import az.rv.pdfgenerator.controller.Field;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class XlsGenerator {

    public void createXLS(String xlsFileName, ArrayList<Field> fields) {

        Workbook workbook = new XSSFWorkbook();
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

        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(xlsFileName);
            workbook.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
