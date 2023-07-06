package com.example.cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ceasar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceasar);
        setTitle("Ceasar Cipher");
        Button encrypt = (Button) findViewById(R.id.button_encrypt);
        Button decrypt = (Button) findViewById(R.id.button_decrypt);

        EditText plaintext = (EditText) findViewById(R.id.plaintext_ceasar);
        EditText ciphertext = (EditText) findViewById(R.id.ciphertext_ceasar);
        EditText Key = (EditText) findViewById(R.id.key_ceasar);


        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int k;
                try {
                    k = Integer.parseInt(Key.getText().toString());
                    if (k < 0 || k >= 27) {
                        throw new NumberFormatException("integer range wrong ");
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(ceasar.this, "Key format wrong (1-26)", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    String text = plaintext.getText().toString().toLowerCase();
                    String cipher = "";
                    for (int i = 0; i < text.length(); i++) {
                        char x = text.charAt(i);
                        int val = x;
                        if (val >= 97 && val <= 122) {
                            val = 97 + (val - 97 + k) % 26;
                            cipher += (char) val;

                        } else {
                            throw new Exception("plaintext error");
                        }

                    }
                    ciphertext.setText(cipher);

                } catch (Exception e) {
                    Toast.makeText(ceasar.this, "Plaintext  format wrong (a-z or A-Z)", Toast.LENGTH_SHORT).show();
                    return;

                }

            }
        });

        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int k;
                try {
                    k = Integer.parseInt(Key.getText().toString());
                    if (k < 0 || k >= 27) {
                        throw new NumberFormatException("integer range wrong ");
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(ceasar.this, "Key format wrong (1-26)", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    String text = ciphertext.getText().toString().toLowerCase();
                    String plain = "";
                    for (int i = 0; i < text.length(); i++) {
                        char x = text.charAt(i);
                        int val = x;
                        if (val >= 97 && val <= 122) {
                            val = 97 + (26 +(val - 97 - k))%26;
                            plain += (char) val;

                        } else {
                            throw new Exception("Ciphertext error");
                        }

                    }
                    plaintext.setText(plain);

                } catch (Exception e) {
                    Toast.makeText(ceasar.this, "Ciphertext  format wrong (a-z or A-Z)", Toast.LENGTH_SHORT).show();
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
            Intent i = new Intent(this, about_ceasar.class);
            startActivity(i);

        }
        return true;

    }
}