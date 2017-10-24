package noosc.project.otrs.login.model;

import java.util.ArrayList;

/**
 * Created by Fauziyyah Faturahma on 9/13/2017.
 */

public class AdminTiketModel {

    private ArrayList<TiketModel> sourceOpen;
    private ArrayList<TiketModel> sourceClose;
    private ArrayList<TiketModel> sourceAll;
    private ArrayList<TiketModel> detailTicketHeader;
    private ArrayList<TiketModel> DashboardAll;
    private DetailBody detailTicketBody;

    public ArrayList<TiketModel> getSourceOpen() {
        return sourceOpen;
    }

    public ArrayList<TiketModel> getSourceClose() {
        return sourceClose;
    }

    public ArrayList<TiketModel> getMy_ticket() {
        return sourceAll;
    }

    public ArrayList<TiketModel> getDetailMyTiket() {return detailTicketHeader;}

    public ArrayList<TiketModel> getDashboardAll() {return DashboardAll;}

    public DetailBody getDetailBodyTiket() {return detailTicketBody;}

}
