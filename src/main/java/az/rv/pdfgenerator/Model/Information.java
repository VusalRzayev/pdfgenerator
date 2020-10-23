package az.rv.pdfgenerator.Model;

import java.text.DateFormat;
import java.util.Date;

public class Information {

    Date dateFormat;
    int id;
    String discountType;
    String discountAim;
    String discountDuration;
    String activityDiscType;
    int discountAmount;
    String additionalIncome;
    String impact;
    String blank;
    int cntOfUsers;

    public Information(Date dateFormat, int id, String discountType, String discountAim, String discountDuration, String activityDiscType, int discountAmount, String additionalIncome, String impact, String blank, int cntOfUsers) {
        this.dateFormat = dateFormat;
        this.id = id;
        this.discountType = discountType;
        this.discountAim = discountAim;
        this.discountDuration = discountDuration;
        this.activityDiscType = activityDiscType;
        this.discountAmount = discountAmount;
        this.additionalIncome = additionalIncome;
        this.impact = impact;
        this.blank = blank;
        this.cntOfUsers = cntOfUsers;
    }

    public Date getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(Date dateFormat) {
        this.dateFormat = dateFormat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getDiscountAim() {
        return discountAim;
    }

    public void setDiscountAim(String discountAim) {
        this.discountAim = discountAim;
    }

    public String getDiscountDuration() {
        return discountDuration;
    }

    public void setDiscountDuration(String discountDuration) {
        this.discountDuration = discountDuration;
    }

    public String getActivityDiscType() {
        return activityDiscType;
    }

    public void setActivityDiscType(String activityDiscType) {
        this.activityDiscType = activityDiscType;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getAdditionalIncome() {
        return additionalIncome;
    }

    public void setAdditionalIncome(String additionalIncome) {
        this.additionalIncome = additionalIncome;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getBlank() {
        return blank;
    }

    public void setBlank(String blank) {
        this.blank = blank;
    }

    public int getCntOfUsers() {
        return cntOfUsers;
    }

    public void setCntOfUsers(int cntOfUsers) {
        this.cntOfUsers = cntOfUsers;
    }
}
