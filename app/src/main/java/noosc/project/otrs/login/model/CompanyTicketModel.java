package noosc.project.otrs.login.model;

/**
 * Created by Fauziyyah Faturahma on 9/13/2017.
 */

public class CompanyTicketModel {

    private String notiket;
    private String customer;
    private String state;
    private String user;
    private String title;

    public String getNotiket() {
        return notiket;
    }

    public void setNotiket(String notiket) {
        this.notiket = notiket;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
