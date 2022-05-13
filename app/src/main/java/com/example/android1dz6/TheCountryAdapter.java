package com.example.android1dz6;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TheCountryAdapter extends RecyclerView.Adapter<TheCountryAdapter.TheCountryViewHolder> {
private ClickListen clickListen;

    private ArrayList<TheCountry> theCountries ;
    private ClickListen listen;

    public TheCountryAdapter(ArrayList<TheCountry> theCountries, ClickListen listen) {
        this.theCountries = theCountries;
        this.listen = listen;
    }

    @NonNull
    @Override
    public TheCountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TheCountryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thecountry, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TheCountryViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.bind(theCountries.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               clickListen.click(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return theCountries.size();
    }

    class TheCountryViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;


        public TheCountryViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.the_country);
            imageView = itemView.findViewById(R.id.flag_img);
        }

        public void bind(TheCountry theCountry) {
            imageView.setImageResource(theCountry.getFlag());
            textView.setText(theCountry.getCity());
        }
    }

}