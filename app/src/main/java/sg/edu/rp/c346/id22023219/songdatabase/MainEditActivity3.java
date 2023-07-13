package sg.edu.rp.c346.id22023219.songdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.BreakIterator;

public class MainEditActivity3 extends AppCompatActivity {

    EditText etEditTitle, etEditSinger, etEditYear;
    RadioButton EditStar1, EditStar2, EditStar3, EditStar4,EditStar5;
    RadioGroup rgEditStars;
    Button btnEdit, btnDelete, btnCancel;
    Songs data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_edit3);

        etEditTitle = findViewById(R.id.etEditTitle);
        etEditSinger = findViewById(R.id.etEditSingers);
        etEditYear = findViewById(R.id.etEditYear);
        rgEditStars = findViewById(R.id.rgEditStars);
        EditStar1 = findViewById(R.id.editStar1);
        EditStar2 = findViewById(R.id.editStar2);
        EditStar3 = findViewById(R.id.editStar3);
        EditStar4 = findViewById(R.id.editStar4);
        EditStar5 = findViewById(R.id.editStar5);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);

        Intent i = getIntent();
        data = (Songs) i.getSerializableExtra("pos");

        etEditTitle.setText(data.getTitle());
        etEditSinger.setText(data.getSinger());
        etEditYear.setText(data.getYear());
        if (data.getStars() == "*"){
            EditStar1.setChecked(true);
        } else if (data.getStars() == "**") {
            EditStar2.setChecked(true);
        }else if (data.getStars() == "***") {
            EditStar3.setChecked(true);
        }else if (data.getStars() == "****") {
            EditStar4.setChecked(true);
        }else if (data.getStars() == "*****") {
            EditStar5.setChecked(true);
        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainEditActivity3.this);
                String Star = "";
                if (EditStar1.isChecked() && !EditStar2.isChecked() && !EditStar3.isChecked() && !EditStar4.isChecked() && !EditStar5.isChecked()){
                    Star = "*";
                } else if (!EditStar1.isChecked() && EditStar2.isChecked() && !EditStar3.isChecked() && !EditStar4.isChecked() && !EditStar5.isChecked()) {
                    Star = "**";
                } else if (!EditStar1.isChecked() && !EditStar2.isChecked() && EditStar3.isChecked() && !EditStar4.isChecked() && !EditStar5.isChecked()) {
                    Star = "***";
                } else if (!EditStar1.isChecked() && !EditStar2.isChecked() && !EditStar3.isChecked() && EditStar4.isChecked() && !EditStar5.isChecked()) {
                    Star = "****";
                } else if (!EditStar1.isChecked() && !EditStar2.isChecked() && !EditStar3.isChecked() && EditStar4.isChecked() && !EditStar5.isChecked()){
                    Star = "******";
                }
                data.setTitle(etEditTitle.getText().toString());
                data.setSinger(etEditSinger.getText().toString());
                data.setYear(Integer.parseInt(etEditYear.getText().toString()));
                data.setStars(Star);
                dbh.updateSong(data);
                dbh.close();
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainEditActivity3.this);
                dbh.deleteSong(data.getId());
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}