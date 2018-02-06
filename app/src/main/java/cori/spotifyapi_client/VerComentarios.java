package cori.spotifyapi_client;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ListView;

import java.util.ArrayList;

public class VerComentarios extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_comentarios);

        Repositorio repositorioAlbum = new Repositorio(getApplicationContext());
        ArrayList<Album> lista = repositorioAlbum.getAll();

        ComentariosAdapter comentariosAdapter = new ComentariosAdapter(VerComentarios.this, lista);

        ListView listaComentarios = (ListView) findViewById(R.id.verComentarios);
        listaComentarios.setAdapter(comentariosAdapter);

    }

}
