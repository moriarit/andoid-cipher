package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class atbash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atbash);
        setTitle("Atbash Cipher");

        Button encrypt = (Button) findViewById(R.id.button_encrypt_atbash);
        Button decrypt = (Button) findViewById(R.id.button_decrypt_atbash);
        EditText plaintext = (EditText) findViewById(R.id.plaintext_atbash);
        EditText ciphertext = (EditText) findViewById(R.id.ciphertext_atbash);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String text = plaintext.getText().toString().toLowerCase();
                    String cipher = "";
                    for (int i = 0; i < text.length(); i++) {
                        char x = text.charAt(i);
                        int val = x;
                        if (val >= 97 && val <= 122) {
                            val = 122-(val-97);
                            cipher += (char) val;

                        } else {
                            throw new Exception("plaintext error");
                        }

                    }
                    ciphertext.setText(cipher);

                } catch (Exception e) {
                    Toast.makeText(atbash.this, "Plaintext  format wrong (a-z or A-Z)", Toast.LENGTH_SHORT).show();
                    return;

                }


            }
        });

        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String text = ciphertext.getText().toString().toLowerCase();
                    String plain = "";
                    for (int i = 0; i < text.length(); i++) {
                        char x = text.charAt(i);
                        int val = x;
                        if (val >= 97 && val <= 122) {
                            val = 122-(val-97);
                            plain += (char) val;

                        } else {
                            throw new Exception("plaintext error");
                        }

                    }
                    plaintext.setText(plain);

                } catch (Exception e) {
                    Toast.makeText(atbash.this, "Ciphertext format wrong (a-z or A-Z)", Toast.LENGTH_SHORT).show();
                    return;

                }

            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.info_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getTitle().toString().equals("About Us" )) {
            Intent i = new Intent(this, aboutus.class);
            startActivity(i);
        }
       else
        {
            Intent i = new Intent(this, about_atbash.class);
            startActivity(i);

        }
        return true;

    }
}