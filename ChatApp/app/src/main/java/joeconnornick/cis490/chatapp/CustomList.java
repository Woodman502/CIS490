package joeconnornick.cis490.chatapp;

/**
 * Created by Nick1 on 12/8/2015.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final ArrayList<String> names;
    private final Integer[] imageId;


    public CustomList(Activity context,
                      ArrayList<String> names, Integer[] imageId) {
        super(context, R.layout.user_list_item, names);
        this.context = context;
        this.names = names;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.user_list_item, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.userListItem);
        txtTitle.setText(names.get(position));

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}