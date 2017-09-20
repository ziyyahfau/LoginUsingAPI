package noosc.project.otrs.login.core.utama_ticket.fragment.closetiket;

import noosc.project.otrs.login.base.BasePresenter;
import noosc.project.otrs.login.model.AdminTiketModel;
import noosc.project.otrs.login.model.CustomerTiketModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Fauziyyah Faturahma on 9/13/2017.
 */

public class CloseTiketPresenter extends BasePresenter<CloseTiketView> {

    public CloseTiketPresenter(CloseTiketView view) {
        super.attachView(view);
    }


    void getClosedTiket() {
        getServicev2().getClosedOpen().enqueue(new Callback<AdminTiketModel>() {
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


    void getClosedTiketCust() {
        getServicev2().getTiketOpenCust().enqueue(new Callback<CustomerTiketModel>() {
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
