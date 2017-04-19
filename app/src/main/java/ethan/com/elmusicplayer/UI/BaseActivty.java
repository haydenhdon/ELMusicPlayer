package ethan.com.elmusicplayer.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import ethan.com.elmusicplayer.R;

/**
 * Created by Ethan on 4/19/2017.
 */

public abstract class BaseActivty extends AppCompatActivity {

    protected Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(fetchTheme());
        super.onCreate(savedInstanceState);
        setContentView(fetchLayoutID());

        initToolbar();
    }

    protected abstract  int fetchLayoutID();

    protected int fetchTheme(){
        return R.style.AppTheme;
    }

    protected void initToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportParentActivityIntent() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setShowHideAnimationEnabled(true);
        }
    }

    protected void goBackToHomeLauncher(){
        Intent homeLauncherIntent = new Intent(Intent.ACTION_MAIN);
        homeLauncherIntent.addCategory(Intent.CATEGORY_HOME);
        homeLauncherIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(homeLauncherIntent);
    }
}
