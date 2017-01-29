package ua.i4igo.tracker;

import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                currentStatusGPS(location);
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

        locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 1000 * 5, 10, locationListener);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMyLocationEnabled(true);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Constants.KYIV, 12));

        // проверка GPS
        checkStatusGPS();

        current_lat = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER).getLatitude();
        current_lng = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER).getLongitude();

        if (current_lat != locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER).getLatitude()) {
            mMap.addMarker(new MarkerOptions()
                    .title("current position")
                    .position(currentLL));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLL, 10));
        }

        //mMap.animateCamera();
    }

    private void checkStatusGPS() {
        if (!locationManager.isProviderEnabled(locationManager.GPS_PROVIDER)) {
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
        }
    }

    private void currentStatusGPS(Location location) {
        if (location != null){
            //if (location.getLatitude() != current_lat) {
                current_lat = location.getLatitude();
                current_lng = location.getLongitude();
                currentLL = new LatLng(location.getLatitude(), location.getLongitude());
            }
                /*Toast.makeText(this, "gps_null", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "gps_ok:" + location.getLatitude() + ":" + location.getLongitude(), Toast.LENGTH_SHORT).show();*/


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