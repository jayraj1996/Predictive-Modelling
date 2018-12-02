package com.example.jayraj.pridictive__model.Fragment;

import android.app.ProgressDialog;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.jayraj.pridictive__model.Model.HighLowResponse;
import com.example.jayraj.pridictive__model.R;
import com.example.jayraj.pridictive__model.utils.ForegroundTaskDelegate;

import java.lang.ref.WeakReference;

import okhttp3.OkHttpClient;


public class Current_Bpi extends PridictiveFragment {

    /* public static final String BPI_ENDPOINT = "https://api.coindesk.com/v1/bpi/currentprice.json";
     public static final String BPI_HiGH_LOW = "https://min-api.cryptocompare.com/data/pricemultifull?fsyms=BTC&tsyms=USD";*/
    private OkHttpClient okHttpClient = new OkHttpClient();
    private ProgressDialog progressDialog;
    TextView usd, high, low;
    SwipeRefreshLayout swipeRefreshLayout;
    private HighLowDelgate highLowDelgate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view_layout = inflater.inflate(R.layout.fragment_current__bpi, container, false);

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

    /* private void load() {

         Request request = new Request.Builder()
                 .url(BPI_ENDPOINT)
                 .build();

         progressDialog.show();

         okHttpClient.newCall(request).enqueue(new Callback() {
             @Override
             public void onFailure(Call call, IOException e) {
                 Toast.makeText(getActivity(), "Error during BPI loading : "
                         + e.getMessage(), Toast.LENGTH_SHORT).show();
             }

             @Override
             public void onResponse(Call call, Response response) throws IOException {

                 final String body = response.body().string();

                 progressDialog.dismiss();
                 parseBpiResponse(body);


             }
         });

     }
 */
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

   /* private void parseBpiResponse(String body) {
        try {
            StringBuilder builder = new StringBuilder();

            JSONObject jsonObject = new JSONObject(body);
            JSONObject bpiObject = jsonObject.getJSONObject("bpi");
            JSONObject usdObject = bpiObject.getJSONObject("USD");
            usd.setText(builder.append(usdObject.getString("rate")).append("$"));

            //    txt.setText(builder.toString());

        } catch (Exception e) {

        }

    }
*/
   /* private void high_low() {

        Request request = new Request.Builder()
                .url(BPI_HiGH_LOW)
                .build();

        progressDialog.show();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getActivity(), "Error during High Low loading : "
                        + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                final String body = response.body().string();

                progressDialog.dismiss();
                parseBpiResponse1(body);


            }
        });

    }*/


   /* private void parseBpiResponse1(String body) {
        try {
            StringBuilder builder = new StringBuilder();

            JSONObject jsonObject = new JSONObject(body);
            JSONObject bpiObject = jsonObject.getJSONObject("BTC");
            JSONObject usdObject = bpiObject.getJSONObject("USD");
            high.setText(builder.append(usdObject.getString("HIGHDAY")).append("$"));
            low.setText(builder.append(usdObject.getString("LOWDAY")).append("$"));

            //    txt.setText(builder.toString());

        } catch (Exception e) {

        }

    }
*/

}
