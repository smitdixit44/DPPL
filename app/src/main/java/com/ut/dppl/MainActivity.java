package com.ut.dppl;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

public class    MainActivity extends AppCompatActivity {
    EditText Username;
    EditText Password;
    Button button,button1,button2;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db= new DataBaseHelper(this);
        Username=(EditText) findViewById(R.id.Username);
        Password=(EditText)findViewById(R.id.Password);
        button=(Button)findViewById(R.id.button);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("report", "register");
                Intent Register=new Intent(MainActivity.this, Register.class);
                startActivity(Register);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("report", "login");

                String user=Username.getText().toString().trim();
                String password= Password.getText().toString().trim();
                Boolean res=db.checkUser(user, password);
                if (res == true)
                {
                    openUrl("https://www.dpplindia.in/");

                    Toast.makeText(MainActivity.this, "SUCCESSFULLY LOGIN", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "LOGIN ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            private void openUrl(String s) {
                Uri uri=Uri.parse(s);
                Intent launchWeb=new Intent(Intent.ACTION_VIEW, uri);
                startActivity(launchWeb);
            }


        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("report", "customerFeedback");
                Intent intent = new Intent(MainActivity.this, CustomerFeedback.class);
                startActivity(intent);
            }
        });
    }
}