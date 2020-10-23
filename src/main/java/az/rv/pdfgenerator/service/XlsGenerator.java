package az.rv.pdfgenerator.service;

import az.rv.pdfgenerator.Model.TeklifModel;
import az.rv.pdfgenerator.controller.Field;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Service
public class XlsGenerator {


    Row headerRow;

    ArrayList<String> names = new ArrayList<>();
    CellStyle titleCellStyle;
    Font titleFont;
    Font secondFont;
    Row titleRow;
    Cell cell;
    Workbook workbook;
    Sheet sheet;
    Map<String, CellStyle> styles;
    ArrayList<TeklifModel> models;
    public void createXLS(String xlsFileName, ArrayList<TeklifModel> models) {
        this.models = models;
        workbook = new XSSFWorkbook();

        sheet = workbook.createSheet("Müraciət");
        createStyles();
        createHeaderRow();

        names.add("Büdcə \n təşkilatı");
        names.add("VÖEN");
        names.add("Büdcə təşkilatını\ntəmsil edən şəxs");
        names.add("S.A.A");
        names.add("Təsdiqedici \nsənəd");
        names.add("Büdcə \ntəşkilatının əsas fəaliyyət \nistiqaməti");
        names.add("Güzəşt və azadolma üzrə müraciətə dair məlumatlar");

        names.add("Tarixi");
        names.add("Nömrəsi");
        names.add("Təklif \nolunan  \ngüzəşt \nnövü");
        names.add("Güzəştin \nməqsədi");
        names.add("Güzəştin \nmüddəti");
        names.add("Güzəştlə \nəhatə \nolunacaq \nfəaliyyət \nnövləri");
        names.add("Hesablanmış \ngüzəşt məbləği");
        names.add("Əldə oluna \nbiləcək əlavə \ngəlir");
        names.add("İqtisadiyyata \ntəsiri");
        names.add("Faydalanan \nsahibkarlıq \nsubyektləri \n(ədəd)");
        names.add("Faydalanan işçi sayı\n (nəfər)");

        names.add("Müraciətə \nbaxılma");
        names.add("Statusu");
        names.add("Müddəti");

        names.add("Təhlil aparan \nşəxs");
        names.add("S.A.A");
        names.add("Təsdiqedici \nsənəd");
        names.add("Büdcə itkisinin \nməbləği");
        names.add("Tədiyə növü");
        names.add("İtki \nməbləği");











        sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 40));
