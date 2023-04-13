package com.example.rodriguez_celis;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SharedElementCallback;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        private ArrayList<Producto> listaPrincipalProductos;
        private RecyclerView rvListadoProductos;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                setTitle(getString(R.string.txt_listado_productos));
                cargarDatos();

                rvListadoProductos = findViewById(R.id.rv_listado_productos);

                AdaptadorPersonalizado miAdaptador = new AdaptadorPersonalizado(listaPrincipalProductos);
                miAdaptador.setOnItemClickListener(new AdaptadorPersonalizado.OnItemClickListener() {
                        @Override
                        public void onItemClick(Producto miProducto, int posicion) {

                                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                                intent.putExtra("producto",miProducto);
                                startActivity(intent);

                        }

                        @Override
                        public void onItemBtnEliminarClick(Producto miProducto, int posicion) {
                                listaPrincipalProductos.remove(posicion);
                                miAdaptador.setListadoInformacion(listaPrincipalProductos);
                        }
                });

                rvListadoProductos.setAdapter(miAdaptador);
                rvListadoProductos.setLayoutManager(new LinearLayoutManager(this));

        }

        public void cargarDatos(){
                Producto producto1 = new Producto();
                producto1.setNombre("Computador HP");
                producto1.setPrecio(8000000.0);
                producto1.setUrImagen("https://e7.pngegg.com/pngimages/991/696/png-clipart-hewlett-packard-hp-pavilion-desktop-computers-dell-hewlett-packard-electronics-computer.png");

                Producto producto2 = new Producto("Teclado Dell", 250000.0, "https://e7.pngegg.com/pngimages/404/865/png-clipart-computer-keyboard-msi-vigor-gk80-red-keyboard-cherry-msi-vigor-gk80-rgb-mechanical-gaming-keyboard-gaming-keyboard-computer-keyboard-cherry.png");
                Producto producto3 = new Producto("Mouse Dell", 200000.0, "https://www.nicepng.com/png/detail/285-2853862_pc-mouse-png-image-logitech-g-pro-gaming.png");
                //inicializar el arraylist
                listaPrincipalProductos = new ArrayList<>();
                //agregar los productos al arraylist
                listaPrincipalProductos.add(producto1);
                listaPrincipalProductos.add(producto2);
                listaPrincipalProductos.add(producto3);

        }
        public void clickCerrarSesion(View view){
                SharedPreferences miPreferencias = getSharedPreferences("Tienda_App",MODE_PRIVATE);
                SharedPreferences.Editor myEditor = miPreferencias.edit();
                myEditor.clear();
                myEditor.apply();

                startActivity(new Intent(this,LoginActivity.class));
                finish();
        }
}