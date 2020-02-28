package com.example.gocartv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UsersAdapter extends ArrayAdapter<Product> {
    public UsersAdapter(Context context, ArrayList<Product> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Product user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mylist, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.pname);
        TextView tvHome = (TextView) convertView.findViewById(R.id.pprice);
        // Populate the data into the template view using the data object
        tvName.setText(user.name);
        tvHome.setText(user.Price);
        // Return the completed view to render on screen
        return convertView;
    }
}