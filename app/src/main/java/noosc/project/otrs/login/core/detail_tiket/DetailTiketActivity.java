package noosc.project.otrs.login.core.detail_tiket;


import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.GsonBuilder;

import butterknife.BindView;
import io.isfaaghyth.rak.Rak;
import noosc.project.otrs.login.R;
import noosc.project.otrs.login.adapter.TiketAdapter;
import noosc.project.otrs.login.base.BaseActivity;
import noosc.project.otrs.login.model.AdminTiketModel;
import noosc.project.otrs.login.model.CustomerTiketModel;
import noosc.project.otrs.login.model.DetailBody;
import noosc.project.otrs.login.model.TiketModel;

/**
 * Created by Fauziyyah Faturahma on 9/12/2017.
 */

public class DetailTiketActivity extends BaseActivity<DetailTiketPresenter> implements DetailTiketView {

    private static final String TAG = "DetailTiketActivity";

    @BindView(R.id.textDari) TextView textDari;
    @BindView(R.id.textTitle) TextView textTitle;
    @BindView(R.id.textTime) TextView textTime;
    @BindView(R.id.typeIsi) TextView typeIsi;
    @BindView(R.id.stateIsi) TextView stateIsi;
    @BindView(R.id.priorityIsi) TextView priorityIsi;
    @BindView(R.id.queueIsi) TextView queueIsi;
    @BindView(R.id.ownerIsi) TextView ownerIsi;
    @BindView(R.id.isiFrom) TextView isiFrom;
    @BindView(R.id.isiTo) TextView isiTo;
    @BindView(R.id.isiCc) TextView isiCc;
    @BindView(R.id.isiSbjk) TextView isiSbjk;
    @BindView(R.id.isiCrreated) TextView isiCrreated;
    @BindView(R.id.bodyTiket) TextView bodyTiket;


    @Override
    protected DetailTiketPresenter createPresenter() {
        return new DetailTiketPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_detail_ticket);

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        //button back
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //nerima data dari activity sebelumnya
        String tikcetJson = getIntent().getExtras().getString("ticket");
        TiketModel tiketModel = new GsonBuilder().create().fromJson(tikcetJson, TiketModel.class);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + tiketModel.getTn() + "</font>"));

        textDari.setText(tiketModel.getQueue());
        textTitle.setText(tiketModel.getTitle());
        typeIsi.setText(tiketModel.getTicket_type());
        stateIsi.setText(tiketModel.getName());
        priorityIsi.setText(tiketModel.getPriority());
        queueIsi.setText(tiketModel.getQueue());
        ownerIsi.setText(tiketModel.getUser());

        Log.v("Printed TN", "" + tiketModel.getTn());

        presenter.getMyBody(tiketModel.getTn());
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

    @Override
    public void onSuccessAdmin(DetailBody result) {

        Log.d(TAG, "onSuccessAdmin: sukses result ");

        isiFrom.setText(result.getFrom());
        isiTo.setText(result.getTo());
        isiCc.setText(result.getCc());
        isiSbjk.setText(result.getSubject());
        bodyTiket.setText(result.getBody());
        isiCrreated.setText(result.getTime());

    }


    @Override
    public void onError(String message) {
        //
    }
}
