package az.rv.pdfgenerator.controller;

import az.rv.pdfgenerator.service.PdfGenerator;
import az.rv.pdfgenerator.service.XlsGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

@RestController
public class MainController {

    @Autowired
    private PdfGenerator pdfGenerator;
    public XlsGenerator xlsGenerator = new XlsGenerator();
    private ArrayList<Field> fields;

    @GetMapping
    public String generate() throws FileNotFoundException {
        String pdfFileName="test.pdf";
        String excelFileName = "test.xlsx";
        fields = new ArrayList<>();
        Field field1 = new Field("S1", "S1_Description", 1D);
        Field field2 = new Field("S2", "S2_Description", 2D);
        Field field3 = new Field("K1", "K1_Description", 3D);
        Field field4 = new Field("K2", "K2_Description", 4D);
//        Field field5 = new Field("E", "E_Description", 5D);
//        Field field6 = new Field("V", "V_Description", 6D);
        Field field7 = new Field("B", "B_Description", 7D);
        Field field8 = new Field("B1", "B1_Description", 8D);
        Field field9 = new Field("B2", "B2_Description", 9D);
        Field field10 = new Field("B3", "B3_Description", 10D);

        fields.add(field1);
        fields.add(field2);
        fields.add(field3);
        fields.add(field4);
//        fields.add(field5);
//        fields.add(field6);
        fields.add(field7);
        fields.add(field8);
        fields.add(field9);
        fields.add(field10);
        
        File file=new File(pdfFileName);
//        File xlsFile = new File(excelFileName);

        pdfGenerator.createPDF(pdfFileName, fields);
        xlsGenerator.createXLS(excelFileName, fields);
        return "Ok";
    }
}
