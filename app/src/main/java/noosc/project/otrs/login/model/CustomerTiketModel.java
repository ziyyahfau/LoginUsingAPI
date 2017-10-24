package noosc.project.otrs.login.model;

import java.util.ArrayList;

/**
 * Created by Fauziyyah Faturahma on 9/13/2017.
 */

public class CustomerTiketModel {

    private ArrayList<TiketModel> open_ticket;
    private ArrayList<TiketModel> close_ticket;
    private ArrayList<TiketModel> OpenClient;
    private ArrayList<TiketModel> CloseClient;
    private ArrayList<TiketModel> ClientAll;
    private ArrayList<TiketModel> DashboardCust;

    public ArrayList<TiketModel> getOpen_ticket() {
        return open_ticket;
    }

    public ArrayList<TiketModel> getClosed_ticket() {
        return close_ticket;
    }

    public ArrayList<TiketModel> getMyCust_open() {
        return OpenClient;
    }

    public ArrayList<TiketModel> getMyCust_closed() {
        return CloseClient;
    }

    public ArrayList<TiketModel> getMyCust_all() {
        return ClientAll;
    }

    public ArrayList<TiketModel> getDashboardCust() {
        return DashboardCust;
    }
}

