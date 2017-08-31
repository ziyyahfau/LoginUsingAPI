package noosc.project.otrs.login.core.login;

import noosc.project.otrs.login.model.LoginModel;

/**
 * Created by Fauziyyah Faturahma on 8/30/2017.
 */

public interface LoginView {
    void onSuccess(LoginModel result);
    void onError(String message);
}
