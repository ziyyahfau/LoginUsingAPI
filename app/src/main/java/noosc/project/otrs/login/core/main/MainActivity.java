package noosc.project.otrs.login.core.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import io.isfaaghyth.rak.Rak;
import noosc.project.otrs.login.R;
import noosc.project.otrs.login.base.BaseActivity;
import noosc.project.otrs.login.core.login.LoginActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.bg_main) LinearLayout bgMain;
    @BindView(R.id.txt_username) TextView txtUsername;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_main);
        String username = Rak.grab("username");
        txtUsername.setText(username);
        if (Rak.grab("role").equals("admin")) {
            bgMain.setBackgroundColor(Color.BLACK);
        } else if (Rak.grab("role").equals("customer")) {
            bgMain.setBackgroundColor(Color.GREEN);
        }
    }

    @OnClick(R.id.btn_logout)
    public void onBtnLogoutClicked() {
        Rak.entry("login", false);
        Rak.removeAll(this);
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
