package com.sommerengineering.tourguide;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple fragment subclass.
 */
public class VolcanoesFragment extends Fragment {

    // create ArrayList of Location objects
    private ArrayList<Location> locations = new ArrayList<>();

    // empty constructor
    public VolcanoesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // inflate GridView in location_grid
        View rootView = inflater.inflate(R.layout.location_grid, container, false);

        // add Location objects to the ArrayList
        locations.add(new Location("Masaya", "Santiago crater\nBat caves", R.drawable.masaya_volcano));
        locations.add(new Location("Apoyo", "Lagoon Natural Reserve\nSwimming\nKayaking", R.drawable.apoyo));
        locations.add(new Location("San Cristobal", "Highest volcano in the country\nExpert hiking", R.drawable.cristobal));
        locations.add(new Location("Cerro Negro", "Sand boarding\nHiking\nLeon nearby", R.drawable.cerro_negro));
        locations.add(new Location("Concepcion", "Rock climbing\nTropical rainforests\nOmetepe Island", R.drawable.concepcion));
        locations.add(new Location("Momotombo", "Old Leon ruins\nHiking", R.drawable.momotombo));
        locations.add(new Location("Maderas", "Prehistoric petroglyphs\nCloud forests\nOmetepe Island", R.drawable.maderas));
        locations.add(new Location("Mombacho", "Ziplines\nCloud forests\nDwarf forests", R.drawable.mombacho));

        // create custom adapter that uses Location objects to populate and inflate grid_item layouts
        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);

        // get reference to the GridView element in location_grid
        GridView gridView = (GridView) rootView.findViewById(R.id.grid);

        // associate custom adapter with the GridView element
        gridView.setAdapter(adapter);

        // set an item click listener on the GridView items
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            // click toggles the title and description panels
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // rename input argument for clarity
                View gridItemView = view;

                // get TextView references from grid_item
                TextView titleTextView = (TextView) gridItemView.findViewById(R.id.grid_title);
                TextView descriptionTextView = (TextView) gridItemView.findViewById(R.id.grid_description);

                // swap the visibility of the title and description panels
                if (titleTextView.getVisibility() == View.VISIBLE) {
                    titleTextView.setVisibility(View.INVISIBLE);
                    descriptionTextView.setVisibility(View.INVISIBLE);
                } else {
                    titleTextView.setVisibility(View.VISIBLE);
                    descriptionTextView.setVisibility(View.VISIBLE);
                }

            }

        });

        return rootView;

    }

}
