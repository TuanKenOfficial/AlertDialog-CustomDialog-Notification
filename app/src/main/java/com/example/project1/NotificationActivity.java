package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.TaskStackBuilder;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NotificationActivity extends AppCompatActivity {
    private Button btnMoNotification,btnDongNotification;
//    private TextView txtChiTiet;

    private final static String TAG = "Notification";

//    private  String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
//        Intent i= getIntent();
//        s = i.getStringExtra("CHITIET");
//        txtChiTiet = (TextView) findViewById(R.id.txtChiTiet);
//        txtChiTiet.setText(s);
//        Log.d(TAG, "onCreate: "+s);
        addControl();
        addEvent();


    }

    @SuppressLint("NotificationPermission")
    private void addEvent() {
        //tạo notification
        btnMoNotification.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationActivity.this, String.valueOf(1))
                        .setSmallIcon(R.drawable.mail)
                        .setContentTitle("Thông báo lộ trình học android")
                        .setContentText("Bạn học Android ok chứ?")
                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                Log.d(TAG, "onClick: "+builder);

                Intent intentResult = new Intent(NotificationActivity.this, NotificationActivity.class);
//                String s="Bạn cần phản hồi email này, cho tôi gấp nhá!!";
//                intentResult.putExtra("CHITIET",s);
                Log.d(TAG, "onClick: "+intentResult);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    Log.d(TAG, "onClick: SDK_INT");
                    String name = getString(R.string.channel_name);
                    String description = getString(R.string.channel_description);
                    int importance = NotificationManager.IMPORTANCE_DEFAULT;
                    Log.d(TAG, "onClick: name: "+name);
                    Log.d(TAG, "onClick: description: "+description);
                    Log.d(TAG, "onClick: importance: "+importance);
                    NotificationChannel channel = new NotificationChannel(String.valueOf(1), name, importance);
                    channel.setDescription(description);
                    // Register the channel with the system; you can't change the importance
                    // or other notification behaviors after this
                    NotificationManager notificationManager = getSystemService(NotificationManager.class);
                    notificationManager.createNotificationChannel(channel);
                }

                PendingIntent pendingIntent = PendingIntent.getActivity(
                        NotificationActivity.this, 0, intentResult, PendingIntent.FLAG_IMMUTABLE);

                builder.setContentIntent(pendingIntent);

                NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(123,builder.build());
            }
        });
        //đóng notification
        btnDongNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager=
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                notificationManager.cancel(123);
            }
        });

    }


    private void addControl() {
        btnMoNotification = (Button) findViewById(R.id.btnMoNotification);
        btnDongNotification = (Button) findViewById(R.id.btnDongNotification);

    }
}