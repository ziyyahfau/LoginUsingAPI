package noosc.project.otrs.login.core.utama_ticket.fragment.opentiket;

import noosc.project.otrs.login.model.AdminTiketModel;
import noosc.project.otrs.login.model.CustomerTiketModel;
import noosc.project.otrs.login.model.TiketModel;

/**
 * Created by Fauziyyah Faturahma on 9/13/2017.
 */

public interface OpenTIcketView {
    void onSuccessCust(CustomerTiketModel result);
    void onSuccessAdmin(AdminTiketModel result);
    void onError(String message);
}
