package com.example.tugasbesar_pbp_f;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class Detail extends AppCompatActivity {

    private MaterialTextView a1,a2,a3;
    public Bundle mBundle,mBundle1;
    private int harga, hari, jam;
    public long temp1, temp2;
    private MaterialButton btnPay;
    private ImageButton btnB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        a1 = findViewById(R.id.teks1);
        a2 = findViewById(R.id.teks2);
        a3 = findViewById(R.id.teks3);
        btnPay = findViewById(R.id.pay);
        btnB = findViewById(R.id.backCar);
        mBundle = getIntent().getBundleExtra("hargaDetail");
        harga = mBundle.getInt("harga");
        a1.setText("Rp. "+String.valueOf(harga));
        a3.setText(String.valueOf(DateActivity.elapsedDays)  + " days " + String.valueOf(DateActivity.elapsedHours) +" hours ");

//        mBundle1 = getIntent().getBundleExtra("durasi1");
//        temp1 = mBundle1.getLong("hari");
//        temp2 = mBundle1.getLong("jam");
        hari = (int) DateActivity.elapsedDays;
        jam = (int) DateActivity.elapsedHours;

        if(hari==0 && jam!=0) {
            a2.setText("Rp. "+String.valueOf(harga));
        }
        else if(hari!=0 && jam!=0){
            harga = harga * (hari+1);
            a2.setText("Rp. "+String.valueOf(harga));
        }

        else if(hari!=0 && jam==0)
        {
            harga = harga * hari;
            a2.setText("Rp. "+String.valueOf(harga));
        }

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pay = new Intent(Detail.this, Check.class);
                startActivity(pay);
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(Detail.this, PickCar.class);
                startActivity(back);
            }
        });
    }
}