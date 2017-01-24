package ua.i4igo.tracker;

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
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng kiev = new LatLng(50.4501, 30.5234);
        mMap.addMarker(new MarkerOptions().position(kiev).title("Marker in Kiev"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kiev));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mMap.addMarker(new MarkerOptions().position(new LatLng(50.45, 30.5235)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kiev));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mMap.addMarker(new MarkerOptions().position(new LatLng(50.449, 30.5236)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kiev));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mMap.addMarker(new MarkerOptions().position(new LatLng(50.445, 30.524)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kiev));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mMap.addCircle(new CircleOptions().center(new LatLng(50.444, 30.520)).radius(1.0).fillColor(R.color.colorPrimaryDark));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kiev));

        mMap.addPolyline(new PolylineOptions().add(new LatLng(50.443, 30.523)).color(R.color.colorPrimary).width(5));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kiev));

    }


}
