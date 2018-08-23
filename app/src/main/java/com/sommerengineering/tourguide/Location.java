package com.sommerengineering.tourguide;

/**
 * Custom Location object contains 2 strings and 1 image
 */
public class Location {

    // title
    private String mTitle;

    // description
    private String mDescription;

    // image
    private int mImageResourceId;

    // constructor
    public Location(String title, String description, int imageResourceId) {
        mTitle = title;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    // gets title
    public String getLocationTitle() {
        return mTitle;
    }

    // gets description
    public String getLocationDescription() {
        return mDescription;
    }

    // gets image resource ID
    public int getImageResourceId() {
        return mImageResourceId;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "mTitle='" + mTitle + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }

}
