package noosc.project.otrs.login.core.utama_myticket;

import noosc.project.otrs.login.model.AdminTiketModel;
import noosc.project.otrs.login.model.CustomerTiketModel;

/**
 * Created by Fauziyyah Faturahma on 9/6/2017.
 */

public interface MyTicketView {
    void onSuccessCust(CustomerTiketModel result);
    void onSuccessAdmin(AdminTiketModel result);
    void onError(String message);
}
