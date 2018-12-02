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

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new Current_Bpi());

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                android.support.v4.app.Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.action_current:
                        fragment = new Current_Bpi();
                        break;

                    case R.id.action_history:
                        fragment = new Bpi_History();
                        break;

                    case R.id.action_pridiction:
                        fragment = new Bpi_Prediction();
                        break;
                }

                return loadFragment(fragment);
            }
        });
    }


    public Boolean loadFragment(android.support.v4.app.Fragment fragment)
    {
        if(fragment!=null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }

        return false;
    }
}
