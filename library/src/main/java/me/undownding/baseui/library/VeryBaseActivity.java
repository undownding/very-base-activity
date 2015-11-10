package me.undownding.baseui.library;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import moe.feng.material.statusbar.TranslucentSBActivity;
import moe.feng.material.statusbar.util.ViewHelper;

/**
 * Created by undownding on 15-11-10.
 */
public class VeryBaseActivity extends TranslucentSBActivity{

    private boolean toolbarAutoHidden;
    private Toolbar toolbar;
    private NestedScrollView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_very_base);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        content = (NestedScrollView) findViewById(R.id.verybase_content);

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            View view = findViewById(R.id.status_bar_view);
            if (ViewHelper.isChrome()) {
                view.setVisibility(View.GONE);
            } else {
                view.getLayoutParams().height = ViewHelper.getStatusBarHeight(this);
                view.invalidate();
            }
        }
    }

    public boolean isToolbarAutoHidden() {
        return toolbarAutoHidden;
    }

    public void setToolbarAutoHidden(boolean toolbarAutoHidden) {
        this.toolbarAutoHidden = toolbarAutoHidden;
        AppBarLayout.LayoutParams params =
                (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        if (isToolbarAutoHidden()) {
            params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                    | AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        } else {
            params.setScrollFlags(0);
        }
        toolbar.invalidate();
    }

    @Override
    public final void setContentView(int layoutResID) {
        final View view = getLayoutInflater().inflate(layoutResID, content, false);
        setContentView(view);
    }

    @Override
    public final void setContentView(View view) {
        setContentView(view, new NestedScrollView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        );
    }

    @Override
    public final void setContentView(View view, ViewGroup.LayoutParams params) {
        content.addView(view, params);
    }
}
