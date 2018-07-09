package com.example.daniele.voicerecognitiontest;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.graphics.Palette;
import android.graphics.Color;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.widget.TextView;
import android.widget.ImageView;
import android.content.Intent;
import android.view.View;
import android.util.Log;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG_LOG = MainActivity.class.getName();

    private CardView mCardView;
    private ImageView mImageView;
    private Bitmap mBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCardView = (CardView) findViewById(R.id.first_card);
        mImageView = (ImageView) findViewById(R.id.first_img);
        mBitmap = (Bitmap) ((BitmapDrawable)mImageView.getDrawable()).getBitmap();

        setColorToCardViews();

    }

    /**
     * Imposta il colore di sfondo delle cardview sfruttando la classe Palette.
     */
    private void setColorToCardViews() {
        if (mBitmap != null) {

            //Ottieni l'istanza della classe Palette
            new Palette.Builder(mBitmap).generate(new Palette.PaletteAsyncListener() {

                @Override
                public void onGenerated(Palette palette) {
                    //Funzionano solo Vibrant e LightVibrant...
                    int cardViewColor = palette.getLightVibrantColor(Color.WHITE);
                    mCardView.setCardBackgroundColor(cardViewColor);
                }
            });
        }
    }
}
