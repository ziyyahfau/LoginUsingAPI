package noosc.project.otrs.login.model;

import java.util.ArrayList;

/**
 * Created by Fauziyyah Faturahma on 9/13/2017.
 */

public class CustomerTiketModel {

    private ArrayList<TiketModel> open_ticket;
    private ArrayList<TiketModel> close_ticket;

    public ArrayList<TiketModel> getOpen_ticket() {
        return open_ticket;
    }

    public ArrayList<TiketModel> getClosed_ticket() {
        return close_ticket;
    }

}
