package noosc.project.otrs.login.core.utama_companyTicket;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;
import noosc.project.otrs.login.R;
import noosc.project.otrs.login.base.BaseActivity;
import noosc.project.otrs.login.core.new_ticket.NewTicketActivity;
import noosc.project.otrs.login.core.utama_companyTicket.AdapterCompany.AdapterCompanyTicket;
import noosc.project.otrs.login.core.utama_dashboard.DashboardActivity;


/**
 * Created by Fauziyyah Faturahma on 9/5/2017.
 */

public class CompanyTicketActivity extends BaseActivity<CompanyTicketPresenter> implements CompanyTicketView {

    @BindView(R.id.lst_company_ticket) RecyclerView recyclerViewCompany;
    @BindView(R.id.fab) FloatingActionButton floatingActionButton;

    @Override
    protected CompanyTicketPresenter createPresenter() {
        return new CompanyTicketPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.utama_companyticket);

        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.Companytiket) + "</font>"));

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        //button back
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false);
        recyclerViewCompany.setLayoutManager(layoutManager);

        AdapterCompanyTicket adapterCompanyTicket = new AdapterCompanyTicket();
        recyclerViewCompany.setAdapter(adapterCompanyTicket);
    }


    @OnClick(R.id.fab)
    public void fabButton(View v) {
        startActivity(new Intent(this, NewTicketActivity.class));
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
            case R.id.action_refresh:
                //action search
                return true;
            case R.id.action_search:
                //action search
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
