package com.example.tugasbesar_pbp_f;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @POST("login")
    @FormUrlEncoded
    Call<BookingResponse> login(@Field("nim") String nim,
                             @Field("password") String password,
                             @Query("data") String data);

    //Berbagai method buat BOOKING/////////////////////////////////////////
    @GET("booking")
    Call<BookingResponse> getAllBooking(@Query("data") String data);

    @GET("booking/{id}")
    Call<BookingResponse> getBookingById(@Path("id") String id,
                                      @Query("data") String data);

    @POST("booking")
    @FormUrlEncoded
    Call<BookingResponse> createBooking(@Field("id_Pelanggan") int id_Pelanggan,
                                     @Field("name" ) String name,
                                     @Field("pick_Up_Location") String pick_Up_Location,
                                     @Field("pick_Up_Date") String pick_Up_Date,
                                     @Field("drop_Off_Date") String drop_Off_Date,
                                     @Field("pick_Up_Time") String pick_Up_Time,
                                     @Field("drop_Off_Time") String drop_Off_Time,
                                     @Field("car_Name") String car_Name,
                                     @Field("plat_nomor") String plat_nomor,
                                     @Field("driver_Age") String driver_Age,
                                     @Field("total") int total,
                                     @Field("status") String status);

    @PUT("booking/{id}")
    @FormUrlEncoded
    Call<BookingResponse> updateBooking(@Path("id") String id,
                                     @Field("pick_Up_Location") String pick_Up_Location,
                                     @Field("pick_Up_Date") String pick_Up_Date,
                                     @Field("drop_Off_Date") String drop_Off_Date,
                                     @Field("pick_Up_Time") String pick_Up_Time,
                                     @Field("drop_Off_Time") String drop_Off_Time,
                                     @Field("car_Name") String car_Name,
                                     @Field("plat_nomor") String plat_nomor,
                                     @Field("driver_Age") String driver_Age,
                                     @Field("total") int total);

    @DELETE("booking/{id}")
    Call<BookingResponse> deleteBooking(@Path("id") String id);

}
