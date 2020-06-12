package com.example.ourtaxirider.Helper;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.ourtaxirider.R;

public class NotificationHelper extends ContextWrapper {
    private static final String FAKT_CHANNEL_ID = "com.example.ourtaxirider.FAKT37";
    private static final String FAKT_CHANNEL_NAME = "FAKT37 OurTaxi";

    private NotificationManager manager;

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            createChannels();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannels() {
        NotificationChannel faktChannels = new NotificationChannel(FAKT_CHANNEL_ID, FAKT_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
        faktChannels.enableLights(true);
        faktChannels.enableVibration(true);
        faktChannels.setLightColor(Color.GRAY);
        faktChannels.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(faktChannels);
    }

    public NotificationManager getManager() {
        if (manager == null)
            manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        return manager;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder getOurTaxiNotification (String title, String content, PendingIntent contentIntent, Uri soundUri) {
        return new Notification.Builder(getApplicationContext(), FAKT_CHANNEL_ID)
                .setContentText(content)
                .setContentTitle(title)
                .setAutoCancel(true)
                .setSound(soundUri)
                .setContentIntent(contentIntent)
                .setSmallIcon(R.drawable.ic_car);
    }
}
