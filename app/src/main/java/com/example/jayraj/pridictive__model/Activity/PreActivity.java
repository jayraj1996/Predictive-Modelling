package com.example.jayraj.pridictive__model.Activity;

import android.content.pm.ActivityInfo;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jayraj.pridictive__model.Services.FunctionService;
import com.example.jayraj.pridictive__model.R;
import com.example.jayraj.pridictive__model.utils.ForegroundTaskDelegate;
import com.example.jayraj.pridictive__model.utils.PredictiveApplication;

import java.util.List;
import java.util.Vector;

import butterknife.ButterKnife;

public class    PreActivity extends AppCompatActivity {

    @LayoutRes
    protected int getRootLayoutRes() {
        return R.layout.holder_empty;
    }

    @NonNull
    protected View rootLayout;

    protected List<ForegroundTaskDelegate> listOfForegroundTaskDelegates;

    protected FunctionService functionService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        listOfForegroundTaskDelegates = new Vector<>();

        rootLayout = getLayoutInflater().inflate(getRootLayoutRes(), null);
        setContentView(rootLayout);

        ButterKnife.bind(this);

        functionService = getPreApplication().getFunctionService();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        for (ForegroundTaskDelegate delegate : listOfForegroundTaskDelegates) {
            if (delegate != null) {
                delegate.cancel();
            }
        }
        super.onDestroy();
    }

    public final PredictiveApplication getPreApplication() {
        return (PredictiveApplication) getApplication();
    }

}
