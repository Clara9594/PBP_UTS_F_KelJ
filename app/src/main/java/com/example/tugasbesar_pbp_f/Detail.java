package com.example.tugasbesar_pbp_f;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.textview.MaterialTextView;

public class Detail extends AppCompatActivity {

    private MaterialTextView a1,a2,a3;
    public Bundle mBundle,mBundle1;
    private int harga, hari, jam;
    public long temp1, temp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        a1 = findViewById(R.id.teks1);
        a2 = findViewById(R.id.teks2);
        a3 = findViewById(R.id.teks3);
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
    }
}