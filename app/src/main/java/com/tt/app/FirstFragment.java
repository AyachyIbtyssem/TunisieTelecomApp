package com.tt.app;

import com.tt.app.database.Site;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.tt.app.databinding.FragmentFirstBinding;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapController;
import org.osmdroid.views.overlay.Marker;
import com.tt.app.database.DatabaseHelper;
import java.util.List;
import android.util.Log;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private MapView mapView;
    private MapController mapController;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialiser le MapView
        mapView = binding.mapview;
        mapController = (MapController) mapView.getController(); // Obtenir le contrôleur de la carte

        // Charger les préférences
        Configuration.getInstance().load(requireContext(), requireContext().getSharedPreferences("osmdroid", Context.MODE_PRIVATE));

        // Configurer la carte
        mapView.setTileSource(org.osmdroid.tileprovider.tilesource.TileSourceFactory.MAPNIK);
        mapView.setMultiTouchControls(true);

        // Définir le centre et le niveau de zoom
        mapController.setCenter(new GeoPoint(35.67355681, 10.08352176)); // Centre approximatif de Kairouan
        mapController.setZoom(15.0); // Définir le niveau de zoom

        // Récupérer les sites de la base de données
        DatabaseHelper dbHelper = new DatabaseHelper(requireContext());
        List<Site> sites = dbHelper.getAllSites();

        // Loguer le nombre de sites récupérés
        Log.d("FirstFragment", "Number of sites retrieved: " + sites.size());

        // Ajouter les marqueurs pour chaque site
        if (sites != null && !sites.isEmpty()) {
            for (Site site : sites) {
                Marker marker = new Marker(mapView);
                marker.setPosition(new GeoPoint(site.getLat(), site.getLon()));
                marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                marker.setTitle(site.getSiteName());
                mapView.getOverlays().add(marker);
            }
        } else {
            Log.d("FirstFragment", "No sites found in the database.");
        }

        // Ajouter les marqueurs pour chaque site
        for (Site site : sites) {
            Marker marker = new Marker(mapView);
            marker.setPosition(new GeoPoint(site.getLat(), site.getLon()));
            marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
            marker.setTitle(site.getSiteName());
            mapView.getOverlays().add(marker);
        }

        binding.buttonFirst.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );
    }


    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume(); // Gérer le cycle de vie de MapView
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause(); // Gérer le cycle de vie de MapView
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
