package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class JuegoPrincipal extends AppCompatActivity {

    private Button correr;
    private Button accion;
    private Button arriba;
    private Button abajo;
    private Button izquierda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ComunicacionTCP comm = new ComunicacionTCP(this);

        comm.solicitarConexion();

        correr = findViewById(R.id.correr);
        accion = findViewById(R.id.accion);
        arriba = findViewById(R.id.arriba);
        abajo = findViewById(R.id.abajo);
        izquierda = findViewById(R.id.izquierda);



        correr.setOnClickListener(
                (v)->{

                    comm.mandarMensaje("POS::RIGHT");
                }
        );

        accion.setOnClickListener(
                (v)->{

                    comm.mandarMensaje("POS::recarga");
                }
        );

        arriba.setOnClickListener(
                (v)->{

                    comm.mandarMensaje("POS::UP");
                }
        );

        abajo.setOnClickListener(
                (v)->{

                    comm.mandarMensaje("POS::DOWN");
                }
        );

        izquierda.setOnClickListener(
                (v)->{

                    comm.mandarMensaje("POS::LEFT");
                }
        );





    }
}
