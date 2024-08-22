package com.tt.app.database;

public class Site {
    private String siteName;
    private String gid3;
    private double lat;
    private double lon;

    public Site(String siteName, String gid3, double lat, double lon) {
        this.siteName = siteName;
        this.gid3 = gid3;
        this.lat = lat;
        this.lon = lon;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getGid3() {
        return gid3;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
