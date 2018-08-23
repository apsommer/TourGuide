package com.sommerengineering.tourguide;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * .
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext; // context is always MainActivity, reference needed for getPageTitle()

    // constructor calls super and gets MainActivity context
    public CategoryAdapter(Context context, FragmentManager fragmentManager) {

        super(fragmentManager); // initialize object with superclass constructor
        mContext = context; // context is always MainActivity
    }

    // called by viewpager, supplies inflated full screen fragments
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new RegionsFragment();
        } else if (position == 1) {
            return new CultureFragment();
        } else if (position == 2) {
            return new VolcanoesFragment();
        } else {
            return new SurfingFragment();
        }
    }

    // simple count of number of pages = number of tabs
    @Override
    public int getCount() {
        return 4; // Regions, Culture, Volcanoes, Surfing
    }

    // supplies labels for tablayout, called by viewpager
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_regions);
        } else if (position == 1) {
            return mContext.getString(R.string.category_culture);
        } else if (position == 2) {
            return mContext.getString(R.string.category_volcanoes);
        } else { // position = 3 is the only remaining case
            return mContext.getString(R.string.category_surfing);
        }
    }

    // returns an inflated custom tab layout (a single TextView)
    public View getTabView(int position) {

        // root view is the single TextView
        View tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab, null);
        TextView textView = (TextView) tabView.findViewById(R.id.tabTextView);

        // set the tab text, font, and capitalization
        textView.setText(getPageTitle(position));
        Typeface custom_font = Typeface.createFromAsset(mContext.getAssets(), "font/adamina.ttf");
        textView.setTypeface(custom_font);
        textView.setAllCaps(true);

        return tabView;
    }

}
