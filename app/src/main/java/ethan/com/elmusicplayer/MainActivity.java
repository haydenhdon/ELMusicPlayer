package ethan.com.elmusicplayer;

import android.content.ComponentName;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import ethan.com.elmusicplayer.Service.AppMediaBrowserService;
import ethan.com.elmusicplayer.UI.DrawerActivity;

public class MainActivity extends DrawerActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private final MediaBrowserCompat.ConnectionCallback connectionCallback = new MediaBrowserCompat.ConnectionCallback(){
        @Override
        public void onConnected() {
            try {
                mediaController = new MediaControllerCompat(MainActivity.this, mediaBrowserCompat.getSessionToken());
                MediaControllerCompat.setMediaController(MainActivity.this, mediaController);
                Log.d(LOG_TAG, "all setup for controller were done");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    };

    private MediaBrowserCompat mediaBrowserCompat;
    private MediaControllerCompat mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mediaBrowserCompat = new MediaBrowserCompat(
                this,
                new ComponentName(this, AppMediaBrowserService.class),
                connectionCallback,
                null
        );
        mediaBrowserCompat.connect();
    }

    @Override
    protected int fetchLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void setMoreNavigationViewFeatures() {

    }

}
