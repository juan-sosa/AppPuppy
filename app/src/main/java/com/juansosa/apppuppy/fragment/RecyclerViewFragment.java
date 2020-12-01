package com.juansosa.apppuppy.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juansosa.apppuppy.Mascota;
import com.juansosa.apppuppy.R;
import com.juansosa.apppuppy.adapter.mascotaAdaptador;

import java.util.ArrayList;


public class RecyclerViewFragment extends Fragment {

    //Lista de perfiles de tipo Mascota
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;


    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Inflate the Layout for this fragment

        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //Asigno el Layout creado al Recycler View
        listaMascotas.setLayoutManager(llm);

        //Inicializo lista de mascotas con los datos
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }



    //Funcion para inicializar lista de mascotas

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Max", R.drawable.max, 0));
        mascotas.add(new Mascota("Jenny Slet", R.drawable.jennyslet, 0));
        mascotas.add(new Mascota("Norman", R.drawable.norman,0));
        mascotas.add(new Mascota("Snowball", R.drawable.snowball, 0));
        mascotas.add(new Mascota("Tiberius", R.drawable.tiberius, 0));


    }


    public void inicializarAdaptador(){
        mascotaAdaptador adaptador = new mascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }


}


