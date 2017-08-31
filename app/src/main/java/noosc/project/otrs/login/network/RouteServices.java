package noosc.project.otrs.login.network;

import noosc.project.otrs.login.model.LoginModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
}
