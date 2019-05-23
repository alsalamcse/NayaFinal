package com.awad.naya.nayamusic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ADD extends AppCompatActivity
{
    private TextView txtNEW;
    private EditText edtNAME,edtSINGER,edtDATE,edtWATCHERS;
    private Button btnSAVE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        txtNEW=(TextView) findViewById(R.id.txtNEW);
        edtNAME=(EditText) findViewById(R.id.edtNAME);
        edtSINGER=(EditText)findViewById(R.id.edtSINGER);
        edtDATE=(EditText)findViewById(R.id.edtDATE);
        btnSAVE=(Button) findViewById(R.id.btnSAVE);
    }
    public void onClick(View v)
    {
        if (v==btnSAVE)
        {
            Intent intent = new Intent(ADD.this, SongsList.class);
            startActivity(intent);
            finish();
        }

    }

}
