package noosc.project.otrs.login.core.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import io.isfaaghyth.rak.Rak;
import noosc.project.otrs.login.R;
import noosc.project.otrs.login.base.BaseActivity;
import noosc.project.otrs.login.core.main.MainActivity;
import noosc.project.otrs.login.model.LoginModel;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.edt_email) EditText edtEmail;
    @BindView(R.id.edt_password) EditText edtPassword;

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_login);
        isLogin();
    }

    private void isLogin() {
        if (!Rak.isExist("login")) return;
        if (Rak.grab("login")){
            gotoMain();
        }
    }

    private void gotoMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @OnClick(R.id.btn_login_admin)
    public void onBtnLoginAdminClicked() {
        Rak.entry("role", "admin");
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        presenter.doAdminLogin(email, password);
    }

    @OnClick(R.id.btn_login_customer)
    public void onBtnLoginCustomerClicked() {
        Rak.entry("role", "customer");
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        presenter.doCustomerLogin(email, password);
    }

    @Override
    public void onSuccess(LoginModel result) {
        if (Rak.grab("role").equals("admin")){
            if (result.getStatus().equals("true")) {
                Rak.entry("login", true);
                Rak.entry("username", result.getUsername());
                Rak.entry("type", "admin");
                gotoMain();
            } else {
                showAlert(result.getMessage());
            }
        } else if (Rak.grab("role").equals("customer")){
            if (result.getStatus().equals("true")) {
                Rak.entry("login", true);
                Rak.entry("username", result.getUsername());
                Rak.entry("name_company", result.getName_company());
                Rak.entry("email", result.getEmail());
                Rak.entry("type", result.getType());
                gotoMain();
            }
            else {
                showAlert(result.getMessage());
            }
        }
    }


    @Override
    public void onError(String message) {
        showAlert(message);
    }
}
