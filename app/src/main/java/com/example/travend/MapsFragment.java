package com.example.travend;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Random;

public class MapsFragment extends Fragment {

    LocationManager locationManager;
    LocationListener locationListener;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(@NonNull Location location) {

                   /* googleMap.clear();
                    LatLng userLocation = new LatLng(location.getLatitude(),location.getLongitude());
                    googleMap.addMarker(new MarkerOptions().position(userLocation).title("Your Location"));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLocation,15));


                    for (int i = 0 ; i < 8 ; i++){
                        double minLat = location.getLatitude() -5 ;
                        double maxLat = location.getLatitude() -5;

                        double minLng = location.getLatitude() -5 ;
                        double maxLng = location.getLatitude() -5;

                        //Generate random int value from 50 to 100
                        int random_Lat = (int)Math.floor(Math.random()*(maxLat-minLat+1)+minLat);
                        int random_Lng = (int)Math.floor(Math.random()*(maxLng-minLng+1)+minLng);

                        LatLng randomLocation = new LatLng(random_Lat,random_Lng);
                        googleMap.addMarker(new MarkerOptions().position(randomLocation).title(""));
                    }
                */
                }
            };

            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                //permission
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            } else {
                //location
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

                Location lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                if (lastLocation != null) {
                    LatLng userLastLocation = new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude());
                    googleMap.addMarker(new MarkerOptions().position(userLastLocation).title("Your Location"));

                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLastLocation, 15));
                }

                LatLng userLastLocation1 = new LatLng(lastLocation.getLatitude()+ 0.003, lastLocation.getLongitude());
                googleMap.addMarker(new MarkerOptions().position(userLastLocation1).title("Your Location"));

                LatLng userLastLocation2 = new LatLng(lastLocation.getLatitude() -0.003, lastLocation.getLongitude());
                googleMap.addMarker(new MarkerOptions().position(userLastLocation2).title("Your Location"));

                LatLng userLastLocation3 = new LatLng(lastLocation.getLatitude()-0.0004, lastLocation.getLongitude());
                googleMap.addMarker(new MarkerOptions().position(userLastLocation3).title("Your Location"));

                for (double i = 0.0 ; i < 0.03 ; i += 0.003){
                    LatLng newLocation = new LatLng(lastLocation.getLatitude() + i , lastLocation.getLongitude()+-i ) ;
                    googleMap.addMarker(new MarkerOptions().position(newLocation).title(""));
                }
            }

            /*LatLng sydney = new LatLng(-48, 2);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));*/
        }

    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}