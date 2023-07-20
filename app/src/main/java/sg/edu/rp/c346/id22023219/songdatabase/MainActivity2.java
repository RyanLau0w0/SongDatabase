package sg.edu.rp.c346.id22023219.songdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ListView lvSongList;
    Button btnStarFilter, btnReset, btnInsert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lvSongList = findViewById(R.id.lvSongList);
        btnStarFilter = findViewById(R.id.btnStarFilter);
        btnReset = findViewById(R.id.buttonReset);
        btnInsert = findViewById(R.id.buttonInsert);
        // Create the DBHelper object, passing in the
        // activity's Context
        DBHelper db = new DBHelper(MainActivity2.this);
        // Insert a task
        ArrayList<Songs> data = db.getSongs();
        CustomSongDB adapter = new CustomSongDB(this, R.layout.song_db_row, data);
        lvSongList.setAdapter(adapter);

        db.close();

        btnStarFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                data.clear();
                String filterText = "*****";
                data.addAll(db.getSongs(filterText));
                adapter.notifyDataSetChanged();
            }
        });

        lvSongList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Songs pos = data.get(position);
                Intent i = new Intent(MainActivity2.this, MainEditActivity3.class);
                i.putExtra("pos" , pos);
                startActivity(i);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity2.this);
                data.clear();
                data.addAll(dbh.getSongs());
                adapter.notifyDataSetChanged();
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();

        btnReset.performClick();
    }


}