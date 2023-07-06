package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ceasar  = (Button)findViewById(R.id.button_ceasar);
        Button atbash  = (Button)findViewById(R.id.button_atbash);
        Button vignere = (Button)findViewById(R.id.button_vignere);
        Button rail    = (Button)findViewById(R.id.button_rail);


        ceasar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ceasar.class);
                startActivity(i);
            }
        });

        atbash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,atbash.class);
                startActivity(i);

            }
        });

        vignere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,vignere.class);
                startActivity(i);

            }
        });


        rail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,rail.class);
                startActivity(i);

            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent i = new Intent(this,aboutus.class);
        startActivity(i);
        return true;

    }


}