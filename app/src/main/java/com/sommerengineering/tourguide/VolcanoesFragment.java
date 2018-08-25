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
import java.util.List;

/**
 * A simple fragment subclass.
 */
public class VolcanoesFragment extends Fragment {

    // empty constructor
    public VolcanoesFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // create ArrayList of custom Location objects
        // when declaring variable it is best practice to use the interface rather than the implementation of the interface
        List<Location> locations = new ArrayList<>();

        // inflate GridView in location_grid
        View rootView = inflater.inflate(R.layout.location_grid, container, false);

        // add Location objects to the ArrayList
        locations.add(new Location(getString(R.string.volcanoes_masaya_title), getString(R.string.volcanoes_masaya_description), R.drawable.masaya_volcano));
        locations.add(new Location(getString(R.string.volcanoes_apoyo_title), getString(R.string.volcanoes_apoyo_description), R.drawable.apoyo));
        locations.add(new Location(getString(R.string.volcanoes_cristobal_title), getString(R.string.volcanoes_cristobal_description), R.drawable.cristobal));
        locations.add(new Location(getString(R.string.volcanoes_cerro_title), getString(R.string.volcanoes_cerro_description), R.drawable.cerro_negro));
        locations.add(new Location(getString(R.string.volcanoes_concepcion_title), getString(R.string.volcanoes_concepcion_description), R.drawable.concepcion));
        locations.add(new Location(getString(R.string.volcanoes_momotombo_title), getString(R.string.volcanoes_momotombo_description), R.drawable.momotombo));
        locations.add(new Location(getString(R.string.volcanoes_maderas_title), getString(R.string.volcanoes_maderas_description), R.drawable.maderas));
        locations.add(new Location(getString(R.string.volcanoes_mombacho_title), getString(R.string.volcanoes_mombacho_description), R.drawable.mombacho));

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
