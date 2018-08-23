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
public class RegionsFragment extends Fragment {

    // create ArrayList of Location objects
    private ArrayList<Location> locations = new ArrayList<>();

    // empty constructor
    public RegionsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // inflate GridView in location_grid
        View rootView = inflater.inflate(R.layout.location_grid, container, false);

        // add Location objects to the ArrayList
        locations.add(new Location("Granada", "Colonial architecture\nMombacho volcano\nNearby islands", R.drawable.granada));
        locations.add(new Location("Ometepe Island", "Ojo de Agua pools\nConcepcion volcano\nMaderas volcano\nSanto Domingo Beach", R.drawable.ometepe));
        locations.add(new Location("San Juan del Sur", "La Flor Nature Reserve\nClifftop statue of Christ\nMaderas Beach", R.drawable.san_juan));
        locations.add(new Location("Managua", "Capital of Nicaragua\nStatue of Sandino\nMasaya volcano", R.drawable.managua));
        locations.add(new Location("Lake Nicaragua", "Kayaking\nFishing\nOmetepe Island", R.drawable.lake_nicaragua));
        locations.add(new Location("Corn Islands", "Scuba diving\nSnorkeling\nGolfing", R.drawable.corn_islands));
        locations.add(new Location("Matagalpa", "Nature reserves\nEco lodges\nWaterfalls", R.drawable.matagalpa));
        locations.add(new Location("Tipitapa", "Hot springs\nHistorical sites\nRivers", R.drawable.tipitapa));
        locations.add(new Location("Diriamba", "Eco lodges\nWaterfalls\nBeaches", R.drawable.diriamba));

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
