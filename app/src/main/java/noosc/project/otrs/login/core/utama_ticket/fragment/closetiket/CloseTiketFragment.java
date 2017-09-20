package noosc.project.otrs.login.core.utama_ticket.fragment.closetiket;

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

/**
 * Created by Fauziyyah Faturahma on 9/13/2017.
 */

public class CloseTiketFragment extends BaseFragment<CloseTiketPresenter> implements CloseTiketView {

    @BindView(R.id.lst_close_tiket) RecyclerView lstClosedTiket;

    public CloseTiketFragment() {

    }

    @Override
    protected CloseTiketPresenter createPresenter() {
        return new CloseTiketPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext()).inflate(R.layout.fragment_tiket_close, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding(view);

        lstClosedTiket.setLayoutManager(new LinearLayoutManager(getContext()));
        if (Rak.isExist("type")) {
            if (Rak.grab("type").equals("admin")) {
                Log.d("TAG", "admin");
                presenter.getClosedTiket();//admin
            } else {
                Log.d("TAG", "cust");
                presenter.getClosedTiketCust();//cust

                //TODO 3
                //presenter.getOpenTiketCust(Rak.grab("type"));//cust
            }
        }
    }

    @Override
    public void onSuccessCust(CustomerTiketModel result) { //cust
        lstClosedTiket.setAdapter(new TiketAdapter(result.getClosed_ticket()));
    }

    @Override
    public void onSuccessAdmin(AdminTiketModel result) { //admin
        lstClosedTiket.setAdapter(new TiketAdapter(result.getSourceClose()));
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
