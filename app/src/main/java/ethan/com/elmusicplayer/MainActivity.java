package ethan.com.elmusicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ethan.com.elmusicplayer.UI.DrawerActivity;

public class MainActivity extends DrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int fetchLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void setMoreNavigationViewFeatures() {

    }

}
