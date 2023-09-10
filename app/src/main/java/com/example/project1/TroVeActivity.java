package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TroVeActivity extends AppCompatActivity {

    private Button btnTrove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tro_ve);

        addControl();
    }

    private void addControl() {
        btnTrove = (Button) findViewById(R.id.btnTrove);
        btnTrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TroVeActivity.this, "Trở về màn hình trước", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(TroVeActivity.this, MainActivity.class));
            }
        });
    }
}