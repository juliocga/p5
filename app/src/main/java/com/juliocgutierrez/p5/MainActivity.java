package com.juliocgutierrez.p5;

import android.content.Intent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.content.Context;
import android.widget.Adapter;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private String[] opciones;
    private ListView listView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    private CharSequence tituloSec;
    private CharSequence tituloApp;

    private lista_entrada[] datos= new lista_entrada[]{
            new lista_entrada(R.drawable.home,"Publicidad"),
            new lista_entrada(R.drawable.info,"Inf. Demografica"),
            new lista_entrada(R.drawable.turismo,"Sitios Turisticos"),
            new lista_entrada(R.drawable.bares,"Bares"),
            new lista_entrada(R.drawable.hotelic,"Hoteles")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opciones = new String[] {"Publicidad","Inf. Demografica","Sitios Turisticos","Bares","Hoteles"};

        drawerLayout = (DrawerLayout) findViewById(R.id.contenedorPrincipal);

        Adapter adaptador= new Adapter(this,datos);
        listView =(ListView) findViewById(R.id.menuIzq);
        listView.setAdapter(adaptador);



        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = null;
        fragment = new PubliFragment();
        fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();

        final ActionBar ab = getSupportActionBar();
        if (ab !=null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;
                switch(position){
                    case 0: fragment = new PubliFragment();
                        break;
                    case 1: fragment = new InfFragment();
                        break;
                    case 2: fragment = new SitiosFragment();
                        break;
                    case 3: fragment = new BaresFragment();
                        break;
                    case 4: fragment = new HotelesFragment();
                        break;

                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.contenedorFragment, fragment).commit();
                listView.setItemChecked(position, true);
                tituloSec = opciones[position];
                ab.setTitle(tituloSec);
                drawerLayout.closeDrawer(listView);
            }
        });

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.drawable.ic_menu_white_24dp,R.string.abierto,R.string.cerrado);

        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class Adapter extends ArrayAdapter<lista_entrada>{

        public Adapter(Context context,lista_entrada[] datos){
            super(context,R.layout.listitem,datos);
        }

        public View getView(int position,View convertView,ViewGroup parent){
            LayoutInflater inflater= LayoutInflater.from(getContext());
            View item= inflater.inflate(R.layout.listitem, null);

            TextView nombre=(TextView) item.findViewById(R.id.nombre);
            nombre.setText(datos[position].getNombres());
            ImageView imagen=(ImageView) item.findViewById(R.id.imagen);
            imagen.setImageResource(datos[position].getIdimagen());

            return (item);
        }
    }

    public void onMapainfo(View view){
        Intent i=new Intent(MainActivity.this, MapsActivity.class);
        i.putExtra("Lat",7.06528);
        i.putExtra("Long",-73.85472);
        i.putExtra("etiqueta","Barrancabermeja");
        startActivity(i);
    }

    public void onMapaciena(View view){
        Intent i=new Intent(MainActivity.this, MapsActivity.class);
        i.putExtra("Lat",7.094702);
        i.putExtra("Long",-73.831322);
        i.putExtra("etiqueta","Club Nautico");
        startActivity(i);
    }

    public void onMapamarce(View view){
        Intent i=new Intent(MainActivity.this, MapsActivity.class);
        i.putExtra("Lat",7.059697);
        i.putExtra("Long",-73.875249);
        i.putExtra("etiqueta","La Marcela");
        startActivity(i);
    }

    public void onMapamuseo(View view){
        Intent i=new Intent(MainActivity.this, MapsActivity.class);
        i.putExtra("Lat",6.993742);
        i.putExtra("Long",-73.783685);
        i.putExtra("etiqueta","Museo del petroleo");
        startActivity(i);
    }

    public void onMapaciudad(View view){
        Intent i=new Intent(MainActivity.this, MapsActivity.class);
        i.putExtra("Lat",7.059376);
        i.putExtra("Long",-73.855298);
        i.putExtra("etiqueta","Hotel La Ciudad");
        startActivity(i);
    }

    public void onMapacu(View view){
        Intent i=new Intent(MainActivity.this, MapsActivity.class);
        i.putExtra("Lat",7.060632);
        i.putExtra("Long",-73.853149);
        i.putExtra("etiqueta","Discoteca Cucaracho");
        startActivity(i);
    }

    public void onMapamille(View view){
        Intent i=new Intent(MainActivity.this, MapsActivity.class);
        i.putExtra("Lat",7.077723);
        i.putExtra("Long",-73.858540);
        i.putExtra("etiqueta","Hotel Millenium");
        startActivity(i);
    }

    public void onMapapipaton(View view){
        Intent i=new Intent(MainActivity.this, MapsActivity.class);
        i.putExtra("Lat",7.058623);
        i.putExtra("Long",-73.873944);
        i.putExtra("etiqueta","Hotel Pipatón");
        startActivity(i);
    }

    public void onMapasan(View view){
        Intent i=new Intent(MainActivity.this, MapsActivity.class);
        i.putExtra("Lat",7.061450);
        i.putExtra("Long",-73.853833);
        i.putExtra("etiqueta","Discoteca San Gabriel");
        startActivity(i);
    }

    public void onMapasexy(View view){
        Intent i=new Intent(MainActivity.this, MapsActivity.class);
        i.putExtra("Lat",7.061542);
        i.putExtra("Long",-73.854953);
        i.putExtra("etiqueta","Bar Sexy Micheladas");
        startActivity(i);
    }
}
