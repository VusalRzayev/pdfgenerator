package az.rv.pdfgenerator.Model;

public class Consideration {

    String status;
    String duration;

    public Consideration(String status, String duration) {
        this.status = status;
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
