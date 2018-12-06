package com.example.jayraj.predictive__model.Services;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.jayraj.predictive__model.Model.HighLowResponse;
import com.example.jayraj.predictive__model.utils.PredictiveApplication;
import com.example.jayraj.predictive__model.utils.RetryInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FunctionServiceImplement implements FunctionService{
    private final HttpLoggingInterceptor defaultLogging;
    private static final long timeOut = 90; // 90 seconds
    private final Gson defaultGson;

    public FunctionServiceImplement(PredictiveApplication application) {
        this.defaultLogging = newDefaultLogging();
        defaultGson = newDefaultGson();
    }

    @Override
    public void getHIIGHLOW(String fsyms, String tsyms, @NonNull final CallbackService<HighLowResponse> callbackService) {
        Call<HighLowResponse> loginResponseCall =
                getServiceNoToken().getHIIGHLOW(fsyms,tsyms);

        callbackService.setCall(loginResponseCall);

        callbackService.onPreExecute();
        loginResponseCall.enqueue(new Callback<HighLowResponse>() {
            @Override
            public void onResponse(Call<HighLowResponse> call, Response<HighLowResponse> response) {
                if (response.isSuccessful()) {
                    HighLowResponse loginResponse = response.body();
                    callbackService.onPostExecute(loginResponse);
                }

            }

            @Override
            public void onFailure(Call<HighLowResponse> call, Throwable t) {

                Log.e("Error =",t+"");
            }
        });
    }


    private RetrofitServices getServiceNoToken() {
        return getService(null);
    }


    private RetrofitServices getService(String token) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(new AddHeaderInterceptor())
                .addInterceptor(defaultLogging)
                .addInterceptor(new RetryInterceptor())
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitServices.BPI_HiGH_LOW)
                .addConverterFactory(GsonConverterFactory.create(defaultGson))
                .client(client)
                .build();

        return retrofit.create(RetrofitServices.class);
    }

    private HttpLoggingInterceptor newDefaultLogging() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        if (PredictiveApplication.isInDebugMode()) {
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }
        return logging;
    }

    private Gson newDefaultGson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }

    /*private Gson newDefaultGson() {
        return new GsonBuilder()
                .registerTypeAdapter(Date.class, new GsonDateFormatAdapter())
                .setLenient()
                .create();
    }*/
}
