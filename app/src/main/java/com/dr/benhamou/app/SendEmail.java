package com.dr.benhamou.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendEmail extends AppCompatActivity {
    EditText name,sname,phone, message;
    Button send_button;
    String get_name,get_sname,get_phone,get_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        name = (EditText)findViewById(R.id.editNom);
        sname = (EditText) findViewById(R.id.editPrenom);
        phone = (EditText) findViewById(R.id.editPhone);
        message = (EditText) findViewById(R.id.editMessage);
        send_button = (Button) findViewById(R.id.send_button);


        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_name = name.getText().toString();
                get_sname = sname.getText().toString();
                get_phone = phone.getText().toString();
                get_message = message.getText().toString();

                String body_message = "Nom - "+get_name+" Prenom - "+get_sname+" Phone- "+get_phone+"\n"+
                        get_message;

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");

                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"contact@dr-benhamou.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Message from Android");
                i.putExtra(Intent.EXTRA_TEXT   , body_message);
                try {
                    startActivity(Intent.createChooser(i, "Choisissez client de messagerie"));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(SendEmail.this, "Il n'y a pas les clients de messagerie installés.", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }

}
