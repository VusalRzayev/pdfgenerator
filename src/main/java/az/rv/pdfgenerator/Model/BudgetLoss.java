package az.rv.pdfgenerator.Model;

public class BudgetLoss {

    String type;
    String amount;
    int year1;
    int year2;
    int year3;
    int year4;

    public BudgetLoss(String type, String amount, int year1, int year2, int year3, int year4) {
        this.type = type;
        this.amount = amount;
        this.year1 = year1;
        this.year2 = year2;
        this.year3 = year3;
        this.year4 = year4;
    }

    public int getYear1() {
        return year1;
    }

    public void setYear1(int year1) {
        this.year1 = year1;
    }

    public int getYear2() {
        return year2;
    }

    public void setYear2(int year2) {
        this.year2 = year2;
    }

    public int getYear3() {
        return year3;
    }

    public void setYear3(int year3) {
        this.year3 = year3;
    }

    public int getYear4() {
        return year4;
    }

    public void setYear4(int year4) {
        this.year4 = year4;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
