package com.example.jayraj.predictive__model.Fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jayraj.predictive__model.Adapter.PredictionAdapter;
import com.example.jayraj.predictive__model.R;

import java.util.ArrayList;

public class Bpi_Prediction extends PredictiveFragment {

    RecyclerView recyclerView;
    ArrayList<String> highArrayList = new ArrayList<>();
    ArrayList<String> lowArrayList = new ArrayList<>();
    ArrayList<String> dayArrayList = new ArrayList<>();
    SwipeRefreshLayout swipeRefreshLayout;
    TextView day,high,low;
    Button buy;
  //  ActionBar actionBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bpi__prediction,container,false);



        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_prediction);
        buy = (Button)view.findViewById(R.id.btn_buy);
        day = (TextView)view.findViewById(R.id.txt_preday);
        high = (TextView)view.findViewById(R.id.txt_prehigh);
        low = (TextView)view.findViewById(R.id.txt_prelow);

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "want to Buy...", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView = view.findViewById(R.id.recyclerView_prediction);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        initArray();

        recyclerView.setAdapter(new PredictionAdapter(getContext(),highArrayList,lowArrayList,dayArrayList));


        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                day.setText("Loading");
                high.setText("Loading");
                low.setText("Loading");

                recyclerView.setAdapter(new PredictionAdapter(getContext(),highArrayList,lowArrayList,dayArrayList));

                day.setText("Day");
                high.setText("High");
                low.setText("Low");

                swipeRefreshLayout.setRefreshing(false);
            }
        });


        return view;
    }

    private void initArray() {

        highArrayList.add("$3961.8");
        highArrayList.add("$3802.581");
        highArrayList.add("$4266.24");
        highArrayList.add("$4521.19");
        highArrayList.add("$3902.3");

        lowArrayList.add("$3721.83");
        lowArrayList.add("$3591.621");
        lowArrayList.add("$3362.760");
        lowArrayList.add("$3439.503");
        lowArrayList.add("$3021.647");

        dayArrayList.add("Day 1");
        dayArrayList.add("Day 2");
        dayArrayList.add("Day 3");
        dayArrayList.add("Day 4");
        dayArrayList.add("Day 5");

    }

}
