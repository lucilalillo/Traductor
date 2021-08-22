package com.example.traductor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText tvPalabra, tvTraducido;
    private Button boton;
    private TextView tvMensaje;
    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVista();
        // creamos una instancia del Viewmodel
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        vm.getTraduccion().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvTraducido.setText(s);
            }
        });

        vm.getCartel().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer visible) {
                tvMensaje.setText(visible);
            }
        });
    }

    public void inicializarVista(){
       tvPalabra = findViewById(R.id.ETPalabra);
       tvTraducido = findViewById(R.id.ETTraducido);
       boton = findViewById(R.id.BTTraducir);
       tvMensaje = findViewById(R.id.TVMensaje);
       boton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               vm.traducir(tvPalabra.getText().toString());
           }
       });
    }
}