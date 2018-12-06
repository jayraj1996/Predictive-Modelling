package com.example.jayraj.predictive__model.utils;

import android.support.multidex.MultiDexApplication;

import com.example.jayraj.predictive__model.Services.FunctionService;
import com.example.jayraj.predictive__model.Services.FunctionServiceImplement;
import com.example.jayraj.predictive__model.BuildConfig;

public class PredictiveApplication extends MultiDexApplication {


    private com.example.jayraj.predictive__model.Services.FunctionService FunctionService;
    public boolean check_new_session;

    private static PredictiveApplication mInstance;


    private String mGlobalCheckButton = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        //setupLeakCanary();
        setupLogLevel();
        setupMainSettings();
    }


    public boolean isCheck_new_session() {
        return check_new_session;
    }

    public void setCheck_new_session(boolean check_new_session) {
        this.check_new_session = check_new_session;
    }

    public static Boolean isInDebugMode() {
        return BuildConfig.DEBUG;
    }


    private void setupLogLevel() {
        if (isInDebugMode()) {
          //  Logger.addLogAdapter(new AndroidLogAdapter());
        }
    }

    private void setupMainSettings() {
        FunctionService = new FunctionServiceImplement(this);

    }


    public FunctionService getFunctionService() {
        return FunctionService;
    }


    public static synchronized PredictiveApplication getInstance() {
        return mInstance;
    }



}
