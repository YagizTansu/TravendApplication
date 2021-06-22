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

                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(userLastLocation, 16));
                }

                LatLng userLastLocation1 = new LatLng(lastLocation.getLatitude()+ 0.002, lastLocation.getLongitude()-0.001);
                googleMap.addMarker(new MarkerOptions().position(userLastLocation1).title(""));

                LatLng userLastLocation2 = new LatLng(lastLocation.getLatitude() -0.004, lastLocation.getLongitude() + 0.004);
                googleMap.addMarker(new MarkerOptions().position(userLastLocation2).title(""));

                LatLng userLastLocation3 = new LatLng(lastLocation.getLatitude()-0.0003, lastLocation.getLongitude() + 0.0019);
                googleMap.addMarker(new MarkerOptions().position(userLastLocation3).title(""));

                LatLng userLastLocation4 = new LatLng(lastLocation.getLatitude()+ 0.0027, lastLocation.getLongitude()-0.0024);
                googleMap.addMarker(new MarkerOptions().position(userLastLocation4).title(""));

                LatLng userLastLocation5 = new LatLng(lastLocation.getLatitude() -0.0034, lastLocation.getLongitude() + 0.0014);
                googleMap.addMarker(new MarkerOptions().position(userLastLocation5).title(""));

                LatLng userLastLocation6 = new LatLng(lastLocation.getLatitude()-0.00015, lastLocation.getLongitude()-0.0018);
                googleMap.addMarker(new MarkerOptions().position(userLastLocation6).title(""));


            }
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