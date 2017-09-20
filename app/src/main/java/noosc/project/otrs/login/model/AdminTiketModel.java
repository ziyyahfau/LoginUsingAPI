package noosc.project.otrs.login.model;

import java.util.ArrayList;

/**
 * Created by Fauziyyah Faturahma on 9/13/2017.
 */

public class AdminTiketModel {

    private ArrayList<TiketModel> sourceOpen;
    private ArrayList<TiketModel> sourceClose;

    public ArrayList<TiketModel> getSourceOpen() {
        return sourceOpen;
    }

    public ArrayList<TiketModel> getSourceClose() {
        return sourceClose;
    }

}
