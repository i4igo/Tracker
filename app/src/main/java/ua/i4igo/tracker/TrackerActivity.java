package ua.i4igo.tracker;

import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
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
    private LocationListener locationListener;
    private double current_lat;
    private double current_lng;
    private LatLng currentLL;

    private TextView tvBuilder;

    StringBuilder sbGPS = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        tvBuilder = (TextView) findViewById(R.id.tvBuilder);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                current_lat = location.getLatitude();
                current_lng = location.getLongitude();
                sbGPS.append(current_lat);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                1000, 0.1f, locationListener);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMyLocationEnabled(true);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Constants.KYIV, 12));

        //checkStatusGPS();

        if (locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER) != null) {
            current_lat = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER).getLatitude();
            current_lng = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER).getLongitude();
            mMap.addMarker(new MarkerOptions()
                    .title("current position")
                    .position(currentLL));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLL, 10));
        }

        //mMap.animateCamera();
        tvBuilder.setText(sbGPS);
    }

    private void checkStatusGPS() {
        if (!locationManager.isProviderEnabled(locationManager.GPS_PROVIDER)) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
    }

    private void currentStatusGPS(Location location) {
        currentLL = new LatLng(location.getLatitude(), location.getLongitude());
        mMap.addMarker(new MarkerOptions().position(currentLL));
    }
}

/*
* http://startandroid.ru/ru/uroki/vse-uroki-spiskom/291-urok-138-opredelenie-mestopolozhenija-gps-koordinaty.html
*
* https://developers.google.com/android/reference/com/google/android/gms/maps/UiSettings
* https://developers.google.com/maps/documentation/android-api/start?hl=ru
* https://developer.android.com/training/location/retrieve-current.html
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