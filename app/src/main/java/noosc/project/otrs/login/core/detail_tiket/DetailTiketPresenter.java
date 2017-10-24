package noosc.project.otrs.login.core.detail_tiket;

import noosc.project.otrs.login.base.BasePresenter;
import noosc.project.otrs.login.model.AdminTiketModel;
import noosc.project.otrs.login.model.DetailBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Fauziyyah Faturahma on 9/12/2017.
 */

public class DetailTiketPresenter extends BasePresenter<DetailTiketView> {
    public DetailTiketPresenter(DetailTiketView view) {
        super.attachView(view);
    }


    void getMyBody(String tn) {
        getServicev2().getDetailBodyTiket(tn).enqueue(new Callback<DetailBody>() {
            @Override
            public void onResponse(Call<DetailBody> call, Response<DetailBody> response) {
                if (response.isSuccessful()) {
                    view.onSuccessAdmin(response.body());
                }
            }
            @Override
            public void onFailure(Call<DetailBody> call, Throwable t) {
                view.onError(t.getMessage());
            }
        });
    }

    void getMyBodyCust() {
        getServicev2().getDetailBodyTiket("tn").enqueue(new Callback<DetailBody>() {
            @Override
            public void onResponse(Call<DetailBody> call, Response<DetailBody> response) {
                if (response.isSuccessful()) {
                    view.onSuccessAdmin(response.body());
                }
            }
            @Override
            public void onFailure(Call<DetailBody> call, Throwable t) {
                view.onError(t.getMessage());
            }
        });
    }

}
