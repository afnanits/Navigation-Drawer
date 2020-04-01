package org.example.vaccinationapp;

import android.os.AsyncTask;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetNearByHopital extends AsyncTask<Object,String,String> {
    GoogleMap mMap;
    String url;
BufferedReader reader;
InputStream is;
StringBuilder builder;
LatLng latlngCurrent;
String data;

    public GetNearByHopital(MapsActivity mapsActivity) {
    }

    public GetNearByHopital(GoogleMap mMap, String url, BufferedReader reader, InputStream is, StringBuilder builder, String data) {
        this.mMap = mMap;
        this.url = url;
        this.reader = reader;
        this.is = is;
        this.builder = builder;
        this.data = data;
    }

    @Override
    protected String doInBackground(Object... objects) {
        mMap=(GoogleMap)objects[0];
        url= (String) objects[1];
        try {
            URL myUrl=new URL(url);
            HttpURLConnection httpURLConnection= (HttpURLConnection) myUrl.openConnection();
            httpURLConnection.connect();
            is=httpURLConnection.getInputStream();
            reader=new BufferedReader(new InputStreamReader(is));

            String line="";
            line=reader.readLine();
            builder=new StringBuilder();

             while (line!=null){
                builder.append(this);

            }
            data=builder.toString();
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            JSONObject parentObject=new JSONObject(s);
            JSONArray resultArray=parentObject.getJSONArray("results");

            for(int i=0;i<resultArray.length();i++){
              JSONObject jsonObject=resultArray.getJSONObject(i);

                JSONObject locationObject=jsonObject.getJSONObject("geometry").getJSONObject("location");


                JSONObject nameObject=resultArray.getJSONObject(i);

                String latitude=locationObject.getString("lat");
                String longitude=locationObject.getString("long");
                String name=nameObject.getString("name");
                String vicinity=nameObject.getString("vicinity");



                LatLng latLng=new LatLng(Double.parseDouble(latitude),Double.parseDouble(longitude));

                MarkerOptions markerOptions=new MarkerOptions();

                markerOptions.title(vicinity);
                mMap.addMarker(markerOptions);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
