package com.awad.naya.nayamusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class SongsList extends AppCompatActivity
{
    private ListView lstSONGS;
    private Button btnADD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songslist);

        lstSONGS=(ListView)findViewById(R.id.lstSONGS);
        btnADD=(Button)findViewById(R.id.btnADD);
    }
    public void onClick(View view)
    {
        if (view==btnADD)
        {
            Intent intent = new Intent(SongsList.this,ADD.class);
            startActivity(intent);

        }

    }
}
