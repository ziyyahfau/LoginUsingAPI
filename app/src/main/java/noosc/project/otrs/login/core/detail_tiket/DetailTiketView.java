package noosc.project.otrs.login.core.detail_tiket;

import noosc.project.otrs.login.model.AdminTiketModel;
import noosc.project.otrs.login.model.CustomerTiketModel;
import noosc.project.otrs.login.model.DetailBody;

/**
 * Created by Fauziyyah Faturahma on 9/12/2017.
 */

public interface DetailTiketView {
//    void onSuccessCust(CustomerTiketModel result);
    void onSuccessAdmin(DetailBody result);
    void onError(String message);
}
