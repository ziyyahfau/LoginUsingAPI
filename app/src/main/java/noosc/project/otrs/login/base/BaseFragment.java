package noosc.project.otrs.login.base;

import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;
import io.isfaaghyth.rak.Rak;

/**
 * Created by Fauziyyah Faturahma on 9/13/2017.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    protected P presenter;
    protected abstract P createPresenter();

    protected void binding(View layout) {
        ButterKnife.bind(this, layout);
        Rak.initialize(getContext());
        presenter = createPresenter();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.dettachView();
        }
    }
}
