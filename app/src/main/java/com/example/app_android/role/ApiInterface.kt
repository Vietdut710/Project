package com.example.app_android.role

import com.example.app_android.obj.SongOnline
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("getsong.php")
    fun getSong(
        @Query("item_type") item_type: String?,
        @Query("key") keyword: String?
    ): Call<List<SongOnline?>?>?
}