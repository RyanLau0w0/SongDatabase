package sg.edu.rp.c346.id22023219.songdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomSongDB extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Songs> songList;

    public CustomSongDB(@NonNull Context context, int resource, ArrayList<Songs> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvSinger = rowView.findViewById(R.id.textViewSinger);
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvStars = rowView.findViewById(R.id.textViewStars);

        // Obtain the Android Version information based on the position
        Songs currentToDo = songList.get(position);

        // Set values to the TextView to display the corresponding information
        tvSinger.setText(currentToDo.getId() + "." + currentToDo.getSinger());
        tvTitle.setText(currentToDo.getTitle());
        tvYear.setText("" + currentToDo.getYear());
        tvStars.setText(currentToDo.getStars());

        return rowView;
    }

}
