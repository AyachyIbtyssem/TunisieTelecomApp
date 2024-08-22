package com.tt.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.tt.app.database.DatabaseHelper;
import com.tt.app.database.Site;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.util.List;

public class MapActivity extends AppCompatActivity {

    private MapView mapView;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        // Initialize osmdroid configuration with a hardcoded user-agent
        Configuration.getInstance().setUserAgentValue("com.tt.app/1.0");

        mapView = findViewById(R.id.map);
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setMultiTouchControls(true);

        // Set the initial position of the map
        mapView.getController().setZoom(12.0);
        mapView.getController().setCenter(new GeoPoint(35.67305, 10.095933)); // Initial center

        dbHelper = new DatabaseHelper(this);
        displaySitesOnMap();
    }

    private void displaySitesOnMap() {
        List<Site> sites = dbHelper.getAllSites();

        for (Site site : sites) {
            GeoPoint location = new GeoPoint(site.getLat(), site.getLon());

            Marker marker = new Marker(mapView);
            marker.setPosition(location);
            marker.setTitle(site.getSiteName());
            marker.setSnippet("GID: " + site.getGid3());

            mapView.getOverlays().add(marker);
        }
    }
}
