package com.juansosa.apppuppy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.juansosa.apppuppy.adapter.PageAdapter;
import com.juansosa.apppuppy.adapter.mascotaAdaptador;
import com.juansosa.apppuppy.fragment.PerfilFragment;
import com.juansosa.apppuppy.fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class ListaMascotas extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tvToolbar;

    private TabLayout tablayout;
    private ViewPager viewPager;
    private ImageButton btnFavoritos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);


        toolbar = (Toolbar) findViewById(R.id.miToolbar);
        setSupportActionBar(toolbar);

        tvToolbar = (TextView) findViewById(R.id.tvActionBar);
        tvToolbar.setText( getResources().getString(R.string.app_name).toString() );

        tablayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        btnFavoritos = (ImageButton) findViewById(R.id.btnFavoritos);


        btnFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Toast.makeText(ListaMascotas.this, "Favoritos", Toast.LENGTH_SHORT).show();
               Intent favoritos = new Intent( ListaMascotas.this, Favoritos.class);
               startActivity(favoritos);
            }
        });


    }

    //Menu de Opciones

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.mContacto:
                Toast.makeText(ListaMascotas.this, getResources().getString(R.string.menu_opcion_contacto), Toast.LENGTH_SHORT).show();
                Intent contacto = new Intent(ListaMascotas.this, ContactoActivity.class);
                startActivity(contacto);
                break;

            case R.id.mAcercade:
                Toast.makeText(ListaMascotas.this, getResources().getString(R.string.menu_opcion_acercade), Toast.LENGTH_SHORT).show();
                Intent acercade = new Intent(ListaMascotas.this, AcercaDeActivity.class);
                startActivity(acercade);
                break;

        }


        return super.onOptionsItemSelected(item);
    }


    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;


    }

    private void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()) );
        tablayout.setupWithViewPager(viewPager);

        //Agrego iconos a los layouts

        tablayout.getTabAt(0).setIcon(R.drawable.ic_perfil);
        tablayout.getTabAt(1).setIcon(R.drawable.ic_recyclerview);


    }


}