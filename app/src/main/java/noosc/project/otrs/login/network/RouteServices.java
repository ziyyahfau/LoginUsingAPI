package noosc.project.otrs.login.network;

import noosc.project.otrs.login.model.AdminTiketModel;
import noosc.project.otrs.login.model.CustomerTiketModel;
import noosc.project.otrs.login.model.DetailBody;
import noosc.project.otrs.login.model.LoginModel;
import noosc.project.otrs.login.model.TiketModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

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
    @GET("/ticket/open/client/{name}")
    Call<CustomerTiketModel> getTiketOpenCust(@Path("name") String name);

    @GET("/ticket/close/client/{name}")
    Call<CustomerTiketModel> getTiketCloseCust(@Path("name") String name);

    //untuk admin
    @GET("/ticket/open")
    Call<AdminTiketModel> getTiketOpen();

    //untuk admin
    @GET("/ticket/close")
    Call<AdminTiketModel> getClosedOpen();

    //untuk admin mytiket
    @GET("/ticket/all")
    Call<AdminTiketModel> getMyTiket();

    @GET("/detail/ticket/header")
    Call<AdminTiketModel> getDetailMyTiket();

    //untuk customer mytiket
    @GET("/ticket/all/client")
    Call<CustomerTiketModel> getMyCustTiket();

    //untuk dashboard admin
    @GET("/ticket/all/dashboard")
    Call<AdminTiketModel> getDashboardAll();

    //untuk dashboard customer
    @GET("/ticket/cust/dashboard/{name}")
    Call<CustomerTiketModel> getDashboardCust(@Query("name") String name);

    //untuk admin detail_mytiket
    @GET("/detail/ticket/{tn}")
    Call<DetailBody> getDetailBodyTiket(@Path("tn") String tn);

    @GET("/ticket/cust/myticket/{name}/{page}")
    Call<CustomerTiketModel> getTicketByName(
            @Path("name") String name,
            @Path("page") String page
    );

    //TODO 1
    //@GET("/otrs/customer?queue={queue_type}")
    //Call<CustomerTiketModel> getByQueueOpenTiketCust(@Query("queue_type") String queueType);
}
