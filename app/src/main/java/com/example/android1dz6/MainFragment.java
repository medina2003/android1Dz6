package com.example.android1dz6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class MainFragment extends Fragment implements ClickListen {
    ArrayList<TheCountry> theCountries;
    TheCountryAdapter adapter;
    RecyclerView recyclerView;
    public static final String THECOUNTRY_KEY = "thecountry.key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        theCountries = new ArrayList();
        recyclerView = view.findViewById(R.id.recycler);
        adapter = new TheCountryAdapter(theCountries, this);
        recyclerView.setAdapter(adapter);


        loaData();


    }

    private void loaData() {
        theCountries = new ArrayList<>();
        theCountries.add(new TheCountry(R.drawable.ic_cas, "Евразия"));
        theCountries.add(new TheCountry(R.drawable.ic_ceu, "Антарктида"));
        theCountries.add(new TheCountry(R.drawable.ic_caf, "Африка"));
        theCountries.add(new TheCountry(R.drawable.ic_cna, "Северная Америка"));
        theCountries.add(new TheCountry(R.drawable.ic_csa, "Южная Америка"));
        theCountries.add(new TheCountry(R.drawable.ic_coc, "Австралия"));

    }

    @Override
    public void click(int position) {

        Bundle bundle = new Bundle();
        bundle.putInt(THECOUNTRY_KEY, position);
        Fragment fragment = new SecondFragment();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().
                replace(R.id.container, fragment).addToBackStack("").commit();


    }
}