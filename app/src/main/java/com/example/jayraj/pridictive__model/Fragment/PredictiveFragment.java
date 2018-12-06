package com.example.jayraj.predictive__model.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jayraj.predictive__model.Activity.PreActivity;
import com.example.jayraj.predictive__model.R;
import com.example.jayraj.predictive__model.utils.ForegroundTaskDelegate;

import java.util.List;
import java.util.Vector;

import butterknife.ButterKnife;


public class PredictiveFragment extends Fragment {


    @LayoutRes
    protected int getRootLayoutRes() {
        return R.layout.holder_empty;
    }

    protected List<ForegroundTaskDelegate> listOfForegroundTaskDelegates;
    public PreActivity preActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof PreActivity) {
            preActivity = (PreActivity) context;
        }
    }

    public void showSnakeBar( ){
        Snackbar.make(  getView().getRootView(), "Oops !! Please check your Internet connection", Snackbar.LENGTH_LONG)
                .setAction("CLOSE", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                .show();

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(getRootLayoutRes(), container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listOfForegroundTaskDelegates = new Vector<>();
    }

    @Override
    public void onDestroyView() {
        for (ForegroundTaskDelegate delegate : listOfForegroundTaskDelegates) {
            if (delegate != null) {
                delegate.cancel();
            }
        }
        super.onDestroyView();
    }
}
