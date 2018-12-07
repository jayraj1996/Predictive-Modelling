package com.example.jayraj.predictive__model.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jayraj.predictive__model.R;

import java.util.ArrayList;
import java.util.Random;

public class PredictionAdapter extends RecyclerView.Adapter<PredictionAdapter.ViewHolder> {

    Context context;
    ArrayList<String> highArrayList;
    ArrayList<String> lowArrayList;
    ArrayList<String> dayArrayList;
    Random random;

    public PredictionAdapter(Context context, ArrayList<String> highArrayList, ArrayList<String> lowArrayList, ArrayList<String> dayArrayList) {

        this.context = context;
        this.highArrayList = highArrayList;
        this.lowArrayList = lowArrayList;
        this.dayArrayList = dayArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.adapter_prediction,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txt_day.setText(dayArrayList.get(position));
        random = new Random();
        int index = random.nextInt(highArrayList.size());
        holder.txt_high.setText(highArrayList.get(index));

        int index1 = random.nextInt(lowArrayList.size());
        holder.txt_low.setText(lowArrayList.get(index1));

        Log.e("highDay =",highArrayList.get(index));
    }

    @Override
    public int getItemCount() {
        return dayArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_day,txt_high,txt_low;

        public ViewHolder(View itemView) {
            super(itemView);

            txt_day = (TextView)itemView.findViewById(R.id.txt_day);
            txt_high = (TextView)itemView.findViewById(R.id.txt_high);
            txt_low = (TextView)itemView.findViewById(R.id.txt_low);

        }
    }
}
