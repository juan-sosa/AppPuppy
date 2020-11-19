package com.juansosa.apppuppy;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class mascotaAdaptador extends RecyclerView.Adapter<mascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    //Clase MascotaViewHolder
    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNombreCV;
        private ImageView imgMascota;

        public MascotaViewHolder(@NonNull View itemView){
            super(itemView);
            tvNombreCV    = (TextView) itemView.findViewById(R.id.tvNombre);
            imgMascota  =(ImageView) itemView.findViewById(R.id.imgMascota);
        }

    }

    public mascotaAdaptador(ArrayList<Mascota> mascotas , Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;

    }


    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

}