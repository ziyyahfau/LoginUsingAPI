package noosc.project.otrs.login.core.detail_tiket;


import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import noosc.project.otrs.login.R;
import noosc.project.otrs.login.base.BaseActivity;

/**
 * Created by Fauziyyah Faturahma on 9/12/2017.
 */

public class DetailTiketActivity extends BaseActivity<DetailTiketPresenter> implements DetailTiketView {


    @Override
    protected DetailTiketPresenter createPresenter() {
        return new DetailTiketPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_detail_ticket);

        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.DetailTicket) +  "</font>"));

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        //button back
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    /**
     * Menu Inflater untuk show icon refresh
     */

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_close_ticket, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_closeticket:
                //action close ticket
        }

        return super.onOptionsItemSelected(item);
    }
}
