package noosc.project.otrs.login.model;

/**
 * Created by Fauziyyah Faturahma on 10/6/2017.
 */

public class DetailBody {

    private String from;
    private String to;
    private String cc;
    private String subject;
    private String body;
    private String time;

    public String getTime() {
        return time;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
