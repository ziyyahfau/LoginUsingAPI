package noosc.project.otrs.login.core.utama_myticket;

import android.util.Log;

import noosc.project.otrs.login.base.BasePresenter;
import noosc.project.otrs.login.core.utama_dashboard.DashboardView;
import noosc.project.otrs.login.model.AdminTiketModel;
import noosc.project.otrs.login.model.CustomerTiketModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Fauziyyah Faturahma on 9/5/2017.
 */

public class MyTicketPresenter extends BasePresenter<MyTicketView> {

    public MyTicketPresenter(MyTicketView view) {
        super.attachView(view);
    }


    void getMyTicket() {
        getServicev2().getDetailMyTiket().enqueue(new Callback<AdminTiketModel>() {
            @Override
            public void onResponse(Call<AdminTiketModel> call, Response<AdminTiketModel> response) {
                if (response.isSuccessful()) {
                    view.onSuccessAdmin(response.body());
                }
            }
            @Override
            public void onFailure(Call<AdminTiketModel> call, Throwable t) {
                view.onError(t.getMessage());
            }
        });
    }


    void getMyTicketCust(String name, String page) {
        getServicev2().getTicketByName(name, page).enqueue(new Callback<CustomerTiketModel>() {
            @Override
            public void onResponse(Call<CustomerTiketModel> call, Response<CustomerTiketModel> response) {
                if (response.isSuccessful()) {
                    view.onSuccessCust(response.body());
                }
            }
            @Override
            public void onFailure(Call<CustomerTiketModel> call, Throwable t) {
                view.onError(t.getMessage());
            }
        });
    }
}
