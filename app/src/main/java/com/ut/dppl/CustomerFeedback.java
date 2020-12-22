package com.ut.dppl;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class /**/CustomerFeedback extends AppCompatActivity {


    TextView textView, textView1;
    RatingBar ratingBar;
    EditText editText3, editText4;
    Button button3;
    float rateValue;
    String temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_feedback);

        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView1);
        ratingBar = findViewById(R.id.ratingBar);
        editText3 = findViewById(R.id.edittext3);
        editText4 = findViewById(R.id.edittext4);
        button3 = findViewById(R.id.button3);


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                Log.d("report", "Rating Bar");

                rateValue = ratingBar.getRating();
                if (rateValue <= 1 && rateValue > 0)
                    textView1.setText("Very Bad" + rateValue + "/5");
                else if (rateValue <= 2 && rateValue > 1)
                    textView1.setText("Bad" + rateValue + "/5");
                else if (rateValue <= 3 && rateValue > 2)
                    textView1.setText("Good" + rateValue + "/5");
                else if (rateValue <= 4 && rateValue > 3)
                    textView1.setText("Very Good" + rateValue + "/5");
                else if (rateValue <= 5 && rateValue > 4)
                    textView1.setText("Excellent" + rateValue + "/5");

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("report", "Submit");

                temp = textView1.getText().toString();
                editText4.setText("Your rating :\n" + temp + "\n" + editText3.getText());
                editText3.setText("");
                ratingBar.setRating(0);
                textView1.setText("");


            }
        });

    }
}