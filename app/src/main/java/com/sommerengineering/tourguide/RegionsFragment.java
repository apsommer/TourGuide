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
public class RegionsFragment extends Fragment {

    // empty constructor
    public RegionsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // create ArrayList of custom Location objects
        // when declaring variable it is best practice to use the interface rather than the implementation of the interface
        List<Location> locations = new ArrayList<>();

        // inflate GridView in location_grid
        View rootView = inflater.inflate(R.layout.location_grid, container, false);

        // add Location objects to the ArrayList
        locations.add(new Location(getString(R.string.regions_granada_title), getString(R.string.regions_granada_description), R.drawable.granada));
        locations.add(new Location(getString(R.string.regions_ometepe_title), getString(R.string.regions_ometepe_description), R.drawable.ometepe));
        locations.add(new Location(getString(R.string.regions_san_juan_title), getString(R.string.regions_san_juan_description), R.drawable.san_juan));
        locations.add(new Location(getString(R.string.regions_managua_title), getString(R.string.regions_managua_description), R.drawable.managua));
        locations.add(new Location(getString(R.string.regions_lake_title), getString(R.string.regions_lake_description), R.drawable.lake_nicaragua));
        locations.add(new Location(getString(R.string.regions_corn_title), getString(R.string.regions_corn_description), R.drawable.corn_islands));
        locations.add(new Location(getString(R.string.regions_matagalpa_title), getString(R.string.regions_matagalpa_description), R.drawable.matagalpa));
        locations.add(new Location(getString(R.string.regions_tipitapa_title), getString(R.string.regions_tipitapa_descriptions), R.drawable.tipitapa));
        locations.add(new Location(getString(R.string.regions_diriamba_title), getString(R.string.regions_diriamba_description), R.drawable.diriamba));

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
