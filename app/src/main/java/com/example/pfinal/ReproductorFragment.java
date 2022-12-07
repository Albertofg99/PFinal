package com.example.pfinal;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ReproductorFragment extends Fragment {

    static MediaPlayer mediaPlayer = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public ReproductorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v= inflater.inflate(R.layout.fragment_reproductor, container, false);

        ImageButton btnPlayPause = v.findViewById(R.id.imageButtonPlayPause);
        ImageButton btnStop = v.findViewById(R.id.imageButtonStop);
        ImageView ivImagen = v.findViewById(R.id.ivAlbum);

        Spinner spinnerGender = v.findViewById(R.id.sGender);
        Spinner spinnerAuthor = v.findViewById(R.id.sAuthor);
        Spinner spinnerSongs = v.findViewById(R.id.sSongs);

        // Adapter para rellenar el spinner genero
        ArrayAdapter adapterGender = new ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.listGender));
        spinnerGender.setAdapter(adapterGender);


        // Rellenar el sAuthor dependiendo de lo escogido en el sGender
        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            ArrayAdapter adapterAuthor;

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                pararQuest(btnPlayPause);

                switch (i){
                    case 0: //Rock
                        adapterAuthor = new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.listAuthorRock));
                        spinnerAuthor.setAdapter(adapterAuthor);
                        break;
                    case 1: //Electronica
                        adapterAuthor = new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.listAuthorElectronica));
                        spinnerAuthor.setAdapter(adapterAuthor);
                        break;
                    case 2: //Española
                        adapterAuthor = new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.listAuthorUrbana));
                        spinnerAuthor.setAdapter(adapterAuthor);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Cargar el sSongs dependiendo de la eleccion en el sAuthor
        spinnerAuthor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            ArrayAdapter adapterSong;

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String item = adapterView.getSelectedItem().toString();
                switch (item){
                    case "Nirvana":

                        adapterSong = new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.listSongNirvana));
                        spinnerSongs.setAdapter(adapterSong);
                        break;

                    case "Imagine Dragons":

                        adapterSong = new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.listSongImagineDragons));
                        spinnerSongs.setAdapter(adapterSong);
                        break;

                    case "Skrillex":

                        adapterSong = new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.listSongSkrillex));
                        spinnerSongs.setAdapter(adapterSong);
                        break;

                    case "David Guetta":

                        adapterSong = new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.listSongDavidGuetta));
                        spinnerSongs.setAdapter(adapterSong);
                        break;

                    case "Lil Bokeron":

                        adapterSong = new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.listSongLilBokeron));
                        spinnerSongs.setAdapter(adapterSong);
                        break;

                    case "Rels B":

                        adapterSong = new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.listSongRelsB));
                        spinnerSongs.setAdapter(adapterSong);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerSongs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    pararQuest(btnPlayPause);
                }

                String item = adapterView.getSelectedItem().toString();
                switch (item){
                    case "Something In The Way": //Nirvana

                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.nirvana_something_in_the_way);
                        break;
                    case "Smells Like Teen Spirit":

                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.nirvana_smells_like_teen_spirit);
                        break;
                    case "Bones": //Imagine Dragons

                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.imagine_dragons_bones);
                        break;
                    case "Enemy":

                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.imagine_dragons_enemy);
                        break;
                    case "Ease My Mind": //Skrillex

                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.skrillex_ease_my_mind);
                        break;
                    case "Make It Bun Dem":

                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.skrillex_make_it_bun_dem);
                        break;
                    case "Memories": //David Guetta

                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.david_guetta_memories);
                        break;
                    case "Titanium":

                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.david_guetta_titanium);
                        break;
                    case "Versos Perversos": //Lil Bokeron

                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.lil_bokeron_versos_perversos);
                        break;
                    case "A Mi": //Rels B

                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.rels_b_a_mi);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnPlayPause.setImageResource(R.drawable.botonplayproyecto2);

        btnPlayPause.setOnClickListener(view -> {

            if (mediaPlayer.isPlaying()) {

                btnPlayPause.setImageResource(R.drawable.botonplayproyecto2);
                mediaPlayer.pause();
            }else{

                btnPlayPause.setImageResource(R.drawable.botonpauseproyecto2);
                mediaPlayer.start();
            }
        });

        btnStop.setOnClickListener(view -> pararQuest(btnPlayPause));

        return v;
    }

    public void pararQuest(ImageButton ib){
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            ib.setImageResource(R.drawable.botonplayproyecto2);
        }
    }

}