package com.example.jayraj.predictive__model.utils;


import android.os.AsyncTask;

import com.example.jayraj.predictive__model.Activity.PreActivity;
import com.example.jayraj.predictive__model.Services.CallbackService;

import java.lang.ref.WeakReference;

import retrofit2.Call;

public class ForegroundTaskDelegate<Result extends Object> implements CallbackService<Result> {

    protected final WeakReference<PreActivity> activityWeakReference;
    private AsyncTask task;
    private Call call;


    public ForegroundTaskDelegate(PreActivity activity) {
        activityWeakReference = new WeakReference<>(activity);
    }



    @Override
    public void setAsyncTask(AsyncTask task) {
        cancelAsyncTask();
        this.task = task;
    }

    @Override
    public void setCall(Call call) {
        cancelCall();
        this.call = call;
    }

    @Override
    public void cancel() {
        cancelAsyncTask();
        cancelCall();
    }

    protected void cancelAsyncTask() {
        if (task != null && !task.isCancelled()) {
            task.cancel(true);
        }
    }

    protected void cancelCall() {
        if (call != null && !call.isCanceled()) {
            call.cancel();
        }
    }

    /*protected void showProgress() {
        PreActivity activity = activityWeakReference.get();
        if (activity != null && !activity.isFinishing()) {
            activity.showProgressDialog();
        }
    }

    protected void dismissProgress() {
        PreActivity activity = activityWeakReference.get();
        if (activity != null && !activity.isFinishing()) {
            activity.dismissProgressDialog();
        }
    }*/



    @Override
    public void onPreExecute() {
   //     showProgress();
    }

    @Override
    public void onPostExecute(Result result) {
        //dismissProgress();

        if (result == null ) {
        }


    }

    @Override
    public void onPostExecute(Result result, Throwable throwable) {
      //  dismissProgress();

        if (result == null ) {
        }
    }

}

