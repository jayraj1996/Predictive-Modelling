package com.example.jayraj.pridictive__model.Services;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AddHeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("Content-type", "application/json");
        builder.addHeader("Accept", "application/json");

        return chain.proceed(builder.build());
    }
}
