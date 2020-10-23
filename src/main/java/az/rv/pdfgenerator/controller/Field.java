package az.rv.pdfgenerator.controller;


public class Field {

    private String fieldName;
    private String fieldDescription;
    private Double fieldValue;

    public Field(String fieldName, String fieldDescription, Double fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.fieldDescription = fieldDescription;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldDescription() {
        return fieldDescription;
    }

    public void setFieldDescription(String fieldDescription) {
        this.fieldDescription = fieldDescription;
    }

    public Double getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(Double fieldValue) {
        this.fieldValue = fieldValue;
    }
}
