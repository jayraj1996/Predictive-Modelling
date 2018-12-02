package com.example.jayraj.pridictive__model.utils;

import java.io.IOException;
import java.util.logging.Logger;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RetryInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        // try the request
        Response response = chain.proceed(request);

        int tryCount = 0;
        int maxLimit = 1; //Set your max limit here

        while (!response.isSuccessful() && tryCount < maxLimit) {

          //  Logger.d("Request failed - Retry " + tryCount + 1);

            tryCount++;

            // retry the request
            response = chain.proceed(request);
        }

        // otherwise just pass the original response on
        return response;
    }
}
