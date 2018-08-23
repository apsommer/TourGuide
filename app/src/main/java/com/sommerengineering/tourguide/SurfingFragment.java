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
public class SurfingFragment extends Fragment {

    // create ArrayList of Location objects
    private ArrayList<Location> locations = new ArrayList<>();

    // empty constructor
    public SurfingFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // inflate GridView in location_grid
        View rootView = inflater.inflate(R.layout.location_grid, container, false);

        // add Location objects to the ArrayList
        locations.add(new Location("Aschunchillo", "MGA airport nearby\nBlack sand beaches", R.drawable.surf_aschunchillo));
        locations.add(new Location("Playa Maderas", "San Juan del Sur nearby", R.drawable.surf_maderas));
        locations.add(new Location("Popoyo", "Astillero Beach\nExcellent right wave", R.drawable.surf_popoyo));
        locations.add(new Location("Las Penitas", "Nature Reserve\nSea turtles", R.drawable.surf_penitas));
        locations.add(new Location("Puerto Sandino", "Fishing", R.drawable.surf_sandino));
        locations.add(new Location("Jiquilillo", "Sea turtles\nRemote location", R.drawable.surf_jiquilillo));
        locations.add(new Location("Playgrounds", "Accessible by boat\nCobblestone seafloor", R.drawable.surf_playgrounds));
        locations.add(new Location("Playa Hermosa", "Accessible by boat\n1 mile long", R.drawable.surf_hermosa));
        locations.add(new Location("Playa Santana", "Limon nearby\nPunchy and rampy wave", R.drawable.surf_santana));

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