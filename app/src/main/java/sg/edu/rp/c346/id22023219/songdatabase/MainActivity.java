package sg.edu.rp.c346.id22023219.songdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etTitle;
    EditText etSinger;
    EditText etYear;
    Button btnInsert;
    Button btnShowList;
    RadioButton Star1;
    RadioButton Star2;
    RadioButton Star3;
    RadioButton Star4;
    RadioButton Star5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);
        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);
        Star1 = findViewById(R.id.Star1);
        Star2 = findViewById(R.id.Star2);
        Star3 = findViewById(R.id.Star3);
        Star4 = findViewById(R.id.Star4);
        Star5 = findViewById(R.id.Star5);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);
                String Title = etTitle.getText().toString();
                String Singer = etSinger.getText().toString();
                String YearS= etYear.getText().toString();
                int Year = Integer.parseInt(YearS);
                String Star = "";
                if (Star1.isChecked()){
                    Star = "*";
                } else if (Star2.isChecked()) {
                    Star = "**";
                } else if (Star3.isChecked()) {
                    Star = "***";
                } else if (Star4.isChecked()) {
                    Star = "****";
                } else if (Star5.isChecked()){
                    Star = "*****";
                }

                // Insert a task
                db.insertSong(Title, Singer, Year, Star);
                etTitle.setText("");
                etSinger.setText("");
                etYear.setText("");

            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}