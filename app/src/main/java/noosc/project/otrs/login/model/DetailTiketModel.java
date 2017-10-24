package noosc.project.otrs.login.model;

/**
 * Created by Fauziyyah Faturahma on 10/6/2017.
 */

public class DetailTiketModel {

        private String tn;
        private String titile;
        private String queue;
        private String ticket_type;
        private String state;
        private String customer;
        private String user;
        private String priority;

    public String getTn() { return tn; }

    public void setTn(String tn) { this.tn = tn; }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getTicket_type() {
        return ticket_type;
    }

    public void setTicket_type(String ticket_type) {
        this.ticket_type = ticket_type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
