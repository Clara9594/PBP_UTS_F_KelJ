package com.example.tugasbesar_pbp_f;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasbesar_pbp_f.databinding.AdapterRecyclerViewBinding;
import com.example.tugasbesar_pbp_f.databinding.AdapterRecyclerViewBinding;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context context;
    private List<Car> result;
    public RecyclerViewAdapter(){}

    public RecyclerViewAdapter(Context context, List<Car> result){
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        AdapterRecyclerViewBinding adapterRecyclerViewBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),R.layout.adapter_recycler_view,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(adapterRecyclerViewBinding);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Car car = result.get(position);
        holder.adapterRecyclerViewBinding.setCar(car);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView foto_profil;
        private CardView parent;
        AdapterRecyclerViewBinding adapterRecyclerViewBinding;

        public MyViewHolder(@NonNull AdapterRecyclerViewBinding itemView){
            super(itemView.getRoot());
            adapterRecyclerViewBinding = itemView;

            adapterRecyclerViewBinding.itemcard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int itemPosition = getLayoutPosition();
                    Intent next = new Intent(context,Detail.class);
                    Bundle mBundle = new Bundle();
                    mBundle.putInt("harga",result.get(itemPosition).getHarga());
                    next.putExtra("hargaDetail",mBundle);
                    context.startActivity(next);
                }
            });
        }
    }
}