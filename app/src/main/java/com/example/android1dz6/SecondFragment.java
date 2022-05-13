package com.example.android1dz6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;


public class SecondFragment extends Fragment implements ClickListen {
    ArrayList<TheCountry> theCountries;
    TheCountryAdapter adapter;
    RecyclerView recyclerView;
    public static final String THECOUNTRY_KEY = "thecountry.key";







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loaData();
    }

    private void loaData() {
        theCountries=new ArrayList<>();
        Bundle bundle=this.getArguments();
        if (bundle !=null){
            String name=Bundle.EMPTY.getString("THECOUNTRY_KEY");
            if (name != null){
                if (name.equals("Евразия")){
                    theCountries.add(new TheCountry(R.drawable.ic_kz,"Казахзстан"));
                    theCountries.add(new TheCountry(R.drawable.ic_kz,"Казахзстан"));
                    theCountries.add(new TheCountry(R.drawable.ic_kz,"Казахзстан"));
                    theCountries.add(new TheCountry(R.drawable.ic_kz,"Казахзстан"));
                    theCountries.add(new TheCountry(R.drawable.ic_kz,   "Казахзстан"));

                }
            }
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recycler_second);
        TheCountryAdapter adapter=new TheCountryAdapter(theCountries, new ClickListen() {
            @Override
            public void click(String string) {

            }
        });
        recyclerView.setAdapter(adapter);





        if (getArguments() !=null){
            TheCountry theCountry= (TheCountry) getArguments().getSerializable(MainFragment.THECOUNTRY_KEY);


            textInfo.setText("Flag:"+theCountry.getFlag()+"\n"
            +"City:"+theCountry.geCity());
        }

    }

    @Override
    public void click(int pos) {

    }
}