package com.example.jayraj.pridictive__model.Activity;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.jayraj.pridictive__model.Fragment.Bpi_History;
import com.example.jayraj.pridictive__model.Fragment.Bpi_Prediction;
import com.example.jayraj.pridictive__model.Fragment.Current_Bpi;
import com.example.jayraj.pridictive__model.R;

public class MainActivity extends PreActivity {
    String page_name;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        loadFragment(new Current_Bpi(),"Today's rate");

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                android.support.v4.app.Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.action_current:
                        fragment = new Current_Bpi();
                        page_name= "Today's rate";
                        break;

                    case R.id.action_history:
                        fragment = new Bpi_History();
                        page_name="History";
                        break;

                    case R.id.action_pridiction:
                        fragment = new Bpi_Prediction();
                        page_name="Prediction";
                        break;
                }

                return loadFragment(fragment,page_name);
            }
        });
    }


    public Boolean loadFragment(android.support.v4.app.Fragment fragment,String page_name)
    {
        if(fragment!=null)
        {
            getSupportActionBar().setTitle(page_name);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }

        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}