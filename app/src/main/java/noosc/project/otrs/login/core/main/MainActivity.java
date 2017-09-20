package noosc.project.otrs.login.core.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import io.isfaaghyth.rak.Rak;
import noosc.project.otrs.login.R;
import noosc.project.otrs.login.base.BaseActivity;
import noosc.project.otrs.login.core.login.LoginActivity;
import noosc.project.otrs.login.core.profile.ProfileActivity;
import noosc.project.otrs.login.core.utama_companyTicket.CompanyTicketActivity;
import noosc.project.otrs.login.core.utama_dashboard.DashboardActivity;
import noosc.project.otrs.login.core.utama_myticket.MyTicketActivity;
import noosc.project.otrs.login.core.utama_ticket.TicketActivity;
import noosc.project.otrs.login.core.utama_watchedTicket.WatchedTicketActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.bg_main) LinearLayout bgMain;
    @BindView(R.id.txt_username) TextView txtUsername;
    @BindView(R.id.menuDashboard) ImageView menuDashboard;
    @BindView(R.id.menuTicket) ImageView menuTicket;
    @BindView(R.id.menuCompanyTicket) ImageView menuCompanyTicket;
    @BindView(R.id.menuMyTicket) ImageView menuMyTicket;
    @BindView(R.id.menuWatchedTicket) ImageView menuWatchedTicket;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_main);

        getSupportActionBar().setIcon(R.drawable.ic_logo_depan);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        String username = Rak.grab("username"); //Rak.grab penngganti cache manager
        txtUsername.setText(username);

        if (Rak.grab("role").equals("admin")) {
            bgMain.setBackgroundColor(Color.WHITE);
        } else if (Rak.grab("role").equals("customer")) {

            menuCompanyTicket.setVisibility(View.GONE);
        }
    }


    /**
     * method on click to detail menu
     */

    @OnClick(R.id.menuDashboard)
    public void ButtonDashboard(View v) {
        startActivity(new Intent(this, DashboardActivity.class));
    }

    @OnClick(R.id.menuTicket)
    public void ButtonTicket(View v) {
        startActivity(new Intent(this, TicketActivity.class));
    }

    @OnClick(R.id.menuCompanyTicket)
    public void ButtonCompanyTicket(View v) {
        startActivity(new Intent(this, CompanyTicketActivity.class));
    }

    @OnClick(R.id.menuMyTicket)
    public void ButtonMyTicket(View v) {
        startActivity(new Intent(this, MyTicketActivity.class));
    }

    @OnClick(R.id.menuWatchedTicket)
    public void ButtonWatchedTicket(View v) {
        startActivity(new Intent(this, WatchedTicketActivity.class));
    }


    /**
     * Menu Inflater untuk show icon refresh
     */

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_profile, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_search:
                //action search
            case R.id.action_logout:
                //action logout
                Rak.entry("login", false); //false entry untuk logout
                Rak.removeAll(this);
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
            case R.id.action_profile:
                startActivity(new Intent(this, ProfileActivity.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
