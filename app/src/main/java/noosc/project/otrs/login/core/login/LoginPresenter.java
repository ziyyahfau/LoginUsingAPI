package noosc.project.otrs.login.core.login;

import noosc.project.otrs.login.base.BasePresenter;
import noosc.project.otrs.login.model.LoginModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Fauziyyah Faturahma on 8/30/2017.
 */

public class LoginPresenter extends BasePresenter<LoginView> {
    public LoginPresenter(LoginView view) {
        super.attachView(view);
    }

    void doAdminLogin(String email, String password) {
        getService().doAdminLogin(email, password).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.isSuccessful()) {
                    view.onSuccess(response.body());
                }
            }
            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                view.onError(t.getMessage());
            }
        });
    }

    void doCustomerLogin(String email, String password) {
        getService().doCustomerLogin(email, password).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                if (response.isSuccessful()) {
                    view.onSuccess(response.body());
                }
            }
            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                view.onError(t.getMessage());
            }
        });
    }
}
