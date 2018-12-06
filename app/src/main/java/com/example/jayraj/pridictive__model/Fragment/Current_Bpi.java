package com.example.jayraj.predictive__model.Fragment;

import android.app.ProgressDialog;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.jayraj.predictive__model.Model.HighLowResponse;
import com.example.jayraj.predictive__model.R;
import com.example.jayraj.predictive__model.utils.ForegroundTaskDelegate;

import java.lang.ref.WeakReference;

import okhttp3.OkHttpClient;


public class Current_Bpi extends PredictiveFragment {

    /* public static final String BPI_ENDPOINT = "https://api.coindesk.com/v1/bpi/currentprice.json";
     public static final String BPI_HiGH_LOW = "https://min-api.cryptocompare.com/data/pricemultifull?fsyms=BTC&tsyms=USD";*/
    private OkHttpClient okHttpClient = new OkHttpClient();
    private ProgressDialog progressDialog;
    TextView usd, high, low;
    SwipeRefreshLayout swipeRefreshLayout;
    private HighLowDelgate highLowDelgate;
   // ActionBar actionBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view_layout = inflater.inflate(R.layout.fragment_current__bpi, container, false);

     //   actionBar = getActivity().getActionBar();
     //   actionBar.setTitle("Current BPI");

        usd = (TextView) view_layout.findViewById(R.id.usd);
        high = (TextView) view_layout.findViewById(R.id.high);
        low = (TextView) view_layout.findViewById(R.id.low);
        swipeRefreshLayout = (SwipeRefreshLayout) view_layout.findViewById(R.id.swipe);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("BPI Loading");
        progressDialog.setMessage("Wait ...");


        // Inflate the layout for this fragment

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                usd.setText("Loading");
                high.setText("Loading");
                low.setText("Loading");

                preActivity.getPreApplication().getFunctionService().getHIIGHLOW(
                        "BTC", "USD"
                        , highLowDelgate);
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        return view_layout;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        highLowDelgate = new HighLowDelgate(this);
        listOfForegroundTaskDelegates.add(highLowDelgate);


        preActivity.getPreApplication().getFunctionService().getHIIGHLOW(
                "BTC", "USD"
                , highLowDelgate);
    }


    public class HighLowDelgate extends ForegroundTaskDelegate<HighLowResponse> {
        private final WeakReference<Current_Bpi> fragmentWeakReference;

        public HighLowDelgate(Current_Bpi fragment) {
            super(fragment.preActivity);
            fragmentWeakReference = new WeakReference<>(fragment);
        }


        @Override
        public void onPostExecute(HighLowResponse highLowResponse) {
            super.onPostExecute(highLowResponse);
            Current_Bpi fragment = fragmentWeakReference.get();
            if (fragment != null &&
                    !fragment.isDetached() &&
                    !fragment.isRemoving() &&
                    highLowResponse != null) {
                usd.setText(highLowResponse.getDISPLAY().getBTC().getUSD().getPRICE());
                high.setText(highLowResponse.getDISPLAY().getBTC().getUSD().getHIGHDAY());
                low.setText(highLowResponse.getDISPLAY().getBTC().getUSD().getLOWDAY());
            }
        }
    }

}
