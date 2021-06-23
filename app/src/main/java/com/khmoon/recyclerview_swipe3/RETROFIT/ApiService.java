package com.khmoon.recyclerview_swipe3.RETROFIT;

import com.khmoon.recyclerview_swipe3.DB.DB_Call;
import com.khmoon.recyclerview_swipe3.DB.DB_Device;
import com.khmoon.recyclerview_swipe3.DB.DB_Order;
import com.khmoon.recyclerview_swipe3.DB.DB_Store;
import com.khmoon.recyclerview_swipe3.DB.DB_checkserver;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    /******  php 목록 ******
     * ==> 경로: 59.8.46.164:7078/DIDp/json/
     * ----- GET ---------------------------------
     * restore_action.php
     * check_server.php
     * output_order.php
     * output_call.php
     *********************************************/

    @GET("didk_check_server.php")
    Call<List<DB_checkserver>> php_check_Server();
//    @GET("check_server.php")
//    Call<List<DB_checkserver>> php_CheckServer();

    @GET("didk_get_order.php")
    Call<List<DB_Order>> php_get_order(@Query("store") int store);

    @GET("didk_get_call.php")
    Call<List<DB_Call>> php_get_call(@Query("store") int store);

    @GET("didk_insert_order.php")
    Call<List<DB_Order>> php_insert_order(@Query("playerno") int playerno,
                                          @Query("store") int store,
                                          @Query("table") int table,
                                          @Query("number") int number);

    @GET("didk_insert_call.php")
    Call<List<DB_Call>> php_insert_call(@Query("playerno") int playerno,
                                        @Query("store") int store,
                                        @Query("table") int table,
                                        @Query("number") int number);

    @GET("didk_update_order.php")
    Call<List<DB_Order>> php_update_order(@Query("playerno") int playerno,
                                          @Query("store") int store,
                                          @Query("table") int table,
                                          @Query("number") int number);

    @GET("didk_delete_order.php")
    Call<List<DB_Order>> php_delete_order(@Query("playerno") int playerno,
                                          @Query("number") int nNumber);

    @GET("didk_delete_call.php")
    Call<List<DB_Call>> php_delete_call(@Query("playerno") int playerno,
                                        @Query("number") int nNumber);


    @GET("didk_get_store.php")
    Call<List<DB_Store>> php_get_store();

    @GET("didk_update_device.php")
    Call<List<String>> php_update_cputemp(@Query("sn") int sSN,
                                          @Query("fields") String fields,
                                          @Query("data") String data);

    @GET("didk_get_device.php")
    Call<List<DB_Device>> php_get_device(@Query("sn") int sSN);

    @GET("didk_insert_device.php")
    Call<List<DB_Device>> php_insert_device(@Query("sn") String sSN,
                                            @Query("storename") String storename,
                                            @Query("myip") String sMyIP,
                                            @Query("hallmode") String hallmode,
                                            @Query("nwidth") int nWidth,
                                            @Query("nheight") int nHeight,
                                            @Query("volume") int nVolume );

    @GET("didk_restore_call.php")
    Call<List<DB_Call>> php_restore_call(@Query("playerno") int nPlayerNo,
                                         @Query("store") int nStore);


}
