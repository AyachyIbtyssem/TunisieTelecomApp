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
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.MapController;
import org.osmdroid.views.overlay.Marker;
import com.tt.app.database.DatabaseHelper;
import java.util.List;
import androidx.appcompat.widget.SearchView;
import android.util.Log;


public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private MapView mapView;
    private MapController mapController;
    private DatabaseHelper dbHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mapView = binding.mapview; // Obtenir la référence à MapView depuis le fichier XML
        mapController = (MapController) mapView.getController();
        dbHelper = new DatabaseHelper(requireContext()); // Initialiser dbHelper
        SearchView searchView = binding.searchView;

        /// Charger les préférences
        Configuration.getInstance().load(requireContext(), requireContext().getSharedPreferences("osmdroid", Context.MODE_PRIVATE));

        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setMultiTouchControls(true);
        mapView.getController().setZoom(12.0);
        mapView.getController().setCenter(new GeoPoint(35.67305, 10.095933)); // Centre initial

        // Marqueur de test1
        Marker testMarker = new Marker(mapView);
        testMarker.setPosition(new GeoPoint(35.67305, 10.095933));
        testMarker.setTitle("Kairouan_Ville");
        mapView.getOverlays().add(testMarker);

        Marker testMarker2 = new Marker(mapView);
        testMarker2.setPosition(new GeoPoint(35.660506, 10.107085));
        testMarker2.setTitle("El_Bourji"); // Only one setTitle call is needed
        mapView.getOverlays().add(testMarker2);


        // Marqueur de test3
        Marker testMarker3 = new Marker(mapView);
        testMarker3.setPosition(new GeoPoint(35.67355681, 10.08352176));        testMarker2.setTitle("Test Marker");
        testMarker3.setTitle("Aghalba_GSM");
        mapView.getOverlays().add(testMarker3);


        // Marqueur de test4
        Marker testMarker4 = new Marker(mapView);
        testMarker4.setPosition(new GeoPoint(35.66602435, 10.09677744));        testMarker2.setTitle("Test Marker");
        testMarker4.setTitle("CCL_Kairouan");
        mapView.getOverlays().add(testMarker4);

        // Marqueur de test5
        Marker testMarker5 = new Marker(mapView);
        testMarker5.setPosition(new GeoPoint(35.67179046, 10.0782828));        testMarker2.setTitle("Test Marker");
        testMarker5.setTitle("Cite_Okba");
        mapView.getOverlays().add(testMarker5);

        // Marqueur de test6
        Marker testMarker6 = new Marker(mapView);
        testMarker6.setPosition(new GeoPoint(35.66125352, 10.0781189));        testMarker2.setTitle("Test Marker");
        testMarker6.setTitle("Cite_Tajdid");
        mapView.getOverlays().add(testMarker6);

        // Marqueur de test7
        Marker testMarker7 = new Marker(mapView);
        testMarker7.setPosition(new GeoPoint(35.68111031, 10.10046456));        testMarker2.setTitle("Test Marker");
        testMarker7.setTitle("Dar_coran_GSM");
        mapView.getOverlays().add(testMarker7);

        // Marqueur de test8
        Marker testMarker8 = new Marker(mapView);
        testMarker8.setPosition(new GeoPoint(35.69160569, 10.09344744));        testMarker2.setTitle("Test Marker");
        testMarker8.setTitle("Ichbilia");
        mapView.getOverlays().add(testMarker8);

        // Marqueur de test9
        Marker testMarker9 = new Marker(mapView);
        testMarker9.setPosition(new GeoPoint(35.67143701, 10.10137068));        testMarker2.setTitle("Test Marker");
        testMarker9.setTitle("Kairouan_GSM");
        mapView.getOverlays().add(testMarker9);

        // Marqueur de test10
        Marker testMarker10 = new Marker(mapView);
        testMarker10.setPosition(new GeoPoint(35.70003494, 10.10534472));        testMarker2.setTitle("Test Marker");
        testMarker10.setTitle("KAIROUAN_ZI");
        mapView.getOverlays().add(testMarker10);

        // Marqueur de test11
        Marker testMarker11 = new Marker(mapView);
        testMarker11.setPosition(new GeoPoint(35.66797135, 10.0898766));        testMarker2.setTitle("Test Marker");
        testMarker11.setTitle("CITE_NACEUR");
        mapView.getOverlays().add(testMarker11);

        // Marqueur de test12
        Marker testMarker12 = new Marker(mapView);
        testMarker12.setPosition(new GeoPoint(35.67601617, 10.11029544));        testMarker2.setTitle("Test Marker");
        testMarker12.setTitle("CITE_ESSIOURI");
        mapView.getOverlays().add(testMarker12);

        // Marqueur de test13
        Marker testMarker13 = new Marker(mapView);
        testMarker13.setPosition(new GeoPoint(35.64793308, 10.08557256));        testMarker2.setTitle("Test Marker");
        testMarker13.setTitle("CITE_HEKMA");
        mapView.getOverlays().add(testMarker13);

        // Marqueur de test14
        Marker testMarker14 = new Marker(mapView);
        testMarker14.setPosition(new GeoPoint(35.66660229, 10.11155701));        testMarker2.setTitle("Test Marker");
        testMarker14.setTitle("EL_MALEH");
        mapView.getOverlays().add(testMarker14);

        // Marqueur de test15
        Marker testMarker15 = new Marker(mapView);
        testMarker15.setPosition(new GeoPoint(35.65671696, 10.08517212));        testMarker2.setTitle("Test Marker");
        testMarker15.setTitle("MANSOURA");
        mapView.getOverlays().add(testMarker15);

        // Marqueur de test16
        Marker testMarker16 = new Marker(mapView);
        testMarker16.setPosition(new GeoPoint(35.68249775, 10.08169776));        testMarker2.setTitle("Test Marker");
        testMarker16.setTitle("SIDI_SAHBI_GSM");
        mapView.getOverlays().add(testMarker16);

        // Marqueur de test17
        Marker testMarker17 = new Marker(mapView);
        testMarker17.setPosition(new GeoPoint(35.686115, 10.087495));        testMarker2.setTitle("Test Marker");
        testMarker17.setTitle("SAHBI_4");
        mapView.getOverlays().add(testMarker17);

        // Marqueur de test18
        Marker testMarker18 = new Marker(mapView);
        testMarker18.setPosition(new GeoPoint(35.67992531, 10.10693492));        testMarker2.setTitle("Test Marker");
        testMarker18.setTitle("S_SPORT_KAIR");
        mapView.getOverlays().add(testMarker18);

        // Marqueur de test19
        Marker testMarker19 = new Marker(mapView);
        testMarker19.setPosition(new GeoPoint(35.676573, 10.099981));        testMarker2.setTitle("Test Marker");
        testMarker19.setTitle("VILLE_ARABE_KA");
        mapView.getOverlays().add(testMarker19);

        mapView.invalidate(); // Forcer le rafraîchissement de la carte

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                rechercherSite(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });



        binding.buttonFirst.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );
    }

    private void ajouterMarqueursDepuisDB() {
        List<Site> sites = dbHelper.getAllSites(); // Méthode pour récupérer tous les sites depuis la DB
        for (Site site : sites) {
            Marker marker = new Marker(mapView);
            marker.setPosition(new GeoPoint(site.getLatitude(), site.getLongitude()));
            marker.setTitle(site.getSiteName());
            mapView.getOverlays().add(marker);
        }
        mapView.invalidate(); // Rafraîchir la carte
    }

    private void rechercherSite(String query) {
        List<Site> sitesTrouves = dbHelper.rechercherSiteParNom(query);

        // Supprimer les anciens marqueurs
        mapView.getOverlays().clear();

        if (sitesTrouves.isEmpty()) {
            Log.d("Search", "Aucun site trouvé pour la requête : " + query);
        } else {
            for (Site site : sitesTrouves) {
                Marker marker = new Marker(mapView);
                marker.setPosition(new GeoPoint(site.getLatitude(), site.getLongitude()));
                marker.setTitle(site.getSiteName());
                mapView.getOverlays().add(marker);
            }

            // Centrer et zoomer sur le premier résultat trouvé
            Site premierSite = sitesTrouves.get(0);
            mapController.setCenter(new GeoPoint(premierSite.getLatitude(), premierSite.getLongitude()));
            mapController.setZoom(15.0); // Ajustez le niveau de zoom selon les besoins
        }

        mapView.invalidate();
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
        if (mapView != null) {
            mapView.getOverlays().clear(); // Nettoyer les marqueurs
            mapView.onDetach(); // Détacher les événements
            mapView = null;
        }
        binding = null;
    }
}
