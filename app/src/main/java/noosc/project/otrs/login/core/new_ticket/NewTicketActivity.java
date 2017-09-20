package noosc.project.otrs.login.core.new_ticket;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import noosc.project.otrs.login.R;
import noosc.project.otrs.login.base.BaseActivity;
import noosc.project.otrs.login.base.BasePresenter;

/**
 * Created by Fauziyyah Faturahma on 9/5/2017.
 */

public class NewTicketActivity extends BaseActivity<NewTicketPresenter> implements NewTicketView{
    @Override
    protected NewTicketPresenter createPresenter() {
        return new NewTicketPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_newticket);

        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.NewTicket) +  "</font>"));

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        //button back
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_refresh:
                break;
            case R.id.action_search:
                //action search
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
