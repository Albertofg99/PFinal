package com.example.pfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etx1,etx2;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(MainActivity.this, loadActivity.class);
        startActivity(i);

        etx1= (EditText)findViewById(R.id.editTextTextEmailAddress);
        etx2= (EditText)findViewById(R.id.editTextTextPassword);
        btn= (Button)findViewById(R.id.buttonLogin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario =  etx1.getText().toString();
                String contrasena = etx2.getText().toString();


                if (usuario.equals("admin") && contrasena.equals("1234")){
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_LONG).show();
                    fragmentoReproductor();
                }else if(!usuario.equals("admin") && contrasena.equals("1234")){
                    Toast.makeText(MainActivity.this, R.string.wrong_user, Toast.LENGTH_LONG).show();
                }else if(usuario.equals("admin") && !contrasena.equals("1234")){
                    Toast.makeText(MainActivity.this, R.string.wrong_pass, Toast.LENGTH_LONG).show();
                }else{
                    Intent i = new Intent(view.getContext(), deniedActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    protected void fragmentoReproductor(){
        FragmentTransaction ft= MainActivity.this.getSupportFragmentManager().beginTransaction();
        ReproductorFragment rf= new ReproductorFragment();
        ft.replace(android.R.id.content, rf)
                .addToBackStack(null)
                .commit();
    }


}