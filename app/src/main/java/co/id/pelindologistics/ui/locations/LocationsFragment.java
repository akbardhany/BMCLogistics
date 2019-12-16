package co.id.pelindologistics.ui.locations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import co.id.pelindologistics.R;

public class LocationsFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    public LocationsFragment(){
        //rq
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_locations, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.fMap);
        if (mapFragment == null){
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();
            ft.replace(R.id.fMap, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
        return root;
    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setTiltGesturesEnabled(false);

        LatLng pms = new LatLng(-7.210045,112.7235312);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pms, 14));

        LatLng cfsWarehouse = new LatLng(-7.2137556,112.7185696);
        mMap.addMarker(new MarkerOptions().position(cfsWarehouse).title("CFS Warehouse").snippet("BMC Logistics"));

        LatLng plp = new LatLng(-7.2237702,112.7235725);
        mMap.addMarker(new MarkerOptions().position(plp).title("Overbrengen (PLP)").snippet("BMC Logistics"));

        LatLng cdc3 = new LatLng(-7.211141,112.7242509);
        mMap.addMarker(new MarkerOptions().position(cdc3).title("CDC 3").snippet("BMC Logistics"));

        LatLng cdc2 = new LatLng(-7.2199812,112.7180823);
        mMap.addMarker(new MarkerOptions().position(cdc2).title("CDC 2").snippet("BMC Logistics"));

        LatLng icc = new LatLng(-7.2181667,112.7268658);
        mMap.addMarker(new MarkerOptions().position(icc).title("ICD - CDC - CCC").snippet("BMC Logistics"));

        LatLng bdj = new LatLng(-3.330166,114.560777);
        mMap.addMarker(new MarkerOptions().position(bdj).title("Banjarmasin Depot").snippet("BMC Logistics"));
    }

}