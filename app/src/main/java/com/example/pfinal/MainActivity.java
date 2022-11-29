package com.example.pfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        etx1= (EditText)findViewById(R.id.editTextTextEmailAddress);
        etx2= (EditText)findViewById(R.id.editTextTextPassword);
        btn= (Button)findViewById(R.id.buttonLogin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario =  etx1.getText().toString();
                String contrasena = etx2.getText().toString();


                if (usuario.equals("admin")&& contrasena.equals("1234")){
                    Toast.makeText(MainActivity.this, "Datos correctos", Toast.LENGTH_LONG).show();
                    setContentView(R.layout.fragment_reproductor);
                }else{
                    Toast.makeText(MainActivity.this, "Datos incorrectos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}