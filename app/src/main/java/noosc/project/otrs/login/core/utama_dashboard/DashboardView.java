package noosc.project.otrs.login.core.utama_dashboard;

import noosc.project.otrs.login.model.AdminTiketModel;
import noosc.project.otrs.login.model.CustomerTiketModel;

/**
 * Created by Fauziyyah Faturahma on 9/5/2017.
 */

public interface DashboardView {

    void onSuccessCust(CustomerTiketModel result);
    void onSuccessAdmin(AdminTiketModel result);
    void onError(String message);
}
