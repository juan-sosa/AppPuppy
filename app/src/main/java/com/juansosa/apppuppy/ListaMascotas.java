package com.juansosa.apppuppy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ListaMascotas extends AppCompatActivity {

    //Lista de perfiles de tipo Mascota
    ArrayList<Mascota> mascotas;

    private RecyclerView listaMascotas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);


        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Asigno el Layout creado al Recycler View
        listaMascotas.setLayoutManager(llm);

        //Inicializo lista de mascotas con los datos
        inicializarListaMascotas();
        inicializarAdaptador();

        }

        //Funcion para inicializar lista de mascotas

        public void inicializarListaMascotas(){

            mascotas = new ArrayList<Mascota>();

            mascotas.add(new Mascota("Max", R.drawable.max));
            mascotas.add(new Mascota("Jenny Slet", R.drawable.jennyslet));
            mascotas.add(new Mascota("Norman", R.drawable.norman));
            mascotas.add(new Mascota("Snowball", R.drawable.snowball));
            mascotas.add(new Mascota("Tiberius", R.drawable.tiberius));


        }


        public void inicializarAdaptador(){
            mascotaAdaptador adaptador = new mascotaAdaptador(mascotas, this);
            listaMascotas.setAdapter(adaptador);
        }




}