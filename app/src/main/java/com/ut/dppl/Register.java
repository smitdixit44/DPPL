package com.ut.dppl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText Username, Password, Confirm_Password;
    Button button, button1;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DataBaseHelper(this);
        EditText Username = findViewById(R.id.Username);
        EditText Password = findViewById(R.id.Password);
        EditText Confirm_Password = findViewById(R.id.Confirm_Password);
        Button button = findViewById(R.id.button);
        Button button1 = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("register", "login");

                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("register", "register");

                String user = Username.getText().toString().trim();
                String password = Password.getText().toString().trim();
                String Confirm_password = Confirm_Password.getText().toString().trim();

                if (password.equals(Confirm_password)) {
                    long val = db.addUser(user, password);
                    if (val > 0) {
                        Toast.makeText(Register.this, "You have register", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Register.this, "Register Error", Toast.LENGTH_SHORT).show();

                    }


                } else {

                    Toast.makeText(Register.this, "PASSWORD NOT MATCH", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}