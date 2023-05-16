package com.example.pcsoftapp.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pcsoftapp.DialogLoader;
import com.example.pcsoftapp.R;
import com.example.pcsoftapp.model.Company;
import com.example.pcsoftapp.model.Login;
import com.example.pcsoftapp.network.APIClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodayFragment extends Fragment {

    private ArrayList<Company> CompanyList;
    DialogLoader dialogLoader;

    private ArrayList<Company> ActivityList;
    private ArrayList<String> companyNames ;
    private ArrayList<Company> ProjectList;
    String longitude;
    private ArrayList<String> projectNames ;
    EditText edit_remark;
    String selectedproject;
    LocationManager locationManager;
    String latitude;
    Button Submit;
    private ArrayList<String> activitynames ;
    private Spinner spinner,projectspinner,activityspinner;
    SharedPreferences preferences ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_today, container, false);

         preferences = PreferenceManager.getDefaultSharedPreferences(getContext());

        spinner = view.findViewById(R.id.spCompany);
        projectspinner=view.findViewById(R.id.spProject);
        activityspinner=view.findViewById(R.id.spActivity);
        edit_remark=view.findViewById(R.id.remark);
        Submit=view.findViewById(R.id.btn_submit);
        CompanyList = new ArrayList<>();
        companyNames = new ArrayList<String>();
        ProjectList = new ArrayList<>();
        projectNames = new ArrayList<String>();
        ActivityList = new ArrayList<>();
        activitynames = new ArrayList<String>();


        fetchCompany();

        fecthProjects();
        //fecthActivity();


        projectspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView, int position, long id) {
                // Object item = parentView.getItemAtPosition(position);

                selectedproject=String.valueOf(ProjectList.get(position).getValue());

                fecthActivity(selectedproject);

            }

            public void onNothingSelected(AdapterView<?> arg0) {// do nothing
            }

        });


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogLoader = new DialogLoader(getActivity());
                dialogLoader.showProgressDialog("Submitting data");
                LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
                LocationListener locationListener = new TodayFragment.MyLocationListener();
                if ((ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);

                   //  Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();   // Toast is showing
                }



                String lat = preferences.getString("latitude","");
                String lon = preferences.getString("longitude","");
                String address = preferences.getString("currentaddress","");
                if(lat != null && lon != null && address!=null ){
                   submitdata(lat,lon,address);
                    Toast.makeText(getContext(),spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();   // Toast is showing






                }




            }






        });

        return  view;
    }

    private void submitdata(String lat, String lon, String address) {




        String Use_Id = preferences.getString("user_id","");


        Call<Login> call = APIClient.getInstance()
                .saveData("","E","E",Use_Id,0,selectedproject,"02","IM01",edit_remark.getText().toString(),"000055",lat,lon,address,"0-0",spinner.getSelectedItem().toString());








        call.enqueue(new Callback<Login>() {


            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.isSuccessful()) {
                  if(response.body().getStatus() == true){
                   dialogLoader.hideProgressDialog();
                  }



                }


            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {




                Toast toast = Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG);

                toast.show();
            }
        });
    }

    private class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location loc) {
           // Toast.makeText(getContext(), "OnLocationChanged", Toast.LENGTH_SHORT).show();   // Toast not showing
             longitude = String.valueOf(loc.getLongitude());
             latitude = String.valueOf(loc.getLatitude());
            Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());

            List<Address> addresses  = null;
            try {
                addresses = geocoder.getFromLocation(loc.getLatitude(),loc.getLongitude(), 1);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String address = addresses.get(0).getAddressLine(0);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("latitude",latitude);

            editor.putString("longitude",longitude);
            editor.putString("currentaddress",address);

            editor.apply();



           // edit_remark.setText(addresses.get(0).getAdminArea());

        }

        @Override
        public void onProviderDisabled(String provider) {
            Toast.makeText(getContext(), "onProviderDisabled", Toast.LENGTH_SHORT).show();  // Toast not showing
        }

        @Override
        public void onProviderEnabled(String provider) {
            Toast.makeText(getContext(), "on ProviderEnabled", Toast.LENGTH_SHORT).show();  // Toast not showing
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Toast.makeText(getContext(), "onStatusChanged", Toast.LENGTH_SHORT).show();  // Toast not showing
        }
    }

    private void fecthActivity(String selectedproject) {

        String Use_Id = preferences.getString("user_id","");


        Call<ArrayList<Company>> call = APIClient.getInstance()
                .getActivity(Use_Id,"ACTIVITY","E",selectedproject);


        call.enqueue(new Callback<ArrayList<Company>>() {


            @Override
            public void onResponse(Call<ArrayList<Company>> call, Response<ArrayList<Company>> response) {
                if (response.isSuccessful()) {

                    if(response.body() != null){

                        ActivityList  = response.body();





                        for (int i = 0; i < ActivityList.size(); i++){
                            activitynames.add(ActivityList.get(i).getText());

                        }




                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,activitynames);
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                        activityspinner.setAdapter(spinnerArrayAdapter);

                    }



                }


            }

            @Override
            public void onFailure(Call<ArrayList<Company>> call, Throwable t) {




                Toast toast = Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG);

                toast.show();
            }
        });
    }

    private void fecthProjects() {



        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
          String Use_Id = preferences.getString("user_id","");
        Call<ArrayList<Company>> call = APIClient.getInstance()
                .getProject(Use_Id,"PROJECTNO","E");


        call.enqueue(new Callback<ArrayList<Company>>() {


            @Override
            public void onResponse(Call<ArrayList<Company>> call, Response<ArrayList<Company>> response) {
                if (response.isSuccessful()) {

                    if(response.body() != null){

                        ProjectList  = response.body();





                        for (int i = 0; i < ProjectList.size(); i++){
                            projectNames.add(ProjectList.get(i).getText());

                        }
                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,projectNames);
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                        projectspinner.setAdapter(spinnerArrayAdapter);

                    }



                }


            }

            @Override
            public void onFailure(Call<ArrayList<Company>> call, Throwable t) {




                Toast toast = Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG);

                toast.show();
            }
        });
    }





    private void fetchCompany() {



        Call<ArrayList<Company>> call = APIClient.getInstance()
                .getCompanyList(" ");


        call.enqueue(new Callback<ArrayList<Company>>() {


            @Override
            public void onResponse(Call<ArrayList<Company>> call, Response<ArrayList<Company>> response) {
                if (response.isSuccessful()) {

             if(response.body() != null){

                 CompanyList  = response.body();





                 for (int i = 0; i < CompanyList.size(); i++){
                     companyNames.add(CompanyList.get(i).getText());

                     }




                      ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item,companyNames);
                      spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                      spinner.setAdapter(spinnerArrayAdapter);

             }



                }


            }

            @Override
            public void onFailure(Call<ArrayList<Company>> call, Throwable t) {




                Toast toast = Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG);

                toast.show();
            }
        });
    }
}