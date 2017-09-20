package noosc.project.otrs.login.network;

import noosc.project.otrs.login.model.AdminTiketModel;
import noosc.project.otrs.login.model.CustomerTiketModel;
import noosc.project.otrs.login.model.LoginModel;
import noosc.project.otrs.login.model.TiketModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Fauziyyah Faturahma on 8/30/2017.
 */

public interface RouteServices {

    @FormUrlEncoded
    @POST("/login/admin")
    Call<LoginModel> doAdminLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("/login/customer")
    Call<LoginModel> doCustomerLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    //untuk customer
    @GET("/otrs/customer")
    Call<CustomerTiketModel> getTiketOpenCust();

    //untuk admin
    @GET("/ticket/open")
    Call<AdminTiketModel> getTiketOpen();

    //untuk admin
    @GET("/ticket/close")
    Call<AdminTiketModel> getClosedOpen();


    //TODO 1
    //@GET("/otrs/customer?queue={queue_type}")
    //Call<CustomerTiketModel> getByQueueOpenTiketCust(@Query("queue_type") String queueType);
}
