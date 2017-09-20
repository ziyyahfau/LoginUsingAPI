package noosc.project.otrs.login.core.utama_watchedTicket;

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
 * Created by Fauziyyah Faturahma on 9/5/2017.
 */

public class WatchedTicketActivity extends BaseActivity<WatchedTicketPresenter> implements WatchedTicketView {
    @Override
    protected WatchedTicketPresenter createPresenter() {
        return new WatchedTicketPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.utama_watchedticket);

        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.WatchedTiket) + "</font>"));

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        //button back
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
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
