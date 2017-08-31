package noosc.project.otrs.login.base;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.isfaaghyth.rak.Rak;
import noosc.project.otrs.login.R;

/**
 * Created by Fauziyyah Faturahma on 8/30/2017.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P presenter;
    protected abstract P createPresenter();

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void binding(int layout) {
        setContentView(layout);
        ButterKnife.bind(this);
        Rak.initialize(this);
        presenter = createPresenter();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.dettachView();
        }
    }

    protected void showAlert(String message) {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.app_name))
                .setMessage(message)
                .setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override public void onClick(DialogInterface dialog, int which) {}
                })
                .show();
    }
}
