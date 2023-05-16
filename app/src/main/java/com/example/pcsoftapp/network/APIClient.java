package com.example.pcsoftapp.network;




import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * APIClient handles all the Network API Requests using Retrofit Library
 **/

public class APIClient {
    
    public static Retrofit retrofit;
    public static APIRequests apiRequests;

    
    // Singleton Instance of APIRequests
    public static APIRequests getInstance() {
        if (apiRequests == null) {



            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient = new OkHttpClient()

                    .newBuilder()

                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)

                    .writeTimeout(100, TimeUnit.SECONDS)
                    .addInterceptor(interceptor)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://app.ieverp.com/PCSAPP/PCSAPI_V2/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        apiRequests = retrofit.create(APIRequests.class);

        return apiRequests;
    }

}
