package noosc.project.otrs.login.core.utama_ticket.fragment.opentiket;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import io.isfaaghyth.rak.Rak;
import noosc.project.otrs.login.R;
import noosc.project.otrs.login.adapter.TiketAdapter;
import noosc.project.otrs.login.base.BaseFragment;
import noosc.project.otrs.login.model.AdminTiketModel;
import noosc.project.otrs.login.model.CustomerTiketModel;
import noosc.project.otrs.login.model.TiketModel;

/**
 * Created by Fauziyyah Faturahma on 9/13/2017.
 */

public class OpenTIcketFragment extends BaseFragment<OpenTiketPresenter> implements OpenTIcketView {

    @BindView(R.id.lst_open_tiket) RecyclerView lstOpenTiket;

    public OpenTIcketFragment() {
    }

    @Override
    protected OpenTiketPresenter createPresenter() {
        return new OpenTiketPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext()).inflate(R.layout.fragment_tiket_open, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding(view);
        lstOpenTiket.setLayoutManager(new LinearLayoutManager(getContext()));
        if (Rak.isExist("type")) {
            if (Rak.grab("type").equals("admin")) {
                Log.d("TAG", "admin");
                presenter.getOpenTiket();//admin
            } else {
                Log.d("TAG", "cust");
                presenter.getOpenTiketCust();//cust

                //TODO 3
                //presenter.getOpenTiketCust(Rak.grab("type"));//cust
            }
        }
    }

    @Override
    public void onSuccessCust(CustomerTiketModel result) { //cust
        lstOpenTiket.setAdapter(new TiketAdapter(result.getOpen_ticket()));
    }

    @Override
    public void onSuccessAdmin(AdminTiketModel result) { //admin
        lstOpenTiket.setAdapter(new TiketAdapter(result.getSourceOpen()));
    }

    @Override
    public void onError(String message) {
        new AlertDialog.Builder(getContext())
                .setTitle(getString(R.string.app_name))
                .setMessage(message)
                .setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override public void onClick(DialogInterface dialog, int which) {}
                })
                .show();
    }
}
