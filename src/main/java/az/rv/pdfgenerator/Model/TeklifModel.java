package az.rv.pdfgenerator.Model;

import java.text.DateFormat;

public class TeklifModel {

    String budgetOrganization;
    String voen;
    RepresentativeUser user;
    String activites;
    Information information;
    Consideration consideration;
    ConductUser conductUser;
    BudgetLoss budgetLoss;
    String decision;

    public TeklifModel(String budgetOrganization, String voen, RepresentativeUser user, String activites, Information information, Consideration consideration, ConductUser conductUser, BudgetLoss budgetLoss, String decision) {
        this.budgetOrganization = budgetOrganization;
        this.voen = voen;
        this.user = user;
        this.activites = activites;
        this.information = information;
        this.consideration = consideration;
        this.conductUser = conductUser;
        this.budgetLoss = budgetLoss;
        this.decision = decision;
    }

    public String getBudgetOrganization() {
        return budgetOrganization;
    }

    public void setBudgetOrganization(String budgetOrganization) {
        this.budgetOrganization = budgetOrganization;
    }

    public String getVoen() {
        return voen;
    }

    public void setVoen(String voen) {
        this.voen = voen;
    }

    public RepresentativeUser getUser() {
        return user;
    }

    public void setUser(RepresentativeUser user) {
        this.user = user;
    }

    public String getActivites() {
        return activites;
    }

    public void setActivites(String activites) {
        this.activites = activites;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public Consideration getConsideration() {
        return consideration;
    }

    public void setConsideration(Consideration consideration) {
        this.consideration = consideration;
    }

    public ConductUser getConductUser() {
        return conductUser;
    }

    public void setConductUser(ConductUser conductUser) {
        this.conductUser = conductUser;
    }

    public BudgetLoss getBudgetLoss() {
        return budgetLoss;
    }

    public void setBudgetLoss(BudgetLoss budgetLoss) {
        this.budgetLoss = budgetLoss;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }
}
