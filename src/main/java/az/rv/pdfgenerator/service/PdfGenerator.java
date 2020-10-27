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
import com.itextpdf.text.pdf.*;
import org.springframework.stereotype.Service;

@Service
public class PdfGenerator {
    ArrayList<String> names = new ArrayList<>();


    public byte[] createPDF(ArrayList<TeklifModel> teklifModels) throws DocumentException, IOException {
        PdfDocument pdfDocument = new PdfDocument();


        DecimalFormat df = new DecimalFormat("0.00");
        Document doc = new Document(PageSize.A0);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(doc, byteArrayOutputStream);

        PdfWriter docWriter = null;


        names.add("Büdcə təşkilatı");
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

        names.add("Təhlil nəticəsində  qəbul olunmuş qərar");


        names.add("S.A.A");
        names.add("Təsdiqedici sənəd");

        names.add("Tarixi");
        names.add("Nömrəsi");
        names.add("Təklif olunan güzəşt növü");
        names.add("Güzəştin məqsədi");
        names.add("Güzəştin müddəti");
        names.add("Güzəştlə əhatə olunacaq fəaliyyət növləri");
        names.add("Hesablanmış güzəşt məbləği");
        names.add("Əldə oluna biləcək əlavə gəlir");
        names.add("İqtisadiyyata təsiri");
        names.add("Faydalanan sahibkarlıq subyektləri (ədəd)");
        names.add("Faydalanan işçi sayı (nəfər)");

        names.add("Statusu");
        names.add("Müddəti");

        names.add("S.A.A");
        names.add("Təsdiqedici sənəd");

        names.add("Tədiyə növü");
        names.add("İtki məbləği");
        names.add(" ilin proqnozlaşdırılmış itki məbləği");
        names.add(" ilin proqnozlaşdırılmış itki məbləği");
        names.add(" ilin proqnozlaşdırılmış itki məbləği");
        names.add(" ilin proqnozlaşdırılmış itki məbləği");









        try {
            Font bfBold12 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
            Font bf12 = new Font(Font.FontFamily.TIMES_ROMAN, 12);

            doc.addAuthor("betterThanZero");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("MySampleCode.com");
            doc.addTitle("Report with Column Headings");
            doc.setPageSize(PageSize.A0.rotate());
            BaseFont bf = BaseFont.createFont("arialuni.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            doc.open();
            Paragraph paragraph = new Paragraph("Büdcə təşkilatları tərəfindən vergi və gömrük sahəsində verilmiş müraciətlərə baxılmanın nəticələri haqqında hesabat", new Font(bf, 22));
            paragraph.setAlignment(Element.ALIGN_CENTER);
            doc.add(paragraph);

            doc.add(Chunk.NEWLINE);
            doc.add(Chunk.NEWLINE);


            PdfPTable table = new PdfPTable(9);
            table.setWidths(new float[]{1, 1, 2, 1.6f, 13, 2, 2, 7, 2});
            table.setWidthPercentage(100);

            for (int i = 0; i < 9; i++) {


                    PdfPCell cell = new PdfPCell(new Phrase(names.get(i), new Font(bf, 22)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    table.addCell(cell);



            }

            for(int i = 0; i < 9; i++) {
                if(i > 1) {
                    if(i == 2) {
                        PdfPTable table1 = new PdfPTable(2);
                        table1.setWidths(new float[]{1.7f, 2});
                        for(int j = 0; j < 2; j++) {
                            PdfPCell cell = new PdfPCell(new Phrase(names.get(j+9), new Font(bf, 22)));
                            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                            table1.addCell(cell);
                        }
                        table.addCell(table1);
                        PdfPCell cell13 = new PdfPCell(new Phrase(""));
                        cell13.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        table.addCell(cell13);
                        PdfPTable table2 = new PdfPTable(11);
                        table2.setWidths(new float[]{3, 3.6f, 3.6f, 3.6f, 3.6f, 3.6f, 3.6f, 3.6f, 3.6f, 3.6f, 3.6f});
                        table2.setWidthPercentage(100);
                        for(int j = 9; j < 21; j++) {
                            PdfPCell cell = new PdfPCell(new Phrase(names.get(j+2), new Font(bf, 22)));
                            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                            table2.addCell(cell);
                        }
                        table.addCell(table2);
                        PdfPTable table3 = new PdfPTable(2);
                        table3.setWidths(new float[]{1, 1});
                        for(int j = 22; j < 24; j++) {
                            PdfPCell cell = new PdfPCell(new Phrase(names.get(j), new Font(bf, 22)));
                            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                            table3.addCell(cell);
                        }
                        table.addCell(table3);

                        PdfPTable table4 = new PdfPTable(2);
                        table4.setWidths(new float[]{1, 1});
                        for(int j = 24; j < 26; j++) {
                            PdfPCell cell = new PdfPCell(new Phrase(names.get(j), new Font(bf, 22)));
                            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                            table4.addCell(cell);
                        }
                        table.addCell(table4);



                        PdfPTable table5 = new PdfPTable(6);
                        table5.setWidths(new float[]{1, 1, 1, 1, 1, 1});
                        for(int j = 26; j < 32; j++) {
                            PdfPCell cell = new PdfPCell(new Phrase(names.get(j), new Font(bf, 22)));
                            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                            table5.addCell(cell);
                        }
                        table.addCell(table5);
                        table.addCell(cell13);


                        for(int j = 0; j < teklifModels.size(); j++){
                            insertCell(table, teklifModels.get(j).getBudgetOrganization(), Element.ALIGN_LEFT, 1, bf);
                            insertCell(table, teklifModels.get(j).getVoen(), Element.ALIGN_LEFT, 1, bf);

                            PdfPTable table9 = new PdfPTable(2);
                            table9.setWidths(new float[]{1.7f, 2});
                            for(int k = j; k < teklifModels.size(); k++) {
                                insertCell(table9,teklifModels.get(k).getUser().getSaa(), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table9,teklifModels.get(k).getUser().getDoc(), Element.ALIGN_LEFT, 1, bf);
                            }
                            table.addCell(table9);

                            insertCell(table, teklifModels.get(j).getActivites(), Element.ALIGN_LEFT, 1, bf);

                            PdfPTable table10 = new PdfPTable(11);
                            table10.setWidths(new float[]{3, 3.6f, 3.6f, 3.6f, 3.6f, 3.6f, 3.6f, 3.6f, 3.6f, 3.6f, 3.6f});
                            table10.setWidthPercentage(100);
                            for(int k = j; k < teklifModels.size(); k++) {
                                insertCell(table10, teklifModels.get(k).getInformation().getDateFormat().toString(), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table10, Integer.toString(teklifModels.get(k).getInformation().getId()), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table10, teklifModels.get(k).getInformation().getDiscountType(), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table10, teklifModels.get(k).getInformation().getDiscountAim(), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table10, teklifModels.get(k).getInformation().getDiscountDuration(), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table10, teklifModels.get(k).getInformation().getActivityDiscType(), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table10, Integer.toString(teklifModels.get(k).getInformation().getDiscountAmount()), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table10, teklifModels.get(k).getInformation().getAdditionalIncome(), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table10, teklifModels.get(k).getInformation().getImpact(), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table10, teklifModels.get(k).getInformation().getBlank(), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table10, Integer.toString(teklifModels.get(k).getInformation().getCntOfUsers()), Element.ALIGN_LEFT, 1, bf);
                            }
                            table.addCell(table10);


                            PdfPTable table11 = new PdfPTable(2);
                            table3.setWidths(new float[]{1, 1});
                            for(int k = j; k < teklifModels.size(); k++) {
                                insertCell(table11, teklifModels.get(k).getConsideration().getStatus(), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table11, teklifModels.get(k).getConsideration().getDuration(), Element.ALIGN_LEFT, 1, bf);
                            }
                            table.addCell(table11);



                            PdfPTable table12 = new PdfPTable(2);
                            table12.setWidths(new float[]{1, 1});
                            for(int k = j; k < teklifModels.size(); k++) {
                                insertCell(table12, teklifModels.get(k).getConductUser().getSaa(), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table12, teklifModels.get(k).getConductUser().getDoc(), Element.ALIGN_LEFT, 1, bf);
                            }
                            table.addCell(table12);


                            PdfPTable table13 = new PdfPTable(6);
                            table13.setWidths(new float[]{1, 1, 1, 1, 1, 1});
                            for(int k = j; k < teklifModels.size(); k++) {
                                insertCell(table13, teklifModels.get(k).getBudgetLoss().getType(), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table13, teklifModels.get(k).getBudgetLoss().getAmount(), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table13, Integer.toString(teklifModels.get(k).getBudgetLoss().getYear1()), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table13, Integer.toString(teklifModels.get(k).getBudgetLoss().getYear2()), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table13, Integer.toString(teklifModels.get(k).getBudgetLoss().getYear3()), Element.ALIGN_LEFT, 1, bf);
                                insertCell(table13, Integer.toString(teklifModels.get(k).getBudgetLoss().getYear4()), Element.ALIGN_LEFT, 1, bf);
                            }
                            table.addCell(table13);

                            insertCell(table, teklifModels.get(j).getDecision(), Element.ALIGN_LEFT, 1, bf);

                        }
                    }

//                    if(i == 3) {
//
//                    }

                    PdfPCell cell = new PdfPCell(new Phrase(names.get(i), new Font(bf, 14)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    table.addCell(cell);
                }


                else {
                    PdfPCell cell = new PdfPCell(new Phrase(""));
                    cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    table.addCell(cell);

                }
            }




            doc.add(table);
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


    private void insertCell(PdfPTable table, String text, int align, int colspan, BaseFont font) {

        //create a new cell with the specified Text and Font
        PdfPCell cell = new PdfPCell(new Phrase(text.trim(), new Font(font, 22)));
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