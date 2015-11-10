package me.undownding.baseui;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

        RecyclerView recyclerView = (RecyclerView) getLayoutInflater().inflate(R.layout.view_recyclerview, null, false);
        recyclerView.setAdapter(new RecyclerView.Adapter<Holder>() {
            @Override
            public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new Holder(new TextView(MainActivity.this));
            }

            @Override
            public void onBindViewHolder(Holder holder, int position) {
                holder.setText("Line " + (position + 1));
            }

            @Override
            public int getItemCount() {
                return 40;
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setContentView(recyclerView);
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

    private class Holder extends RecyclerView.ViewHolder {

        private String text;
        private TextView textView;

        public Holder(TextView itemView) {
            super(itemView);
            textView = itemView;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
            textView.setText(text);
            textView.setTextColor(getResources().getColor(android.R.color.black));
        }
    }
}
