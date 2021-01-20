package com.example.oasis.api


import com.example.oasis.model.BaseResp

import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap
import java.util.HashMap

/**
 * 网络请求API
 */
interface ServiceApi {


    @POST("auth/refreshToken")  //刷新token
    suspend fun refreshToken(): BaseResp<String>






}