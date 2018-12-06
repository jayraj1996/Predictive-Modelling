package com.example.jayraj.predictive__model.Services;

import android.os.AsyncTask;

import retrofit2.Call;

public interface CallbackService<Result extends Object> {
    void setAsyncTask(AsyncTask task);

    void setCall(Call call);

    void cancel();

    void onPreExecute();

    void onPostExecute(Result result);
    void onPostExecute(Result result,Throwable throwable);


}
