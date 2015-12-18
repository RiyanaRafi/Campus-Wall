package com.example.alaram;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class broadcast extends BroadcastReceiver {
	NotificationManager nm;

	@SuppressWarnings("deprecation")
	@Override
	public void onReceive(Context context, Intent arg1) {

		nm = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification = new Notification(R.drawable.ic_launcher,
				"Test", System.currentTimeMillis());
		// This is intent, we want to launch when user clicks on the
		// notification.
		Intent intentTL = new Intent(context,second.class);
	
		notification.setLatestEventInfo(context, "Test", "Do something!",
				PendingIntent.getActivity(context, 0, intentTL,
						PendingIntent.FLAG_CANCEL_CURRENT));
		notification.flags = Notification.DEFAULT_LIGHTS
				| Notification.FLAG_AUTO_CANCEL;
		nm.notify(1, notification);
	}

}
