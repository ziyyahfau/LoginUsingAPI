package noosc.project.otrs.login.core.utama_dashboard;

import noosc.project.otrs.login.base.BasePresenter;
import noosc.project.otrs.login.model.AdminTiketModel;
import noosc.project.otrs.login.model.CustomerTiketModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Fauziyyah Faturahma on 9/5/2017.
 */

public class DashboardPresenter extends BasePresenter<DashboardView> {
    public DashboardPresenter(DashboardView view) {
        super.attachView(view);
    }

    void getDashboardAdmin() {
        getServicev2().getDashboardAll().enqueue(new Callback<AdminTiketModel>() {
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


    void getDashboardCust() {
        getServicev2().getDashboardCust("name").enqueue(new Callback<CustomerTiketModel>() {
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
