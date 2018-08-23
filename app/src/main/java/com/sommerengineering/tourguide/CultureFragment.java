package com.sommerengineering.tourguide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple fragment subclass.
 */
public class CultureFragment extends Fragment {

    // create ArrayList of custom Location objects
    private ArrayList<Location> locations = new ArrayList<>();

    // empty constructor
    public CultureFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // inflate GridView in location_grid
        View rootView = inflater.inflate(R.layout.location_grid, container, false);

        // add Location objects to the ArrayList
        locations.add(new Location("Leon", "Leon Cathedral\nCerro Negro volcano\nMomotombo volcano", R.drawable.leon));
        locations.add(new Location("Indio Maiz", "Biological Reserve\nRainforests\nHiking", R.drawable.indio_maiz));
        locations.add(new Location("Granada Islets", "Monkey Island\nBoat rides\n365 islands of lush vegetation", R.drawable.monkey_island));
        locations.add(new Location("Mi Museo", "Indigenous cermaics from 2000 BC\nArtwork", R.drawable.mi_museo));
        locations.add(new Location("Miraflor", "National Park\nCloud forests\nOver 200 species of orchids", R.drawable.miraflor));
        locations.add(new Location("Masaya", "National Artisan Market\nAsuncion Church\nMasaya volcano", R.drawable.national_market));

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
