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
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                ArrayAdapter adapterAuthor;

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
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                ArrayAdapter adapterSong;

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
                    case "Something In The Way": //Nirvana: album Nevermind

                        ivImagen.setImageResource(R.drawable.nevermind_nirvana);
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.nirvana_something_in_the_way);
                        break;
                    case "Smells Like Teen Spirit": //Album Nevermind

                        ivImagen.setImageResource(R.drawable.nevermind_nirvana);
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.nirvana_smells_like_teen_spirit);
                        break;
                    case "Bones": //Imagine Dragons: album Mercury

                        ivImagen.setImageResource(R.drawable.mercury_imaginedragons);
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.imagine_dragons_bones);
                        break;
                    case "Enemy": //Album Arcane

                        ivImagen.setImageResource(R.drawable.arcane_imaginedragons);
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.imagine_dragons_enemy);
                        break;
                    case "Ease My Mind": //Skrillex: album Recess

                        ivImagen.setImageResource(R.drawable.recess_skrillex);
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.skrillex_ease_my_mind);
                        break;
                    case "Make It Bun Dem":

                        ivImagen.setImageResource(R.drawable.makeit_skrillex);
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.skrillex_make_it_bun_dem);
                        break;
                    case "Memories": //David Guetta: album One Love

                        ivImagen.setImageResource(R.drawable.onelove_davidguetta);
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.david_guetta_memories);
                        break;
                    case "Titanium": //Album Nothing But The Beat

                        ivImagen.setImageResource(R.drawable.nothingbutthebeat_davidguetta);
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.david_guetta_titanium);
                        break;
                    case "Versos Perversos": //Lil Bokeron

                        ivImagen.setImageResource(R.drawable.versosperversos_lilbokeron);
                        mediaPlayer=MediaPlayer.create(getContext(), R.raw.lil_bokeron_versos_perversos);
                        break;
                    case "A Mi": //Rels B

                        ivImagen.setImageResource(R.drawable.ami_relsb);
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