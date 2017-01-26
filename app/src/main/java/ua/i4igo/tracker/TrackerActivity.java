package ua.i4igo.tracker;

import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class TrackerActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        //mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.setMyLocationEnabled(true);

        // Add a marker in Sydney and move the camera
        //mMap.addMarker(new MarkerOptions().position(Constants.KYIV).title("Marker in Kiev"));
        //mMap.addMarker(new MarkerOptions().position(new LatLng(50.45, 30.5235)));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Constants.KYIV, 15));

        // проверка GPS
        checkStatusGPS();
        Location location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);

        Toast.makeText(this, "lat " + location.getLatitude(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "lng " + location.getLatitude(), Toast.LENGTH_SHORT).show();

        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(),location.getLongitude()), 15));


        /*mMap.setMyLocationEnabled(true);
        mMap.getMyLocation();*/

        //mMap.animateCamera();

        /*mMap.addCircle(new CircleOptions().center(new LatLng(50.444, 30.520)).radius(1.0).fillColor(R.color.colorPrimaryDark));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kiev));*/
    }

    private void checkStatusGPS() {
        if (!locationManager.isProviderEnabled(locationManager.GPS_PROVIDER)) {
            Toast.makeText(this, "no", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
    }

}

/*
* http://startandroid.ru/ru/uroki/vse-uroki-spiskom/291-urok-138-opredelenie-mestopolozhenija-gps-koordinaty.html
* http://startandroid.ru/ru/uroki/vse-uroki-spiskom/306-urok-139-google-maps-sozdanie-i-nastrojka-proekta-karta-kamera-sobytija.html
* http://startandroid.ru/ru/uroki/vse-uroki-spiskom/307-urok-140-google-maps-svoi-obekty-na-karte.html
*
* https://developers.google.com/android/reference/com/google/android/gms/maps/UiSettings
* https://developers.google.com/maps/documentation/android-api/start?hl=ru
*
*
* http://stackoverflow.com/questions/4721449/how-can-i-enable-or-disable-the-gps-programmatically-on-android
* http://www.enterra.ru/blog/gps-android/
* https://habrahabr.ru/post/123397/
*
*
* //рисуем линию
        PolylineOptions polylineOptions = new PolylineOptions()
                .add(new LatLng(50.45, 30.5230))
                .add(new LatLng(50.47, 30.524))
                .add(new LatLng(50.49, 30.525))
                .add(new LatLng(50.5, 30.5255))
                .geodesic(true)
                .color(Color.MAGENTA).width(5);
        mMap.addPolyline(polylineOptions);
*
* */