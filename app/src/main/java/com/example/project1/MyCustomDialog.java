package com.example.project1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class MyCustomDialog extends Dialog {

    ImageView imgThoat, imgOpen;
    Activity context;
    public MyCustomDialog(@NonNull Activity context) {
        super(context);
        this.context = context;
        setContentView(R.layout.itemcustomdialog);
        addControl();
        addEvent();

    }

    private void addEvent() {
        imgOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Qua màn hình alert diaglog", Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, AlertDialogActivity.class));
            }
        });
        imgThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Thoát màn hình", Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, MainActivity.class));
//                context.finish();
            }
        });
    }

    private void addControl() {
        imgOpen = findViewById(R.id.imgOpen);
        imgThoat = findViewById(R.id.imgThoat);
    }
}
