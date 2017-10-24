package noosc.project.otrs.login.core.utama_dashboard;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;
import io.isfaaghyth.rak.Rak;
import noosc.project.otrs.login.R;
import noosc.project.otrs.login.adapter.DashboardAdapter;
import noosc.project.otrs.login.adapter.TiketAdapter;
import noosc.project.otrs.login.base.BaseActivity;
import noosc.project.otrs.login.core.new_ticket.NewTicketActivity;
import noosc.project.otrs.login.model.AdminTiketModel;
import noosc.project.otrs.login.model.CustomerTiketModel;

/**
 * Created by Fauziyyah Faturahma on 9/5/2017.
 */

public class DashboardActivity extends BaseActivity<DashboardPresenter> implements DashboardView {

    @BindView(R.id.lstDashboard) RecyclerView lstDashboard;
    @BindView(R.id.cardRecent) CardView cardRecent;

    public DashboardActivity() {
        //
    }

    @Override
    protected DashboardPresenter createPresenter() {
        return new DashboardPresenter(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.utama_dashboard);

        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.Dashboard) + "</font>"));

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        //button back
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        lstDashboard.setLayoutManager(new LinearLayoutManager(this));
        if (Rak.isExist("type")) {
            if (Rak.grab("type").equals("admin")) {
                Log.d("TAG", "admin");
                presenter.getDashboardAdmin();//admin
            } else {
                Log.d("TAG", "cust");
                presenter.getDashboardCust();//cust

                //TODO 3
                //presenter.getOpenTiketCust(Rak.grab("type"));//cust
            }
        }
    }


    /**
     * Menu Inflater untuk show icon refresh
     */

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
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
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSuccessCust(CustomerTiketModel result) {
        //cust
        lstDashboard.setAdapter(new DashboardAdapter(result.getDashboardCust()));
    }

    @Override
    public void onSuccessAdmin(AdminTiketModel result) {
        //admin
        lstDashboard.setAdapter(new DashboardAdapter(result.getDashboardAll()));

    }

    @Override
    public void onError(String message) {

    }
}
