package com.awad.naya.nayamusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainSongs extends AppCompatActivity
{
    private TextView txtMusic;
    private Button btnGO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_songs);

        txtMusic=(TextView) findViewById(R.id.txtMusic);
        btnGO=(Button) findViewById(R.id.btnGO);
    }
    public void onClick(View v)
    {
        if (v==btnGO)
        {
            Intent intent = new Intent(MainSongs.this, SongsList.class);
            startActivity(intent);
            finish();
        }

    }
}
