package noosc.project.otrs.login.core.utama_ticket.fragment.closetiket;

import noosc.project.otrs.login.model.AdminTiketModel;
import noosc.project.otrs.login.model.CustomerTiketModel;

/**
 * Created by Fauziyyah Faturahma on 9/13/2017.
 */

public interface CloseTiketView {
    void onSuccessCust(CustomerTiketModel result);
    void onSuccessAdmin(AdminTiketModel result);
    void onError(String message);
}
