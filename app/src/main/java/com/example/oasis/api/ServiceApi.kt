package com.example.oasis.api


import com.example.oasis.bean.home.local.Local_ChannelBean
import com.example.oasis.bean.issue.issue_BrandBean
import com.example.oasis.bean.issue.issue_GoodsBean
import com.example.oasis.net.BaseResp
import retrofit2.http.GET

import retrofit2.http.POST
import retrofit2.http.Query

/**
 * 网络请求API
 */
interface ServiceApi {
    //刷新token
    @POST("auth/refreshToken")  //刷新token
    suspend fun refreshToken(): BaseResp<String>

    //频道分类的数据
    @GET("channel/channel")
    suspend fun getLocal_Channel(): BaseResp<List<Local_ChannelBean>>

    //获取品牌数据
    @GET("tag/brand")
    suspend fun getBrand(@Query("page") page:Int, @Query("size") size:Int): BaseResp<issue_BrandBean>

    //获取商品数据
    @GET("tag/goods")
    suspend fun getGoods(@Query("page") page:Int, @Query("size") size:Int):BaseResp<issue_GoodsBean>
}