package com.juansosa.apppuppy.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.juansosa.apppuppy.Mascota;
import com.juansosa.apppuppy.R;

import java.util.ArrayList;


public class mascotaAdaptador extends RecyclerView.Adapter<mascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    //Clase MascotaViewHolder
    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNombreCV;
        private TextView tvCantidadLikes;
        private ImageView imgMascota;
        private ImageButton btnLike;
        private ImageButton btnLikeYellow;


        public MascotaViewHolder(@NonNull View itemView){
            super(itemView);

            tvNombreCV      = (TextView) itemView.findViewById(R.id.tvNombre);
            imgMascota      = (ImageView) itemView.findViewById(R.id.imgMascota);
            btnLike         = (ImageButton) itemView.findViewById(R.id.btnLike);
            btnLikeYellow   = (ImageButton) itemView.findViewById(R.id.btnLikeYellow);
            tvCantidadLikes = (TextView) itemView.findViewById(R.id.tvCantidadLikes);
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
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvCantidadLikes.setText("" + mascota.getLikes());

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v ){
                Toast.makeText(activity,
                        "Diste like a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT ).show();

                 mascota.setLikes(mascota.getLikes() + 1 );
                 mascotaViewHolder.tvCantidadLikes.setText("" + mascota.getLikes());
            }



        });




    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }




}