package ethan.com.elmusicplayer.UI;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;

import ethan.com.elmusicplayer.R;

/**
 * Created by Ethan on 4/19/2017.
 */

public abstract class DrawerActivity extends BaseActivty {
    protected DrawerLayout drawerLayout;
    protected ActionBarDrawerToggle drawerToggle;
    protected NavigationView navView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDrawerLayout();
        initNavigationView();
    }

    @Override
    protected int fetchTheme() {
        return R.style.DrawerTheme;
    }

    protected void initDrawerLayout(){
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.app_name,
                R.string.app_name
        );
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    protected void initNavigationView(){
        navView = (NavigationView) findViewById(R.id.nav_view);
        setMoreNavigationViewFeatures();
    }

    protected abstract void setMoreNavigationViewFeatures();
}
