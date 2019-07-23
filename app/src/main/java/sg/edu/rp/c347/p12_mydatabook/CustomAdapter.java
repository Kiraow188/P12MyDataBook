package sg.edu.rp.c347.p12_mydatabook;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {
    private Context context;
    private String[] list;
    private TextView tv;
    private ImageView img;

    public CustomAdapter(Context context, int resource, String[] objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        list = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tv = rowView.findViewById(R.id.textView);
        // Get the ImageView object
        img = rowView.findViewById(R.id.imageView);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        String current = list[position];

        tv.setText(current);

        if (position == 0){
            img.setImageResource(android.R.drawable.ic_menu_info_details);
        }else if (position == 1){
            img.setImageResource(android.R.drawable.ic_menu_edit);
        }else if (position == 2){
            img.setImageResource(android.R.drawable.ic_menu_my_calendar);
        }else if (position == 3){
            img.setImageResource(android.R.drawable.star_on);
        }

        return rowView;
    }

}
