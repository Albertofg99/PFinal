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

    Spinner spinnerGender, spinnerAuthor, spinnerSongs;
    List<String> listAuthor;
    List<String> listSongs;
    ArrayAdapter<String> adapterAuthor, adapterSongs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Iniciar la carga de datos del spinner Author con los datos pasados
    public void loadAuthor(List<String> list_author){
        adapterAuthor = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, list_author);
        spinnerAuthor.setAdapter(adapterAuthor);
    }

    // Iniciar la carga de datos del spinner Songs con los datos pasados
    public void loadSongs(List<String> list_songs){
        adapterSongs = new ArrayAdapter<>(getActivity(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list_songs);
        spinnerSongs.setAdapter(adapterSongs);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_reproductor, container, false);

        spinnerGender = v.findViewById(R.id.sGender);
        spinnerAuthor = v.findViewById(R.id.sAuthor);
        spinnerSongs = v.findViewById(R.id.sSongs);

        // Rellenar el sAuthor dependiendo de lo escogido en el sGender
        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int position =(int)adapterView.getItemAtPosition(i);

                switch (position){
                    case 1: //Rock
                        listAuthor = new ArrayList<>();
                        listAuthor.add("Nirvana");
                        listAuthor.add("Imagine Dragons");
                        loadAuthor(listAuthor);
                        break;
                    case 2: //Electronica
                        listAuthor = new ArrayList<>();
                        listAuthor.add("Skrillex");
                        listAuthor.add("Steve Aoki");

                        loadAuthor(listAuthor);
                        break;
                    case 3: //Española
                        listAuthor = new ArrayList<>();
                        listAuthor.add("Lil Bokeron");
                        listAuthor.add("Bad Gyal");
                        loadAuthor(listAuthor);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Cargar el sSongs dependiendo de la eleccion en el sAuthor
        spinnerAuthor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getSelectedItem().toString();
                switch (item){
                    case "Nirvana":
                        listSongs = new ArrayList<>();
                        listSongs.add("a");
                        listSongs.add("b");
                        loadSongs(listSongs);
                        break;
                    case "Imagine Dragons":
                        listSongs = new ArrayList<>();
                        listSongs.add("c");
                        listSongs.add("d");
                        loadSongs(listSongs);
                        break;
                    case "Skrillex":
                        listAuthor = new ArrayList<>();
                        listAuthor.add("e");
                        listAuthor.add("f");
                        loadSongs(listSongs);
                        break;
                    case "Steve Aoki":
                        listAuthor = new ArrayList<>();
                        listAuthor.add("g");
                        listAuthor.add("h");
                        loadSongs(listSongs);
                        break;
                    case "Lil Bokeron":
                        listAuthor = new ArrayList<>();
                        listAuthor.add("i");
                        loadSongs(listSongs);
                        break;
                    case "Bad Gyal":
                        listAuthor = new ArrayList<>();
                        listAuthor.add("j");
                        listAuthor.add("k");
                        loadSongs(listSongs);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        return v;
    }

    public ReproductorFragment() {
        // Required empty public constructor
    }

    public static ReproductorFragment newInstance() {
        ReproductorFragment fragment = new ReproductorFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
}