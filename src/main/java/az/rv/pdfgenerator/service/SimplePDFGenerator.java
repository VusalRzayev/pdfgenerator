package az.rv.pdfgenerator.service;

import az.rv.pdfgenerator.controller.Field;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class SimplePDFGenerator {



    public byte[] createPDF(ArrayList<Field> fields) throws DocumentException {
        float[] columnWidths = new float[fields.size()];
        Document doc = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(doc, byteArrayOutputStream);
        PdfWriter docWriter = null;

        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println(fields);

        try {
//
            //special font sizes
            Font bfBold12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
            Font bf12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);

            //file path
            //document header attributes
            doc.addAuthor("betterThanZero");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("MySampleCode.com");
            doc.addTitle("Report with Column Headings");
            doc.setPageSize(PageSize.LETTER);


            doc.open();

            for(int i = 0; i < fields.size(); i++) {
                columnWidths[i] = 1.5f;
            }
            PdfPTable table = new PdfPTable(columnWidths);

            table.setWidthPercentage(90f);


            List elements = new List();
            for(int i = 0; i < fields.size(); i++) {
                elements.add(fields.get(i).getFieldName() + "      " + fields.get(i).getFieldDescription());
            }

            doc.add(elements);


            for(int i = 0; i < fields.size(); i++) {
                insertCell(table, fields.get(i).getFieldName(), Element.ALIGN_LEFT, 1, bfBold12);
                System.out.println(fields.get(i).getFieldName());
            }
            for(int i = 0; i < fields.size(); i++) {
                insertCell(table, fields.get(i).getFieldValue().toString(), Element.ALIGN_RIGHT, 1, bf12);
            }


            doc.add( Chunk.NEWLINE );
            doc.add( Chunk.NEWLINE );

            doc.add(table);


            table.setHeaderRows(1);




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

        byte[] pdfBytes = byteArrayOutputStream.toByteArray();

        System.out.println(pdfBytes + " I AM BYTES");
        return pdfBytes;
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
