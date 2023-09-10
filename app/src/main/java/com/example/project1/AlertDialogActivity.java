package com.example.project1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    public void moCuaSoAlertDialog(View view){
        taoThongbao();
    }

    private void taoThongbao() {
        AlertDialog.Builder alert = new AlertDialog.Builder(AlertDialogActivity.this);
        alert.setTitle("Thông báo");
        alert.setMessage("Bạn hãy để lại bình luận cho mình biet nha?");
        alert.setIcon(R.drawable.ic_insert_emoticon);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(AlertDialogActivity.this, "Trở về màn hình đầu tiên", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AlertDialogActivity.this, MainActivity.class));
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

}