package com.brianbridge.pulltorefreshlistview;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final String TAG = MainActivity.class.getSimpleName();
    private SwipeRefreshLayout containerSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        containerSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout_container);

        containerSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        containerSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                doRefresh();
            }
        });
    }

    private void doRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                containerSwipeRefreshLayout.setRefreshing(false);
                Toast.makeText(MainActivity.this, "Refresh Method ran.", Toast.LENGTH_SHORT).show();
            }
        }, 5000);

    }
}
