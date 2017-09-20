package noosc.project.otrs.login.core.profile;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import io.isfaaghyth.rak.Rak;
import noosc.project.otrs.login.R;
import noosc.project.otrs.login.base.BaseActivity;
import noosc.project.otrs.login.model.LoginProfile;

/**
 * Created by Fauziyyah Faturahma on 8/31/2017.
 */

public class ProfileActivity extends BaseActivity<ProfilePresenter> implements ProfileView {
    @BindView(R.id.company_name) TextView companyName;
    @BindView(R.id.nama_Profile) TextView namaProfile;
    @BindView(R.id.email_profile) TextView emailProfile;


    @Override
    protected ProfilePresenter createPresenter() {
        return new ProfilePresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_profile);

        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.ProfileUser) +  "</font>"));

        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        upArrow.setColorFilter(getResources().getColor(R.color.colorBlack), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        //button back
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        //View detail profile with role
        if (Rak.grab("role").equals("customer")) {
            String company_name = Rak.grab("name_company");
            companyName.setText(company_name);
            String nama_profile = Rak.grab("username");
            namaProfile.setText(nama_profile);
            String email_profile = Rak.grab("email");
            emailProfile.setText(email_profile);
        }
        else if (Rak.grab("role").equals("admin")) {
            String nama_profile = Rak.grab("username");
            namaProfile.setText(nama_profile);
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
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_search:
                //action search
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