//

        Row row = sheet.createRow(1);
        row.setHeight((short) (5*256));
        for (int j = 0; j < 22; j++) {
            System.out.println(row.getRowNum());

            Cell cell = row.createCell(j);
            row.getCell(j).setCellStyle(styles.get("style2"));

            if (j == 0) {
                row.getCell(j).setCellValue(names.get(j));
            } else if (j == 1) {
                row.getCell(j).setCellValue(names.get(j));
            } else if (j == 2) {
                sheet.addMergedRegion(new CellRangeAddress(1, 1, j, j + 1));
                row.getCell(j).setCellValue(names.get(j));
            } else if (j == 4) {
                row.getCell(j).setCellValue(names.get(j + 1));
            } else if (j == 5) {
                row.getCell(j).setCellValue(names.get(j + 1));
                sheet.addMergedRegion(new CellRangeAddress(1, 1, j, j + 10));
                setWidth(names.get(j+1), j, j+10);

            } else if (j == 16) {
                sheet.addMergedRegion(new CellRangeAddress(1, 1, j, j + 1));
                row.getCell(j).setCellValue(names.get(j + 2));
            } else if (j == 18) {
                sheet.addMergedRegion(new CellRangeAddress(1, 1, j, j + 1));
                row.getCell(j).setCellValue(names.get(j + 3));

            } else if (j == 20) {
                sheet.addMergedRegion(new CellRangeAddress(1, 1, j, j + 1));
                row.getCell(j).setCellValue(names.get(j + 4));
            }
        }

        Row row1 = sheet.createRow(2);
        row1.setHeight((short) (10*256));

        for (int j = 0; j < 22; j++) {

            sheet.setColumnWidth(j, 10 * 256);
            Cell cell = row1.createCell(j);
            row1.getCell(j).setCellStyle(styles.get("style2"));

            if (j == 0) {
                row1.getCell(j).setCellValue("");
            } else if (j == 1) {
                row1.getCell(j).setCellValue("");
            } else if (j == 2) {
                row1.getCell(j).setCellValue(names.get(j + 1));
            } else if(j == 3) {
                row1.getCell(j).setCellValue(names.get(j + 1));
            } else if (j == 4) {
                row1.getCell(j).setCellValue("");
            } else if (j == 5) {
                row1.getCell(j).setCellValue(names.get(j + 2));
            }  else if (j == 6) {
                row1.getCell(j).setCellValue(names.get(j + 2));
            } else if (j == 7) {
                row1.getCell(j).setCellValue(names.get(j + 2));
            } else if (j == 8) {
                row1.getCell(j).setCellValue(names.get(j + 2));
            } else if (j == 9) {
                row1.getCell(j).setCellValue(names.get(j + 2));
            } else if (j == 10) {
                row1.getCell(j).setCellValue(names.get(j + 2));
            } else if (j == 11) {
                row1.getCell(j).setCellValue(names.get(j + 2));
            } else if (j == 12) {
                row1.getCell(j).setCellValue(names.get(j + 2));
            } else if (j == 13) {
                row1.getCell(j).setCellValue(names.get(j + 2));
            } else if (j == 14) {
                row1.getCell(j).setCellValue(names.get(j + 2));
            } else if (j == 15) {
                row1.getCell(j).setCellValue(names.get(j + 2));
            }else if (j == 16) {
                row1.getCell(j).setCellValue(names.get(j + 3));
            }  else if (j == 17) {
                row1.getCell(j).setCellValue(names.get(j + 3));
            }else if (j == 18) {
                row1.getCell(j).setCellValue(names.get(j + 4));

            }
            else if (j == 19) {
                row1.getCell(j).setCellValue(names.get(j + 4));
            }
            else if (j == 20) {
                row1.getCell(j).setCellValue(names.get(j + 5));
            }
            else if (j == 21) {
                row1.getCell(j).setCellValue(names.get(j + 5));
            }
        }


        setData();




        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(xlsFileName);
            workbook.write(fileOut);
            fileOut.close();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }

        autoSizeColumns(workbook);
    }

    private void setData() {
        for(int i = 0; i < models.size(); i++) {
            Row row = sheet.createRow(i+3);
            row.setHeight((short) (5*256));
            for (int j = 0; j < 22; j++) {
                sheet.setColumnWidth(j, 12 * 256);
                Cell cell = row.createCell(j);
                row.getCell(j).setCellStyle(styles.get("style2"));
                if (j == 0) {
                    row.getCell(j).setCellValue(models.get(i).getBudgetOrganization());
                } else if (j == 1) {
                    row.getCell(j).setCellValue(models.get(i).getVoen());
                } else if (j == 2) {
                    row.getCell(j).setCellValue(models.get(i).getUser().getSaa());
                } else if(j == 3) {
                    row.getCell(j).setCellValue(models.get(i).getUser().getDoc());
                } else if (j == 4) {
                    row.getCell(j).setCellValue("");
                } else if (j == 5) {
                    row.getCell(j).setCellValue(names.get(j + 2));
                }  else if (j == 6) {
                    row.getCell(j).setCellValue(names.get(j + 2));
                } else if (j == 7) {
                    row.getCell(j).setCellValue(names.get(j + 2));
                } else if (j == 8) {
                    row.getCell(j).setCellValue(names.get(j + 2));
                } else if (j == 9) {
                    row.getCell(j).setCellValue(names.get(j + 2));
                } else if (j == 10) {
                    row.getCell(j).setCellValue(names.get(j + 2));
                } else if (j == 11) {
                    row.getCell(j).setCellValue(names.get(j + 2));
                } else if (j == 12) {
                    row.getCell(j).setCellValue(names.get(j + 2));
                } else if (j == 13) {
                    row.getCell(j).setCellValue(names.get(j + 2));
                } else if (j == 14) {
                    row.getCell(j).setCellValue(names.get(j + 2));
                } else if (j == 15) {
                    row.getCell(j).setCellValue(names.get(j + 2));
                }else if (j == 16) {
                    row.getCell(j).setCellValue(names.get(j + 3));
                }  else if (j == 17) {
                    row.getCell(j).setCellValue(names.get(j + 3));
                }else if (j == 18) {
                    row.getCell(j).setCellValue(names.get(j + 4));

                }
                else if (j == 19) {
                    row.getCell(j).setCellValue(names.get(j + 4));
                }
                else if (j == 20) {
                    row.getCell(j).setCellValue(names.get(j + 5));
                }
                else if (j == 21) {
                    row.getCell(j).setCellValue(names.get(j + 5));
                }
            }
        }


    }

    private void createStyles() {
        styles = new HashMap<>();

        CellStyle headerCellStyle = workbook.createCellStyle();

        Font headerFont = workbook.createFont();
        headerFont.setFontHeightInPoints((short) 24);
        headerFont.setFontName("Arial");


        headerFont.setColor(IndexedColors.BLACK.getIndex());

        headerFont.setBold(true);
        headerFont.setItalic(false);
        headerCellStyle.setFont(headerFont);


        styles.put("style1", headerCellStyle);


        titleCellStyle = workbook.createCellStyle();
        titleCellStyle.setWrapText(true);
        titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 12);
        titleFont.setFontName("Arial");
        titleFont.setColor(IndexedColors.BLACK.getIndex());
        titleFont.setBold(true);
        titleCellStyle.setAlignment(HorizontalAlignment.CENTER);
        titleCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        titleCellStyle.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        titleCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        titleCellStyle.setFont(titleFont);
        titleCellStyle.setBorderBottom(BorderStyle.MEDIUM);
        titleCellStyle.setBorderTop(BorderStyle.MEDIUM);
        titleCellStyle.setBorderRight(BorderStyle.MEDIUM);
        titleCellStyle.setBorderLeft(BorderStyle.MEDIUM);

        styles.put("style2", titleCellStyle);


    }

    public void autoSizeColumns(Workbook workbook) {
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            if (sheet.getPhysicalNumberOfRows() > 0) {
                Row row = sheet.getRow(sheet.getFirstRowNum());
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    int columnIndex = cell.getColumnIndex();
                    sheet.autoSizeColumn(columnIndex);
                    int currentColumnWidth = sheet.getColumnWidth(columnIndex);
                    sheet.setColumnWidth(columnIndex, (currentColumnWidth + 2500));
                }
            }
        }
    }

    private void createHeaderRow() {
        headerRow = sheet.createRow(0);
        headerRow.createCell(1).setCellValue("Büdcə təşkilatları tərəfindən vergi və " +
                "gömrük sahəsində verilmiş müraciətlərə baxılmanın nəticələri haqqında hesabat");
        headerRow.getCell(1).setCellStyle(styles.get("style1"));
    }


    private void setWidth(String text, int pos1, int pos2) {
        int colwidthinchars = (sheet.getColumnWidth(pos1) + sheet.getColumnWidth(pos2)) / 256;
        System.out.println(colwidthinchars);
        //correct the colwidthinchars by a factor 5/4 (highly dependent on the language used)
        colwidthinchars = Math.round(colwidthinchars * 5f/4f);
        System.out.println(colwidthinchars);

        //calculate the needed rows dependent on the text and the column width in character widths
        String[] chars = text.split("");
        int neededrows = 1;
        int counter = 0;
        for (int i = 0; i < chars.length; i++) {
            counter++;
            if (counter == colwidthinchars) {
                System.out.println("new line because of charcter count");
                neededrows++;
                counter = 0;
            } else if ("\n".equals(chars[i])) {
                System.out.println("new line because of new line mark");
                neededrows++;
                counter = 0;
            }
        }

        System.out.println(neededrows);
    }
}
