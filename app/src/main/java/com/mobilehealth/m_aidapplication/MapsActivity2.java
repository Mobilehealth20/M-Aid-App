package com.mobilehealth.m_aidapplication;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.mobilehealth.m_aidapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {
    EditText mLatitude, mLongitude;
    ProgressBar progress2;

    private GoogleMap mMap;
    private DatabaseReference mDatabaseReference;
    private LocationListener mLocationListener;
    private LocationManager mLocationManager;

    private final long MIN_TIME = 1000; // 1 second
    private final long MIN_DIST = 5; // 5 metres

    private LatLng myLoc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mLatitude = findViewById(R.id.editLat);
        mLongitude = findViewById(R.id.editLongi);
        progress2 = findViewById(R.id.progress);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, PackageManager.PERMISSION_GRANTED);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Location");
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    String databaseLatitudeString = snapshot.child("latitude").getValue().toString().substring(1, snapshot.child("latitude").getValue().toString().length() -1);
                    String databaseLongitudeString = snapshot.child("longitude").getValue().toString().substring(1, snapshot.child("longitude").getValue().toString().length() -1);

                    String[] stringLat = databaseLatitudeString.split(", ");
                    Arrays.sort(stringLat);
                    String latitude = stringLat[stringLat.length-1].split("=")[1];


                    String[] stringLo = databaseLongitudeString.split(", ");
                    Arrays.sort(stringLo);
                    String longitude = stringLo[stringLo.length-1].split("=")[1];

                    LatLng latLng = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
//                    mMap.addMarker(new MarkerOptions().position(latLng).title("My Location"));
//                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,12));

                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

//        // Add a marker in Sydney and move the camera
        LatLng kenya = new LatLng(-1.226282, 36.884933);
        mMap.addMarker(new MarkerOptions().position(kenya).title("St Joseph Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kenya));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(kenya,12));




        mLocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                myLoc= new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(myLoc).title("My location"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(myLoc));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myLoc,12));
                try {
                    mLatitude.setText(Double.toString(location.getLatitude()));
                    mLongitude.setText(Double.toString(location.getLongitude()));
                }catch (Exception e){
                    e.printStackTrace();
                }



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

        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        try {
            mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME,MIN_DIST, mLocationListener);
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME,MIN_DIST, mLocationListener);
        } catch (SecurityException e){
            e.printStackTrace();
        }

    }

    public void updateButtonOnClick(View view){
        mDatabaseReference.child("Latitude Coordinates").push().setValue(mLatitude.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MapsActivity2.this, "Latitude Successfully uploaded",Toast.LENGTH_SHORT).show();
                progress2.setVisibility(View.GONE);

            }
        });
        mDatabaseReference.child("Longitude Coordinates").push().setValue(mLongitude.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(MapsActivity2.this, "Longitude Successfully uploaded",Toast.LENGTH_SHORT).show();
                progress2.setVisibility(View.GONE);
            }
        });

        progress2.setVisibility(View.VISIBLE);

    }
}