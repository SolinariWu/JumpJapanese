package com.example.solinari.finalproject;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Location_name_Activity extends FragmentActivity  implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String userloaction="";
    public LatLng locationLL = new LatLng(35.709062, 139.731992);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        Spinner loacsp =(Spinner)findViewById(R.id.location);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.location_name, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        loacsp.setAdapter(adapter);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        loacsp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Location_name_Activity.this, "顯示位置" + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                userloaction = "" + parent.getItemAtPosition(position);
                switch (userloaction) {
                    case "東京(とうきょう)":
                        locationLL = new LatLng(35.709062, 139.731992);
                        mMap.addMarker(new MarkerOptions().position(locationLL).title("東京(とうきょう)"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(locationLL));
                        break;
                    case "名古屋(なごや)":
                        locationLL = new LatLng(35.181446, 136.906397);
                        mMap.addMarker(new MarkerOptions().position(locationLL).title("名古屋(なごや)"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(locationLL));
                        break;
                    case "京都(きょうと)":
                        locationLL = new LatLng(35.01635, 135.768029);
                        mMap.addMarker(new MarkerOptions().position(locationLL).title("京都(きょうと)"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(locationLL));
                        break;
                    case "大阪(おおさか)":
                        locationLL = new LatLng(34.693737, 135.502164);
                        mMap.addMarker(new MarkerOptions().position(locationLL).title("大阪(おおさか)"));

                        mMap.moveCamera(CameraUpdateFactory.newLatLng(locationLL));
                        break;
                    case "神戶(こうべ)":
                        locationLL = new LatLng(34.690144, 135.195522);
                        mMap.addMarker(new MarkerOptions().position(locationLL).title("神戶(こうべ)"));

                        mMap.moveCamera(CameraUpdateFactory.newLatLng(locationLL));
                        break;
                    case "北海道(ほっかいど)":
                        locationLL = new LatLng(43.270401, 142.604372);
                        mMap.addMarker(new MarkerOptions().position(locationLL).title("北海道(ほっかいど)"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(locationLL));
                        break;


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

        // Add a marker in Sydney and move the camera

        mMap.addMarker(new MarkerOptions().position(locationLL).title("東京"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(locationLL));

    }
}
