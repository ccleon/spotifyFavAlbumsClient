package cori.spotifyapi_client;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView listView;
    private ArrayList<Album> entidades;
    private Context context;

    private static final String CONTENT_PROVIDER = "content://cori.spotifyapi.provider/entidadalbum";

    private final String LOG_TAG = "MIW_Provider";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        listView = (ListView) findViewById(R.id.listadoEntidades);

        entidades = cargarDatos();

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.nueva, entidades);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> myAdapter, View myView, int pos, long mylng) {
                Intent intent = new Intent(context, OpinionPersonal.class);
                intent.putExtra("album", new Album(entidades.get(pos).getId(),
                        entidades.get(pos).getName(),
                        entidades.get(pos).getType(),
                        entidades.get(pos).getImage()));
                startActivity(intent);
            }
        });
    }

    public ArrayList<Album> cargarDatos(){
        ArrayList<Album> listaEntidades = new ArrayList<>();

        Uri URI_ENTIDADES = Uri.parse(CONTENT_PROVIDER);
        ContentResolver contentResolver = getContentResolver();

        Cursor cursor = contentResolver.query(URI_ENTIDADES, null, null, null, null);

        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                String name = cursor.getString(1);
                String type = cursor.getString(2);
                String img = cursor.getString(4);



                int id = cursor.getInt(0);

                Album album = new Album(id, name, type, img);

                listaEntidades.add(album);

                cursor.moveToNext();
            }
            cursor.close();

        }
        return listaEntidades;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.verListaFavoritos:
                startActivity(new Intent(this, VerComentarios.class));
                return true;

            case R.id.ajustes:
                Toast.makeText(this, "De momento no hay nada aquí",
                        Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

}
