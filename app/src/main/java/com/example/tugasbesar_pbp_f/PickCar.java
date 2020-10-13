package com.example.tugasbesar_pbp_f;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasbesar_pbp_f.databinding.ActivityPickcarBinding;
import com.example.tugasbesar_pbp_f.databinding.ActivityPickcarBinding;

import java.util.ArrayList;

public class PickCar extends AppCompatActivity {
    private ActivityPickcarBinding activityPickcarBinding;
    private ArrayList<Car> ListCar;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListCar = new CarList().CAR;
        adapter = new RecyclerViewAdapter(PickCar.this, ListCar);

        activityPickcarBinding = DataBindingUtil.setContentView(this,R.layout.activity_pickcar);
        activityPickcarBinding.recyclerViewCar.setLayoutManager(new LinearLayoutManager(this));
        activityPickcarBinding.recyclerViewCar.setItemAnimator(new DefaultItemAnimator());
        activityPickcarBinding.recyclerViewCar.setAdapter(adapter);
    }
}
