package noosc.project.otrs.login.base;

import noosc.project.otrs.login.network.RequestClient;
import noosc.project.otrs.login.network.RouteServices;

/**
 * Created by Fauziyyah Faturahma on 8/30/2017.
 */

public class BasePresenter<V> {
    public V view;
    private RouteServices service;

    public void attachView(V view) {
        this.view = view;
        service = RequestClient.getClient().create(RouteServices.class);
    }

    public void dettachView() {
        this.view = null;
    }

    public RouteServices getService() {
        return service;
    }

}