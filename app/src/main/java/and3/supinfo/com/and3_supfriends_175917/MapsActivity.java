package and3.supinfo.com.and3_supfriends_175917;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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

        String myTitle = "Orleans";
        double myLatitude = 47.8735098;
        double myLongitude = 1.8421691;
        String mySnippet = "Orleans";
        if (null != getIntent()) {
            try
            {
                myTitle = getIntent().getStringExtra("Title");
                myLatitude = Float.parseFloat(getIntent().getStringExtra("Latitude"));
                myLongitude = Float.parseFloat(getIntent().getStringExtra("Longitude"));
                mySnippet = getIntent().getStringExtra("snippet");
            }
            catch(NullPointerException ex)
            {
                System.out.print("MAP : " + ex.getMessage());
            }
        }




        LatLng mypostion = new LatLng(myLatitude,myLongitude );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mypostion, 10));

        mMap.addMarker(new MarkerOptions()
                .title(myTitle)
                .snippet(mySnippet)
                .position(mypostion));


//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        mMap.setMyLocationEnabled(true);
//        // Check if we were successful in obtaining the map.
//        if (mMap != null) {
//
//
//            mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
//
//                @Override
//                public void onMyLocationChange(Location arg0) {
//                    // TODO Auto-generated method stub
//
//                    LatLng myLat = new LatLng(arg0.getLatitude(), arg0.getLongitude());
//
//                    mMap.addMarker(new MarkerOptions()
//                            .title("My Position")
//                            .position(myLat)
//                            .snippet("The most populous city in Australia."));
//                }
//            });
        }
}
