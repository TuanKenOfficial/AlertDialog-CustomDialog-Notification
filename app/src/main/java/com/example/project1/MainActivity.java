package com.example.project1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txtNhapten;
    private TextView txtKetqua;
    private ImageView imgGautruc;
    private EditText edtTen;
    private Button btnXacNhan;
    private Button btnChuyenmanhinh;

    private static final String TAG = "KT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
    }


    private void addControl() {
        txtNhapten = (TextView) findViewById(R.id.txtNhapten);
        txtKetqua = (TextView) findViewById(R.id.txtKetqua);
        imgGautruc = (ImageView) findViewById(R.id.imgGautruc);
        edtTen = (EditText) findViewById(R.id.edtTen);
        btnXacNhan = (Button) findViewById(R.id.btnXacNhan);
        btnChuyenmanhinh = (Button) findViewById(R.id.btnChuyenmanhinh);


        btnChuyenmanhinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
                a.setTitle("Chuyển màn hình");
                a.setMessage("Bạn có chuyển sang màn hình Alert Dialog ko?");
                a.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(MainActivity.this, AlertDialogActivity.class));
                            }
                        })
                        .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                    dialog.dismiss();
                                dialog.cancel();
                            }
                        })
                        .create()
                        .show();
            }
        });
        txtNhapten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mình dùng câu lệnh toast
                Log.d(TAG, "onClick: txtNhapten");
                Toast.makeText(MainActivity.this,"Tên: "+edtTen.getText().toString().trim(),Toast.LENGTH_SHORT).show();
            }
        });
        imgGautruc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mình dùng intent
                Log.d(TAG, "onClick: imgGautruc");
//                Intent intent = new Intent(MainActivity.this,TroVeActivity.class);
//                startActivity(intent);
                Toast.makeText(MainActivity.this, "Chuyển màn hình", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(MainActivity.this,TroVeActivity.class));
            }
        });
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: btnXacNhan");
                Toast.makeText(MainActivity.this, "Bạn đã bấm xác nhận", Toast.LENGTH_SHORT).show();
                txtKetqua.setText(edtTen.getText().toString());
                btnXacNhan.setTextColor(Color.RED);
            }
        });
    }

    //mở Custom Dialog cách 1
    public void btnCustomDialog(View view) {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.itemcustomdialog);
        dialog.setCanceledOnTouchOutside(false);

        ImageView imgThoat = (ImageView) dialog.findViewById(R.id.imgThoat);
        imgThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Thoát", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        ImageView imgOpen = (ImageView) dialog.findViewById(R.id.imgOpen);
        imgOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Qua màn hình alert diaglog", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, AlertDialogActivity.class));
            }
        });
        dialog.show();
    }

    //mở Custom Dialog cách 2
    public void btnCustomDialog1(View view) {
        MyCustomDialog myCustomDialog = new MyCustomDialog(MainActivity.this);
        myCustomDialog.show();
    }


    public void btnNotification(View view) {
        Toast.makeText(MainActivity.this, "Qua màn hình Notification", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, NotificationActivity.class));
    }
}