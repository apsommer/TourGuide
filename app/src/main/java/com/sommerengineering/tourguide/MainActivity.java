package com.sommerengineering.tourguide;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // custom font
        final Typeface custom_font = Typeface.createFromAsset(getAssets(), "font/adamina.ttf");

        // hide the Action Bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        // initialize the activity by calling superclass method
        super.onCreate(savedInstanceState);

        // activity_main is simply a linearlayout holding tablayout and viewpager
        setContentView(R.layout.activity_main);

        // get reference to viewpager
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // custom adapter inflates the appropriate fragment and returns it to the viewpager
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

        // associate adapter to viewpager
        viewPager.setAdapter(adapter);

        // get reference to tablayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        // associate the tablayout with the viewpager
        // updates the tablayout on viewpager swipe, and on arbitrary selected tab
        // tab names set with fragment adapter's onPageTitle()
        tabLayout.setupWithViewPager(viewPager);

        // iterate through the tabs to set the custom view
        for (int i = 0; i < tabLayout.getTabCount(); i++) {

            // get reference to current tab
            TabLayout.Tab tab = tabLayout.getTabAt(i);

            // getTabView() is custom method in fragment adapter that returns inflated TextView
            tab.setCustomView(adapter.getTabView(i));
        }

        // format the first tab to ensure correct formatting on app start
        TabLayout.Tab tab = tabLayout.getTabAt(0);
        TextView textView = (TextView) tab.getCustomView(); // setCustomView executed in previous
        textView.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        textView.setTypeface(custom_font, Typeface.BOLD);

        // tab click listener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            // selected tab is black color and bold style
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                TextView textView = (TextView) tab.getCustomView();
                textView.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                textView.setTypeface(custom_font, Typeface.BOLD);
            }

            // unselected tab is gray color and normal style
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                TextView textView = (TextView) tab.getCustomView();
                textView.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.gray));
                textView.setTypeface(custom_font, Typeface.NORMAL);
            }

            // do nothing, same as selected state
            @Override
            public void onTabReselected(TabLayout.Tab tab) {}

        });

        // welcome alert box that describes app
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);

        // inflate and set the custom view
        View dialogView = getLayoutInflater().inflate(R.layout.welcome_dialog, null);
        dialogBuilder.setView(dialogView);

        // only need one "OK" button
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            // do nothing (enter the app)
            public void onClick(DialogInterface dialog, int id) {}

        });

        // apply custom font to both welcome messages in alert box
        TextView titleTextView = (TextView) dialogView.findViewById(R.id.dialog_title);
        TextView descriptionTextView = (TextView) dialogView.findViewById(R.id.dialog_description);
        titleTextView.setTypeface(custom_font);
        descriptionTextView.setTypeface(custom_font);

        // finish the alert box with create() and show(), update its background color
        AlertDialog alert = dialogBuilder.create();
        alert.show();
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(getApplicationContext(), R.color.colorTransparent)));

    }
}
