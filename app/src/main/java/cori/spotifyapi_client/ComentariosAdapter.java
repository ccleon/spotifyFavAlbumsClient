package cori.spotifyapi_client;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Cori on 9/11/16.
 */

public class ComentariosAdapter extends ArrayAdapter<Album> {
    private Context context;
    private ArrayList<Album> entidadAlbum;
    private Repositorio repositorio;

    public ComentariosAdapter (Context context, ArrayList<Album> entidadAlbum) {
        super(context, R.layout.custom_list_layout, entidadAlbum);
        this.entidadAlbum = entidadAlbum;
        this.context = context;
        this.repositorio = new Repositorio(getContext());
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_comentarios, null);
        }

        final Album entidad = this.entidadAlbum.get(position);

        if (entidad != null) {

            ImageView imagenAlbum = (ImageView) convertView.findViewById(R.id.imagenFavorito);
            Picasso.with(context).load(entidad.getImage()).into(imagenAlbum);

            TextView tituloFavorito = (TextView) convertView.findViewById(R.id.tituloFavorito);
            tituloFavorito.setText(entidad.getName());

            RatingBar ratingBar = (RatingBar) convertView.findViewById(R.id.ratings);
            ratingBar.setRating((float)entidad.getCalificacion());

            TextView opinionFavorito = (TextView) convertView.findViewById(R.id.opinionFavorito);
            opinionFavorito.setText(entidad.getOpinion());

            Button eliminarFavorito = (Button) convertView.findViewById(R.id.eliminarFavorito);
            eliminarFavorito.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    repositorio.deleteById(entidadAlbum.get(position).getId());
                    entidadAlbum.remove(position);
                    notifyDataSetChanged();
                    Toast.makeText(getContext(), "Opinión Eliminada", Toast.LENGTH_SHORT).show();
                }
            });
        }

        return convertView;
    }
}
