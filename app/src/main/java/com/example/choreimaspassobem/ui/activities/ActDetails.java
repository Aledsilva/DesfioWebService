package com.example.choreimaspassobem.ui.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.choreimaspassobem.R;
import com.example.choreimaspassobem.model.Results;
import com.squareup.picasso.Picasso;


public class ActDetails extends AppCompatActivity {
    private ImageView imageComics, imageBackgro;
    private TextView title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comic_details);

        imageComics = findViewById(R.id.image_details_comic);
        imageBackgro = findViewById(R.id. img_comics_two);
        title = findViewById(R.id.text_detail_comics);
        description = findViewById(R.id.description_comics);


        if(getIntent() != null){
            Results comic = getIntent().getParcelableExtra("COMICAO");
            if(comic.getDescription() == null || comic.getDescription().isEmpty()) {
                description.setText(R.string.descri_off);
            } else {
                description.setText(comic.getDescription());
            }
            title.setText(comic.getTitle());
            Picasso.get().load(comic.getThumbnail().getPath() + ".jpg").error(R.drawable.splash_marvel).into(imageBackgro);
            Picasso.get().load(comic.getThumbnail().getPath() + ".jpg").error(R.drawable.splash_marvel).into(imageComics);
        } else {
            Toast.makeText(this, "Problemas com servidor", Toast.LENGTH_LONG).show();
        }

    }
}
