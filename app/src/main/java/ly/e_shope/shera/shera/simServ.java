package ly.e_shope.shera.shera;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
/**
 * Created by abdullah on 10/04/17.
 */




public class simServ extends FirebaseMessagingService{

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage){
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent ,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder ncb = new NotificationCompat.Builder(this);
        ncb.setContentTitle("FCM Notification");
        ncb.setContentText(remoteMessage.getNotification().getBody());
        ncb.setAutoCancel(true);
        ncb.setSmallIcon(R.mipmap.ic_launcher);
        ncb.setContentIntent(pi);
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(0,ncb.build());



    }





}
