package noosc.project.otrs.login.core.utama_ticket;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import butterknife.BindView;
import noosc.project.otrs.login.R;
import noosc.project.otrs.login.adapter.ViewPagerAdapter;
import noosc.project.otrs.login.base.BaseActivity;
import noosc.project.otrs.login.core.utama_ticket.fragment.closetiket.CloseTiketFragment;
import noosc.project.otrs.login.core.utama_ticket.fragment.opentiket.OpenTIcketFragment;

/**
 * Created by Fauziyyah Faturahma on 9/5/2017.
 */

public class TicketActivity extends BaseActivity<TicketPresenter> implements TicketView {

    @BindView(R.id.tabs_tiket) TabLayout tabsTiket;
    @BindView(R.id.viewpager_tiket) ViewPager viewpagerTiket;

    @Override
    protected TicketPresenter createPresenter() {
        return new TicketPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.utama_ticket);

        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.Ticket) + "</font>"));

        setupViewPager(viewpagerTiket);
        tabsTiket.setupWithViewPager(viewpagerTiket);

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        //button back
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OpenTIcketFragment(), "Open");
        adapter.addFragment(new CloseTiketFragment(), "Close");
        viewPager.setAdapter(adapter);
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
