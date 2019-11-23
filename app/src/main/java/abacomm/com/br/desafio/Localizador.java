package abacomm.com.br.desafio;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Localizador {

    private static final int REQUEST_CHECK_SETTINGS = 613;

    private MainActivity activity;
    private LocationListener locationListener;
    private String cidade;

    public Localizador(MainActivity activity) {
        this.activity = activity;
    }

    public void configuraServico(){
        try {
            locationListener = locationListener();

            LocationManager locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER, locationListener,null);

        }catch(SecurityException ex){
            System.out.println(ex);
        }
    }

    private LocationListener locationListener() {
        return new LocationListener() {
            public void onLocationChanged(Location location) {
                getTheAddress(location.getLatitude(), location.getLongitude());
            }

            public void onStatusChanged(String provider, int status, Bundle extras) { }

            public void onProviderEnabled(String provider) { }

            public void onProviderDisabled(String provider) { }
        };
    }

    private void getTheAddress(double latitude, double longitude) {
        Thread thread = new Thread() {

            @Override
            public void run() {
                Geocoder geocoder = new Geocoder(activity.getApplicationContext(), Locale.getDefault());
                try {
                    List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
                    if (!addresses.isEmpty()) {
                        cidade = addresses.get(0).getSubAdminArea();
                        System.out.println("cidade: "+ cidade);
                        activity.abreEnquete(cidade);
                    }
                } catch(
                        IOException e)
                {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }


}

