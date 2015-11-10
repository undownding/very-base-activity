package me.undownding.baseui.library;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;

import moe.feng.material.statusbar.TranslucentSBActivity;

/**
 * Created by undownding on 15-11-10.
 */
public class VeryBaseActivity extends TranslucentSBActivity{

    private boolean toolbarAutoHidden;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_very_base);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    public boolean isToolbarAutoHidden() {
        return toolbarAutoHidden;
    }

    // FIXME: 15-11-10 something wrong with shadow
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
}
