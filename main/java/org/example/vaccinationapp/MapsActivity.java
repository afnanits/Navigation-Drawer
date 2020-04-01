package org.example.vaccinationapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener, GoogleApiClient.ConnectionCallbacks
, GoogleApiClient.OnConnectionFailedListener {

    private GoogleMap mMap;
    GoogleApiClient client;
    LocationRequest request;
    LatLng latLngCurrent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
      //  findHospitals();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);




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

        client=new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        client.connect();
    }

    @Override
    public void onLocationChanged(Location location) {
        if(location==null){
            Toast.makeText(getApplicationContext(),"Location not found",Toast.LENGTH_SHORT).show();
        }
        else {
            latLngCurrent=new LatLng(location.getLatitude(),location
            .getLongitude());
            CameraUpdate update=CameraUpdateFactory.newLatLngZoom(latLngCurrent,15);
            mMap.animateCamera(update);
            MarkerOptions options=new MarkerOptions();
            options.title("Current Location");
            options.position(latLngCurrent);
            mMap.addMarker(options);
        }

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
            request=new LocationRequest().create();
            request.setInterval(1000);
            request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);



            LocationServices.FusedLocationApi.requestLocationUpdates(client,request, (com.google.android.gms.location.LocationListener) this);


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void findHospitals(){
        StringBuilder builder=new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        builder.append("location="+latLngCurrent.latitude+","+latLngCurrent.longitude);
        builder.append("&radius="+1000);
        builder.append("&keyword="+"hospital");
        builder.append("&key="+getResources().getString(R.string.google_maps_key));

        String url=builder.toString();

        Object dataTransfer[]=new Object[2];

        dataTransfer[0]=mMap;
        dataTransfer[1]=url;

        GetNearByHopital getNearByHopital=new GetNearByHopital(this);

        getNearByHopital.execute(dataTransfer);


    }



}
