package ethan.com.elmusicplayer.Service;

import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;

/**
 * Created by Ethan on 4/19/2017.
 */

public class AppMediaSessionCallback extends MediaSessionCompat.Callback {
    private final static String LOG_TAG = AppMediaSessionCallback.class.getSimpleName();
    @Override
    public void onPlayFromMediaId(String mediaId, Bundle extras) {
        Log.d(LOG_TAG, "onPlayFromMediaId");
    }

}
