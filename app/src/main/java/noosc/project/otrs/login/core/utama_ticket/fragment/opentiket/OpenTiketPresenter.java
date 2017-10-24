package noosc.project.otrs.login.core.utama_ticket.fragment.opentiket;

import noosc.project.otrs.login.base.BasePresenter;
import noosc.project.otrs.login.model.AdminTiketModel;
import noosc.project.otrs.login.model.CustomerTiketModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Fauziyyah Faturahma on 9/13/2017.
 */

public class OpenTiketPresenter extends BasePresenter<OpenTIcketView> {

    public OpenTiketPresenter(OpenTIcketView view) {
        super.attachView(view);
    }

    void getOpenTiket() {
        getServicev2().getTiketOpen().enqueue(new Callback<AdminTiketModel>() {
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


    void getOpenTiketCust(String name) {
        getServicev2().getTiketOpenCust(name).enqueue(new Callback<CustomerTiketModel>() {
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

    //TODO 2
//    void getOpenTiketCust(String queueType) {
//        getServicev2().getByQueueOpenTiketCust(queueType).enqueue(new Callback<CustomerTiketModel>() {
//            @Override
//            public void onResponse(Call<CustomerTiketModel> call, Response<CustomerTiketModel> response) {
//                if (response.isSuccessful()) {
//                    view.onSuccessCust(response.body());
//                }
//            }
//            @Override
//            public void onFailure(Call<CustomerTiketModel> call, Throwable t) {
//                view.onError(t.getMessage());
//            }
//        });
//    }
}
