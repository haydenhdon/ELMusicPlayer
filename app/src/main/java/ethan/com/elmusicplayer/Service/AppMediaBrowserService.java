package ethan.com.elmusicplayer.Service;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserServiceCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;

import java.util.List;

/**
 * Created by Ethan on 4/19/2017.
 */

public class AppMediaBrowserService extends MediaBrowserServiceCompat {
    private static final String LOG_TAG = AppMediaBrowserService.class.getSimpleName();

    private MediaSessionCompat mediaSession;
    private AppMediaSessionCallback appMediaSessionCallback;

    @Override
    public void onCreate() {
        super.onCreate();

        mediaSession = new MediaSessionCompat(this, LOG_TAG);
        mediaSession.setFlags(MediaSessionCompat.FLAG_HANDLES_MEDIA_BUTTONS | MediaSessionCompat.FLAG_HANDLES_TRANSPORT_CONTROLS);
        appMediaSessionCallback = new AppMediaSessionCallback();
        mediaSession.setCallback(appMediaSessionCallback);
        setSessionToken(mediaSession.getSessionToken());

    }

    @Nullable
    @Override
    public BrowserRoot onGetRoot(@NonNull String clientPackageName, int clientUid, @Nullable Bundle rootHints) {
        Log.d(LOG_TAG, "connectd to root service");
        return new BrowserRoot("", null);
    }

    @Override
    public void onLoadChildren(@NonNull String parentId, @NonNull Result<List<MediaBrowserCompat.MediaItem>> result) {

    }
}
