package noosc.project.otrs.login.core.utama_myticket;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import io.isfaaghyth.rak.Rak;
import noosc.project.otrs.login.R;
import noosc.project.otrs.login.adapter.TiketAdapter;
import noosc.project.otrs.login.base.BaseActivity;
import noosc.project.otrs.login.core.new_ticket.NewTicketActivity;
import noosc.project.otrs.login.model.AdminTiketModel;
import noosc.project.otrs.login.model.CustomerTiketModel;
import noosc.project.otrs.login.model.TiketModel;
import noosc.project.otrs.login.util.EndlessScrollListener;

/**
 * Created by Fauziyyah Faturahma on 9/5/2017.
 */

public class MyTicketActivity extends BaseActivity<MyTicketPresenter> implements MyTicketView {

    @BindView(R.id.lst_my_ticket) RecyclerView lstMyTiket;
    @BindView(R.id.fab) FloatingActionButton floatingActionButton;

    private TiketAdapter adapter;
    private ArrayList<TiketModel> tiket;

    String typeUser;
    int totalItemCount = 0;
    int lastVisibleItem;
    int pageCount = 1;

    public MyTicketActivity() {
        //
    }

    @Override
    protected MyTicketPresenter createPresenter() {
        return new MyTicketPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.utama_myticket);

        Rak.initialize(this);

        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.MyTiket) + "</font>"));


        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        //button back
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        typeUser = "'" + Rak.grab("type").toString() + "'";

        lstMyTiket.setLayoutManager(new LinearLayoutManager(this));
        tiket = new ArrayList<>();
        adapter = new TiketAdapter(tiket);

        if (Rak.isExist("type")) {
            if (Rak.grab("type").equals("admin")) {
                Log.d("TAG", "admin");
                presenter.getMyTicket();//admin
            } else {
                lstMyTiket.setAdapter(adapter);
                presenter.getMyTicketCust(typeUser, String.valueOf(pageCount));//cust

                lstMyTiket.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                        totalItemCount = linearLayoutManager.getItemCount();
                        lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                        if (totalItemCount <= (lastVisibleItem + tiket.size())) {
                            try{
                                presenter.getMyTicketCust(typeUser, String.valueOf(pageCount++));
                            } catch (Exception ignored) {}
                        }
                    }
                });

                //TODO 3
                //presenter.getOpenTiketCust(Rak.grab("type"));//cust
            }
        }
    }

    @OnClick(R.id.fab)
    public void fabButton(View v) {
        startActivity(new Intent(this, NewTicketActivity.class));
    }

    @Override
    public void onSuccessCust(CustomerTiketModel result) { //cust
        tiket.addAll(result.getMyCust_all());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccessAdmin(AdminTiketModel result) { //admin
        lstMyTiket.setAdapter(new TiketAdapter(result.getDetailMyTiket()));
    }

    @Override
    public void onError(String message) {
        //
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
