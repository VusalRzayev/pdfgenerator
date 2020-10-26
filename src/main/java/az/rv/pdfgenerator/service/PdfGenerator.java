package az.rv.pdfgenerator.service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.stream.Stream;

import az.rv.pdfgenerator.Model.TeklifModel;
import az.rv.pdfgenerator.controller.Field;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

@Service
public class PdfGenerator {
    ArrayList<String> names = new ArrayList<>();


    public byte[] createPDF(ArrayList<TeklifModel> teklifModels) throws DocumentException, IOException {

        DecimalFormat df = new DecimalFormat("0.00");
        Document doc = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(doc, byteArrayOutputStream);

        PdfWriter docWriter = null;
        PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);

        names.add("Büdcə \n təşkilatı");
        names.add("VÖEN");
        names.add("Büdcə təşkilatını\n" +
                "təmsil edən şəxs");
        names.add("Büdcə \n" +
                "təşkilatının əsas fəaliyyət \n" +
                "istiqaməti");
        names.add("Güzəşt və azadolma üzrə müraciətə dair məlumatlar");
        names.add("Müraciətə \n" +
                "baxılma");
        names.add("Təhlil aparan \n" +
                "şəxs");
        names.add("Büdcə itkisinin \n" +
                "məbləği");


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


        try {
            Font bfBold12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
            Font bf12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);

            doc.addAuthor("betterThanZero");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("MySampleCode.com");
            doc.addTitle("Report with Column Headings");
            doc.setPageSize(PageSize.LETTER);

            doc.open();

            doc.add(new Paragraph("Büdcə təşkilatları tərəfindən vergi və gömrük sahəsində verilmiş müraciətlərə baxılmanın nəticələri haqqında hesabat"));

            doc.add(Chunk.NEWLINE);
            doc.add(Chunk.NEWLINE);





//            PdfPTable table = new PdfPTable(8);
//            table.setWidths(new float[]{1, 1, 2, 1, 3, 2, 2, 2});
//            table.setWidthPercentage(100);
//            BaseFont bf = BaseFont.createFont("arialuni.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//            for (int i = 0; i < 8; i++) {
//                if (i == 4) {
//                    PdfPCell cell1 = new PdfPCell(new Phrase(names.get(i), new Font(bf, 8)));
////                    cell1.setColspan(11);
//                    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
//                    cell1.setBackgroundColor(BaseColor.GREEN);
//                    table.addCell(cell1);
//                    System.out.println("SALAM0");
//
//
//                } else {
//                    PdfPCell cell = new PdfPCell(new Phrase(names.get(i), new Font(bf, 7)));
//                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                    cell.setBackgroundColor(BaseColor.GREEN);
//                    table.addCell(cell);
//                }
//
//
//            }
//            for(int j = 0; j < 11; j++) {
//                System.out.println("SALAM1");
//                table.addCell("cell1");
//            }



//            doc.add(table);
        } catch (DocumentException dex) {
            dex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (doc != null) {
                //close the document
                doc.close();

            }
            if (docWriter != null) {
                //close the writer
                docWriter.close();

            }
        }
        byte[] pdfBytes = byteArrayOutputStream.toByteArray();

        System.out.println(pdfBytes + " I AM BYTES");
        return pdfBytes;
    }


    private void insertCell(PdfPTable table, String text, int align, int colspan, Font font) {

        //create a new cell with the specified Text and Font
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), font));
        //set the cell alignment
        cell.setHorizontalAlignment(align);
        //set the cell column span in case you want to merge two or more cells
        cell.setColspan(colspan);
        //in case there is no text and you wan to create an empty row
        if (text.trim().equalsIgnoreCase("")) {
            cell.setMinimumHeight(10f);
        }
        //add the call to the table
        table.addCell(cell);

    }

}