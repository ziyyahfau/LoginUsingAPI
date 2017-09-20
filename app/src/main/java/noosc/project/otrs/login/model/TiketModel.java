package noosc.project.otrs.login.model;

import java.util.ArrayList;

/**
 * Created by Fauziyyah Faturahma on 9/13/2017.
 */

public class TiketModel {

    private String queue;
    private String name;
    private String title;
    private String customer;
    private String tn;
    private String user;

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getTn() {
        return tn;
    }

    public void setTn(String tn) {
        this.tn = tn;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
