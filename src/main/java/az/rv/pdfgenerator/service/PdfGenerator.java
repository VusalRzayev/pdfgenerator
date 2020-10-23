package az.rv.pdfgenerator.service;

import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

import az.rv.pdfgenerator.controller.Field;
import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

@Service
public class PdfGenerator {

    public void createPDF (String pdfFilename, ArrayList<Field> fields){

        // ArrayList<Field> fields = new ArrayList<>();

        // Field field = new Field();
        // field.setFieldName("S1");
        // field.setFieldDescription("Evvelki ilde");
        // field.setFieldValue(1d);

        // fields.add(field);




        Document doc = new Document();
        PdfWriter docWriter = null;

        DecimalFormat df = new DecimalFormat("0.00");

        try {

            //special font sizes
            Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
            Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12);

            //file path
            String path = pdfFilename;
            docWriter = PdfWriter.getInstance(doc , new FileOutputStream(path));

            //document header attributes
            doc.addAuthor("betterThanZero");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("MySampleCode.com");
            doc.addTitle("Report with Column Headings");
            doc.setPageSize(PageSize.LETTER);

            //open document
            doc.open();

            //create a paragraph
            Paragraph paragraph = new Paragraph("iText ® is a library that allows you to create and " +
                    "manipulate PDF documents. It enables developers looking to enhance web and other " +
                    "applications with dynamic PDF document generation and/or manipulation.");



            //specify column widths
            float[] columnWidths = {1.5f, 1.5f, 1.5f, 1.5f,1.5f,1.5f,1.5f,1.5f,1.5f,1.5f};
            //create PDF table with the given widths
            PdfPTable table = new PdfPTable(columnWidths);
            // set table width a percentage of the page width
            table.setWidthPercentage(90f);



            for(int i = 0; i < fields.size(); i++) {
                insertCell(table, fields.get(i).getFieldName(), Element.ALIGN_LEFT, 1, bfBold12);
                System.out.println(fields.get(i).getFieldName());
            }
            for(int i = 0; i < fields.size(); i++) {
                insertCell(table, fields.get(i).getFieldValue().toString(), Element.ALIGN_RIGHT, 1, bf12);
            }


            List elements = new List();
            for(int i = 0; i < fields.size(); i++) {
                elements.add(fields.get(i).getFieldName() + "      " + fields.get(i).getFieldDescription());

            }

            doc.add(elements);


            //insert column headings
//            insertCell(table, "S1", Element.ALIGN_LEFT, 1, bfBold12);
//            insertCell(table, "S2", Element.ALIGN_LEFT, 1, bfBold12);
//            insertCell(table, "K1", Element.ALIGN_LEFT, 1, bfBold12);
//            insertCell(table, "K2", Element.ALIGN_LEFT, 1, bfBold12);
//            insertCell(table, "E", Element.ALIGN_LEFT, 1, bfBold12);
//            insertCell(table, "V", Element.ALIGN_LEFT, 1, bfBold12);
//            insertCell(table, "B", Element.ALIGN_LEFT, 1, bfBold12);
//            insertCell(table, "B1", Element.ALIGN_LEFT, 1, bfBold12);
//            insertCell(table, "B2", Element.ALIGN_LEFT, 1, bfBold12);
//            insertCell(table, "B3", Element.ALIGN_LEFT, 1, bfBold12);
            table.setHeaderRows(1);

//            for(int x=1; x<=10; x++) {
//
//                insertCell(table, ""+x, Element.ALIGN_LEFT, 1, bf12);
//
//            }

            paragraph.add(table);
            doc.add(paragraph);

        }
        catch (DocumentException dex)
        {
            dex.printStackTrace();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if (doc != null){
                //close the document
                doc.close();
            }
            if (docWriter != null){
                //close the writer
                docWriter.close();
            }
        }
    }

    private void insertCell(PdfPTable table, String text, int align, int colspan, Font font){

        //create a new cell with the specified Text and Font
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
        //set the cell alignment
        cell.setHorizontalAlignment(align);
        //set the cell column span in case you want to merge two or more cells
        cell.setColspan(colspan);
        //in case there is no text and you wan to create an empty row
        if(text.trim().equalsIgnoreCase("")){
            cell.setMinimumHeight(10f);
        }
        //add the call to the table
        table.addCell(cell);

    }

}