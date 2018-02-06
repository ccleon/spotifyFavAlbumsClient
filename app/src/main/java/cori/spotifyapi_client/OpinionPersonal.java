package cori.spotifyapi_client;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class OpinionPersonal extends Activity {
    private Album album;
    EditText comentario;

    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opinion_personal);

        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        album = (Album) bundle.get("album");

        ImageView imageView = (ImageView) findViewById(R.id.portadaAlbum);
        Picasso.with(getApplicationContext()).load(album.getImage())
                .fit().centerCrop().into(imageView);

        TextView textView = (TextView) findViewById(R.id.tituloAlbum);
        textView.setText(album.getName());

        comentario = (EditText) findViewById(R.id.comentario);

        ratingBar = (RatingBar) findViewById(R.id.rating);



    }

    public void añadirComentario(View v){
        Repositorio repositorio = new Repositorio(getApplicationContext());
        repositorio.add(album.getName(),
                album.getType(),
                album.getImage(),
                comentario.getText().toString(),
                (int)ratingBar.getRating()
        );
        Toast.makeText(getApplicationContext(),
                "***OPINIÓN GUARDADA*** \n Ve a HISTORIAL DE OPINIONES para revisar tus valoraciones.",
                Toast.LENGTH_LONG).show();
    }




}
