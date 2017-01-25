package ua.i4igo.tracker;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class TrackerActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        init();
    }

    protected void init(){

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(Constants.KYIV).title("Marker in Kiev"));

        // ставим маркер
        mMap.addMarker(new MarkerOptions().position(new LatLng(50.45, 30.5235)));

        //рисуем линию
        PolylineOptions polylineOptions = new PolylineOptions()
                .add(new LatLng(50.45, 30.5230))
                .add(new LatLng(50.47, 30.524))
                .add(new LatLng(50.49, 30.525))
                .add(new LatLng(50.5, 30.5255))
                .geodesic(true)
                .color(Color.MAGENTA).width(5);
        mMap.addPolyline(polylineOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Constants.KYIV, 15));

        //mMap.animateCamera();

        /*mMap.addCircle(new CircleOptions().center(new LatLng(50.444, 30.520)).radius(1.0).fillColor(R.color.colorPrimaryDark));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kiev));*/

    }


}

/*
* http://startandroid.ru/ru/uroki/vse-uroki-spiskom/291-urok-138-opredelenie-mestopolozhenija-gps-koordinaty.html
* http://startandroid.ru/ru/uroki/vse-uroki-spiskom/306-urok-139-google-maps-sozdanie-i-nastrojka-proekta-karta-kamera-sobytija.html
* http://startandroid.ru/ru/uroki/vse-uroki-spiskom/307-urok-140-google-maps-svoi-obekty-na-karte.html
*
* https://developers.google.com/android/reference/com/google/android/gms/maps/UiSettings
* https://developers.google.com/maps/documentation/android-api/start?hl=ru
* */