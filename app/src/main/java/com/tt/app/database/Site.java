package com.tt.app.database;

public class Site {
    private String siteName;
    private String gid3;
    private double latitude;
    private double longitude;

    // Constructor
    public Site(String siteName, String gid3, double latitude, double longitude) {
        this.siteName = siteName;
        this.gid3 = gid3;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Default constructor
    public Site() {}

    // Getters and setters
    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getGid3() {
        return gid3;
    }

    public void setGid3(String gid3) {
        this.gid3 = gid3;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
