package com.example.oasis.api


import com.example.oasis.net.BaseResp

import retrofit2.http.POST

/**
 * 网络请求API
 */
interface ServiceApi {


    @POST("auth/refreshToken")  //刷新token
    suspend fun refreshToken(): BaseResp<String>






}