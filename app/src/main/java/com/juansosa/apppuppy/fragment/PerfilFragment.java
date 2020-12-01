package com.juansosa.apppuppy.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juansosa.apppuppy.Mascota;
import com.juansosa.apppuppy.R;
import com.juansosa.apppuppy.adapter.mascotaAdaptador;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {

    ArrayList<Mascota> fotosMascota;

    RecyclerView rvPerfilMascota;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Inflate layout for this fragment

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvPerfilMascota  =  (RecyclerView) v.findViewById(R.id.rvPerfilMascota);

        rvPerfilMascota.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        inicializarPerfilMascota();
        inicializarAdaptador();

        return v;

    }

    //Funcion para inicializar perfil de mascota

    public void inicializarPerfilMascota(){

        fotosMascota = new ArrayList<Mascota>();

        fotosMascota.add(new Mascota("Max", R.drawable.max_1, 0));
        fotosMascota.add(new Mascota("Max", R.drawable.max_2, 0));
        fotosMascota.add(new Mascota("Max", R.drawable.max_3, 0));
        fotosMascota.add(new Mascota("Max", R.drawable.max_4, 0));
        fotosMascota.add(new Mascota("Max", R.drawable.max_5, 0));
        fotosMascota.add(new Mascota("Max", R.drawable.max_6, 0));


    }

    public void inicializarAdaptador(){
        mascotaAdaptador adaptador = new mascotaAdaptador(fotosMascota, getActivity());
        rvPerfilMascota.setAdapter(adaptador);

    }

}