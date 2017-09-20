package noosc.project.otrs.login.base;

import io.isfaaghyth.rak.Rak;
import noosc.project.otrs.login.network.RequestClient;
import noosc.project.otrs.login.network.RouteServices;

/**
 * Created by Fauziyyah Faturahma on 8/30/2017.
 */

public class BasePresenter<V> {
    public V view;

    public void attachView(V view) {
        this.view = view;
    }

    public void dettachView() {
        this.view = null;
    }

    public RouteServices getService() {
        return RequestClient.getClient().create(RouteServices.class);
    }

    public RouteServices getServicev2() {
        return RequestClient.getClientv2().create(RouteServices.class);
    }

}