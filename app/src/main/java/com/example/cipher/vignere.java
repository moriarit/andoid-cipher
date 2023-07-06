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

public class vignere extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vignere);
        setTitle("Vignere Cipher");
        Button encrypt = (Button) findViewById(R.id.button_encrypt_vignere);
        Button decrypt = (Button) findViewById(R.id.button_decrypt_vignere);
        EditText plaintext = (EditText) findViewById(R.id.plaintext_vignere);
        EditText key = (EditText)findViewById(R.id.key_vignere);
        EditText ciphertext = (EditText) findViewById(R.id.ciphertext_vignere);

        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String k = key.getText().toString().toLowerCase();
                    String text = plaintext.getText().toString().toLowerCase();
                    if(k.length()!=text.length())
                    {
                        throw  new Exception("length error");
                    }
                    String cipher = "";
                    for (int i = 0; i < text.length(); i++) {
                        char x = text.charAt(i);
                        char y = k.charAt(i);
                        int val = x;
                        int val2 = y;
                        if (val >= 97 && val <= 122 && val2>=97 && val2<=122) {
                            val = 97 + ((val-97) + (val2-97))%26;
                            cipher += (char) val;

                        } else {
                            throw new Exception("plaintext error");
                        }

                    }
                    ciphertext.setText(cipher);

                } catch (Exception e) {
                    Toast.makeText(vignere.this, "Plaintext format wrong (a-z or A-Z) or key length not equal to plaintext", Toast.LENGTH_SHORT).show();
                    return;

                }


            }
        });

        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String k = key.getText().toString().toLowerCase();
                    String text = ciphertext.getText().toString().toLowerCase();
                    if(k.length()!=text.length())
                    {
                        throw  new Exception("length error");
                    }
                    String plain = "";
                    for (int i = 0; i < text.length(); i++) {
                        char x = text.charAt(i);
                        char y = k.charAt(i);
                        int val = x;
                        int val2 = y;
                        if (val >= 97 && val <= 122 && val2>=97 && val2<=122) {
                            int temp = (val-97) -(val2-97);
                            if(temp<0)
                            {
                                temp = 26-temp;
                            }

                            val = 97  + temp ;

                            plain += (char) val;


                        } else {
                            throw new Exception("plaintext error");
                        }

                    }
                    plaintext.setText(plain);

                } catch (Exception e) {
                    Toast.makeText(vignere.this, "Ciphertext format wrong (a-z or A-Z)", Toast.LENGTH_SHORT).show();
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
            Intent i = new Intent(this, about_vignere.class);
            startActivity(i);

        }
        return true;

    }
}