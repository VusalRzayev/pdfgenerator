package az.rv.pdfgenerator.Model;

public class RepresentativeUser {

    String saa;
    String doc;

    public RepresentativeUser(String saa, String doc) {
        this.saa = saa;
        this.doc = doc;
    }

    public String getSaa() {
        return saa;
    }

    public void setSaa(String saa) {
        this.saa = saa;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }
}
