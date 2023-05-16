package com.example.pcsoftapp.network;

import com.example.pcsoftapp.model.Activities;
import com.example.pcsoftapp.model.Company;
import com.example.pcsoftapp.model.Login;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


/**
 * APIRequests contains all the Network Request Methods with relevant API Endpoints
 **/

public interface APIRequests {
    @FormUrlEncoded
    @POST("dlrsrv/Getauthenticate")
    Call<Login> login(@Field("userid") String user_id,
                      @Field("pass") String password,
                      @Field("party_st") String partyst,
                      @Field("dlr") boolean dlr);


    @FormUrlEncoded
    @POST("pcsActivity/Getcompany")
    Call<ArrayList<Company>> getCompanyList(@Field("ResoType") String resotypr);


    @FormUrlEncoded
    @POST("pcsActivity/getData")
    Call<ArrayList<Company>> getProject(@Field("Party_NO") String partno,
                                        @Field("Tblname") String tblname,
                                        @Field("ResoType") String resotype);

    @FormUrlEncoded
    @POST("pcsActivity/getData")
    Call<ArrayList<Company>> getActivity(@Field("Party_NO") String partno,
                                        @Field("Tblname") String tblname,
                                        @Field("ResoType") String resotype,
                                         @Field("Projct_NO") String projrvtno);


    @FormUrlEncoded
    @POST("pcsActivity/SaveActivity")
    Call<Login> saveData(@Field("DOC_NO") String cocno,
                                      @Field("RESOTYPE") String resotype,
                                      @Field("PARTY_ST") String partst,
                                      @Field("PARTY_NO") String partyno,
                                      @Field("PRODUCTV") Integer produvt_tv,
                                      @Field("PROJCT_NO") String priject_no,
                                      @Field("C_PLN_CD") String cpln_cd,
                                      @Field("IM_CODE") String imcode,
                                      @Field("IM_REF") String im_ref,
                                      @Field("USER_ID") String user_id,
                                      @Field("longit") String longitude,
                                      @Field("latit") String latitude,
                                      @Field("in_addr") String inaddr,
                                      @Field("vcode") String vcode,
                                      @Field("CO_CD") String co_cd);

    @FormUrlEncoded
    @POST("pcsActivity/GetActivityDetail")
    Call<ArrayList<Activities>> getUserActivity(@Field("Party_NO") String partyno,
                                            @Field("Actdate") String date);















}