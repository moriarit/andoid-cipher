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

public class rail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rail);
        setTitle("RailFence Cipher");

        Button encrypt = (Button) findViewById(R.id.button_encrypt_railfence);
        Button decrypt = (Button) findViewById(R.id.button_decrypt_railfence);
        EditText plaintextt = (EditText) findViewById(R.id.plaintext_railfence);
        EditText ciphertext = (EditText) findViewById(R.id.ciphertext_railfence);
        EditText Key = (EditText) findViewById(R.id.key_railfence);


        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int k;
                try {
                    k = Integer.parseInt(Key.getText().toString());
                    int  f = plaintextt.getText().toString().length();
                    if (k < 0 || k > f) {
                        throw new NumberFormatException("integer range wrong ");
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(rail.this, "Key format wrong", Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    int r = k;
                    String text = plaintextt.getText().toString().toLowerCase();
                    String cipher = "";
                    for (int i = 0; i < text.length(); i++) {
                        char x = text.charAt(i);
                        int val = x;
                        if (val >= 97 && val <= 122){
                            cipher += (char) val;

                        } else {
                            throw new Exception("Ciphertext error");
                        }
                    }
                    String plaintext = cipher;
                    String[] rail = new String[r];
                    for(int i= 0;i< rail.length;i++)
                    {
                        rail[i] = "";
                    }

                    int row = 0 ;
                    int one = 1;
                    for(int i = 0 ;i<plaintext.length();i++)
                    {
                        if( row == r)
                        {
                            one = -1;
                            row  = r-2;
                        }
                        else if(row == -1)
                        {
                            one = 1;
                            row  = 1;
                        }
                        rail[row]+=plaintext.charAt(i);
                        row +=one;



                    }

                    String out = "";
                    for(int i = 0 ;i<rail.length;i++)
                    {
                        if(i!=rail.length-1)
                        {
                            out+=rail[i]+" ";
                        }
                        else {
                            out += rail[i];
                        }

                    }
                    ciphertext.setText(out);

                } catch (Exception e) {
                    Toast.makeText(rail.this, "Plaintext  format wrong (a-z or A-Z)", Toast.LENGTH_SHORT).show();
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
                    int  f = ciphertext.getText().toString().length();
                    if (k < 0 || k >f) {
                        throw new NumberFormatException("integer range wrong ");
                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(rail.this, "Key format wrong ", Toast.LENGTH_SHORT).show();
                    return;
                }

                int r = k ;
                String plain = "";
                int d = 0 ;
                int out  = 0 ;
                String[] rail = new String[r];
                for(int i = 0 ;i<rail.length;i++)
                {
                    rail[i] = "";
                }

                try {
                    String text = ciphertext.getText().toString().toLowerCase();
                    for (int i = 0; i < text.length(); i++) {
                        char x = text.charAt(i);
                        int val = x;
                        if ((val >= 97 && val <= 122)|| (val == 32)) {
                            if(val ==32)
                            {
                                rail[d] = plain;
                                d++;
                                plain = "";
                            }
                            else {
                                plain += (char) val;
                                out+=1;
                            }

                        } else {
                            throw new Exception("Ciphertext error");
                        }
                        rail[d] = plain;



                    }
                } catch (Exception e) {
                    Toast.makeText(rail.this, "Ciphertext  format wrong (a-z or A-Z)", Toast.LENGTH_SHORT).show();
                    return;

                }
                    String dec = "";
                    int row = 0 ;
                    int one = 1;
                    for(int i = 0 ;i<out;i++)
                    {
                        if( row == r)
                        {
                            one = -1;
                            row  = r-2;
                        }
                        else if(row == -1)
                        {
                            one = 1;
                            row  = 1;
                        }

                        if(rail[row].length()!=0)
                            dec += rail[row].charAt(0);
                        else
                        {
                            rail[row]="";
                        }
                        if(rail[row].length()>=2) {
                            rail[row] = rail[row].substring(1, rail[row].length());
                        }
                        row +=one;
                    }
                    plaintextt.setText(dec);


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
            Intent i = new Intent(this, about_railfence.class);
            startActivity(i);

        }
        return true;

    }
}