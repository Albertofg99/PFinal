package com.example.pfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ReproductorFragment extends Fragment {

    Spinner sGender, sAuthor, sSongs;
    List<String> listGender;
    List<String> listAuthor;
    List<String> listSongs;
    ArrayAdapter<String> adapterGender, adapterAuthor, adapterSongs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sGender = getView().findViewById(R.id.sGender);
        sAuthor = getView().findViewById(R.id.sAuthor);
        sSongs = getView().findViewById(R.id.sSongs);

        init();

        sGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int position =(int)adapterView.getItemAtPosition(i);
                switch (position){
                    case 0:
                        listAuthor = new ArrayList<>();
                        listAuthor.add("Nirvana");
                        listAuthor.add("Imagine Monkeys");
                        loadAuthor(listAuthor);
                        break;
                    case 1:
                        listAuthor = new ArrayList<>();
                        listAuthor.add("Skrillex");
                        listAuthor.add("Steve Aoki");
                        loadAuthor(listAuthor);
                        break;
                    case 2:
                        listAuthor = new ArrayList<>();
                        listAuthor.add("Lil Bokeron");
                        listAuthor.add("Niqitou");
                        loadAuthor(listAuthor);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    // Iniciar el spinner genero con los generos escogidos
    public void init(){
        listGender = new ArrayList<>();
        listGender.add("Rock");
        listGender.add("Electronica");
        listGender.add("xd");
    }

    public void loadGender(List<String> list_gender){
        adapterGender = new ArrayAdapter<String>(getActivity(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list_gender);
        sGender.setAdapter(adapterGender);
    }

    public void loadAuthor(List<String> list_author){
        adapterAuthor = new ArrayAdapter<String>(getActivity(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list_author);
        sAuthor.setAdapter(adapterAuthor);
    }

    public void loadSongs(List<String> list_songs){
        adapterSongs = new ArrayAdapter<String>(getActivity(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,list_songs);
        sSongs.setAdapter(adapterSongs);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reproductor, container, false);
    }

    public ReproductorFragment() {
        // Required empty public constructor
    }

    public static ReproductorFragment newInstance(String param1, String param2) {
        ReproductorFragment fragment = new ReproductorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
}