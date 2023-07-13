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
    Button btnStarFilter;
    ArrayList<Songs> =

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        lvSongList = findViewById(R.id.lvSongList);
        btnStarFilter = findViewById(R.id.btnStarFilter);
        // Create the DBHelper object, passing in the
        // activity's Context
        DBHelper db = new DBHelper(MainActivity2.this);
        // Insert a task
        ArrayList<Songs> data = db.getSongs();
        ArrayAdapter adapter = new ArrayAdapter<>(MainActivity2.this, android.R.layout.simple_list_item_1, data);
        lvSongList.setAdapter(adapter);
        db.close();

        btnStarFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity2.this);
                data.clear();
                // al.addAll(dbh.getAllNotes());
                String filterText = "*****";
                data.addAll(dbh.getSongs(filterText));
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
    }


}