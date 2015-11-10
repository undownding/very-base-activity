package me.undownding.baseui;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.undownding.baseui.library.VeryBaseActivity;
import moe.feng.material.statusbar.TranslucentSBActivity;
import moe.feng.material.statusbar.util.ViewHelper;

public class MainActivity extends VeryBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            View view = findViewById(R.id.status_bar_view);
            if (ViewHelper.isChrome()) {
                view.setVisibility(View.GONE);
            } else {
                view.getLayoutParams().height = ViewHelper.getStatusBarHeight(this);
                view.invalidate();
            }
        }
        TextView tv = new TextView(this);
        tv.setText("test");
        ((ViewGroup) findViewById(R.id.verybase_content)).addView(tv);

        tv.setHeight(5000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}