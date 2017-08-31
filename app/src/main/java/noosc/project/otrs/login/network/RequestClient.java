package noosc.project.otrs.login.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import noosc.project.otrs.login.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fauziyyah Faturahma on 8/30/2017.
 */

public class RequestClient {
    public static Retrofit getClient() {
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
