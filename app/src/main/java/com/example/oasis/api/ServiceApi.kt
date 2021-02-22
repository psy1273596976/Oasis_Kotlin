package com.example.oasis.api


import com.example.kotlinbase.bean.login.RegisterBean
import com.example.oasis.bean.home.local.Local_ChannelBean
import com.example.oasis.bean.issue.issue_BrandBean
import com.example.oasis.bean.issue.issue_GoodsBean
import com.example.oasis.net.BaseResp
import com.example.oasis.bean.issue.SubmitTrendsData
import com.example.oasis.bean.issue.ThemeData
import com.example.oasis.bean.issue.TrendsData
import okhttp3.RequestBody
import retrofit2.http.*

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

    /**
     * 主题数据
     */
    @GET("theme/getTheme")
    suspend fun getTheme():BaseResp<List<ThemeData>>

    /**
     * 发布动态接口
     */
    @POST("trends/submitTrends")
    @Headers("Content-Type:application/json")
    suspend fun submitTrends(@Body trends: RequestBody):BaseResp<SubmitTrendsData>

    /**
     * 获取动态数据
     */
    @GET("trends/trendsList")
    suspend fun trendsList(@Query("command") command:Int,
                           @Query("channelid") channelid:Int,
                           @Query("page") page:Int,
                           @Query("size") size: Int):BaseResp<List<TrendsData>>



    //注册
    @POST("api/auth/register")
    @FormUrlEncoded
    suspend fun register(@Field("userName")userName :String,
                         @Field("userPsw")userPsw:String,
                         @Field("imei")imei:String,
                         @Field("lng")lng:String,
                         @Field("lat")lat:String):
            BaseResp<RegisterBean>

    //登录
    @POST("api/auth/login")
    @FormUrlEncoded
    suspend fun login(@Field("username")userName: String,@Field("password")password:String)
        :BaseResp<RegisterBean>
}