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

        // Rellenar el sAuthor dependiendo de lo escogido en el sGender
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
        sAuthor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

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
                    case "Imagine Monkeys":
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
    }

    // Iniciar el spinner genero con los generos escogidos
    public void init(){
        listGender = new ArrayList<>();
        listGender.add("Rock");
        listGender.add("Electronica");
        listGender.add("xd");
        loadGender(listGender);
    }

    // Iniciar la carga de datos del spinner Gender con los datos pasados
    public void loadGender(List<String> list_gender){
        adapterGender = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_spinner_dropdown_item, list_gender);
        sGender.setAdapter(adapterGender);
    }

    // Iniciar la carga de datos del spinner Author con los datos pasados
    public void loadAuthor(List<String> list_author){
        adapterAuthor = new ArrayAdapter<>(getActivity(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list_author);
        sAuthor.setAdapter(adapterAuthor);
    }

    // Iniciar la carga de datos del spinner Songs con los datos pasados
    public void loadSongs(List<String> list_songs){
        adapterSongs = new ArrayAdapter<>(getActivity(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, list_songs);
        sSongs.setAdapter(adapterSongs);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_reproductor, container, false);

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