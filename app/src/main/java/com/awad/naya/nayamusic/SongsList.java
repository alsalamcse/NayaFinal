package com.awad.naya.nayamusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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


        btnADD=(Button)findViewById(R.id.btnADD);
        initListView();
    }
    public void onClick(View view)
    {
        if (view==btnADD)
        {
            Intent intent = new Intent(SongsList.this,ADD.class);
            startActivity(intent);

        }

    }
    private void initListView()
    {
        lstSONGS=(ListView)findViewById(R.id.lstSONGS);
        MySongsTable table=new MySongsTable(this);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, ((MySongsTable) table).getSongsList());
        lstSONGS.setAdapter(adapter);

    }



}
