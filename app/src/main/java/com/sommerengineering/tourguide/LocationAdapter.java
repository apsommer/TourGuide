package com.sommerengineering.tourguide;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Provides the appropriate inflated grid_item layout to the GridView in location_grid layout
 */
public class LocationAdapter extends ArrayAdapter<Location> {

    // constructor
    public LocationAdapter(Context context, ArrayList<Location> locations) {

        // call superclass ArrayAdapter constructor
        // second argument for populating a single TextView (the default for ArrayAdapter)
        // since a custom layout is inflated in getView() this second argument is arbitrary, for initialization only
        super(context, 0, locations);

    }

    // must override to inflate anything other than the default single TextView expected by ArrayAdapter
    // parent is the GridView in location_grid
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // rename input argument for clarity
        View gridItemView = convertView;

        // if the passed view does not exist (therfore not being recycled) then inflate it from grid_item
        if(gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.grid_item, parent, false);
        }

        // get the Location object at this position in the ArrayList
        Location currentLocation = getItem(position);

        // get TextView references from grid_item
        TextView titleTextView = (TextView) gridItemView.findViewById(R.id.grid_title);
        TextView descriptionTextView = (TextView) gridItemView.findViewById(R.id.grid_description);

        // get title and description strings from the current Location object and set to textviews
        titleTextView.setText(currentLocation.getLocationTitle());
        descriptionTextView.setText(currentLocation.getLocationDescription());

        // apply custom font to both textviews
        Typeface custom_font = Typeface.createFromAsset(getContext().getAssets(), "font/adamina.ttf");
        titleTextView.setTypeface(custom_font);
        descriptionTextView.setTypeface(custom_font);

        // hide the title and description initially, the GridView click listener swaps visibility on and off
        titleTextView.setVisibility(View.INVISIBLE);
        descriptionTextView.setVisibility(View.INVISIBLE);

        // get ImageView reference from grid_item
        ImageView iconView = (ImageView) gridItemView.findViewById(R.id.grid_image);

        // get image resource from the current Location object and set to imageview
        iconView.setImageResource(currentLocation.getImageResourceId());

        // return the inflated view to fragment
        return gridItemView;

    }

}
