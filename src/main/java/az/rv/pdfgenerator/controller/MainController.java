package az.rv.pdfgenerator.controller;

import az.rv.pdfgenerator.Model.*;
import az.rv.pdfgenerator.service.*;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

@RestController
public class MainController {

    @Autowired
    private PdfGenerator pdfGenerator;
    private SimplePDFGenerator simplePDFGenerator = new SimplePDFGenerator();
    public XlsGenerator xlsGenerator = new XlsGenerator();
    public PDFtoXLSConverter pdFtoXLSConverter;
    public SimpleXLSGenerator simpleXLSGenerator = new SimpleXLSGenerator();
    private ArrayList<TeklifModel> teklifModels;
    private ArrayList<Field> fields;


    @GetMapping
    public ResponseEntity<Resource> generate() throws IOException, DocumentException {


        teklifModels = new ArrayList<>();
        fields = new ArrayList<>();
        TeklifModel teklifModel = new TeklifModel("Rashad LLC", "ssdsds12232", new RepresentativeUser("saass", "document"),
                "activity1",new Information(new Date(2020, 10, 23), 1,
                "Discount", "Unknown Aim", "10 hours",
                "No type", 1000, "No additional income",
                "No impact", "", 3), new Consideration("active", "10 hours"),
                new ConductUser("saa123321", "document"), new BudgetLoss("No type", "1000 AZN"), "deny");

        teklifModels.add(teklifModel);

        Field field = new Field("S1", "S1_Description", 1d);
        Field field1 = new Field("S2", "S2_Description", 2d);
        Field field2 = new Field("K1", "K1_Description", 3d);
        Field field3 = new Field("K2", "K2_Description", 4d);
        Field field4 = new Field("BƏ", "B_Dəscription", 5d);
        Field field5 = new Field("B1", "B1_Description", 6d);
        Field field6 = new Field("B2", "B2_Description", 7d);
        Field field7 = new Field("S3", "B3_Description", 8d);

        fields.add(field);
        fields.add(field1);
        fields.add(field2);
        fields.add(field3);
        fields.add(field4);
        fields.add(field5);
        fields.add(field6);
        fields.add(field7);
        byte[] array = simplePDFGenerator.createPDF(fields);
//        byte[] array = xlsGenerator.createXLS(teklifModels);
//        byte[] array = pdfGenerator.createPDF(teklifModels);
//        byte[] array = simpleXLSGenerator.createXls(fields);
//        pdFtoXLSConverter = new PDFtoXLSConverter(array);
//        byte[] bytes = pdFtoXLSConverter.convert();
        System.out.println(array.length);
        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(array));
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Disposition", String.format("attachment; filename=test.pdf"));
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(array.length)
                .contentType(MediaType.valueOf("application/octet-stream"))
                .body(resource);
    }
}
