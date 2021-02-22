package com.example.oasis.net

import com.example.oasis.api.ServiceApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.RequestBody

/**
 * 数据仓库
 * 用来连接ViewModel和Model
 * 定义业务相关的网络请求接口的api   类似mvp的m层逻辑
 */
class SystemRepository {

    private lateinit var serviceApi: ServiceApi

    //初始化的方法
    init {
        serviceApi = RetrofitFactory.instance.create(ServiceApi::class.java)
    }

    /**
     * 刷新token
     */
    suspend fun refreshToken() = withContext(Dispatchers.IO){
        serviceApi.refreshToken()
    }

    //TODO 希望在协程里进行  所以使用suspend修饰

    //TODO 获取主页推荐的 Tab页的数据
    suspend fun getLoacl_Channel() = withContext(Dispatchers.IO){
        serviceApi.getLocal_Channel()
    }

    //TODO 获取品牌数据
    suspend fun getBrand(page:Int,size:Int) = withContext(Dispatchers.IO){
        serviceApi.getBrand(page,size)
    }

    //TODO 获取商品数据
    suspend fun getGoods(page: Int,size: Int) = withContext(Dispatchers.IO){
        serviceApi.getGoods(page,size)
    }

    //TODO 注册
    suspend fun getRegister(userName: String, userPsw: String, imei: String, lng: String, lat: String) = withContext(Dispatchers.IO){
        serviceApi.register(userName, userPsw, imei, lng, lat)
    }

    //TODO 登录
    suspend fun getLogin(userName: String,userPsw: String) = withContext(Dispatchers.IO){
        serviceApi.login(userName,userPsw)
    }


     //TODO 获取主题数据

    suspend fun getTheme() = withContext(Dispatchers.IO){
        serviceApi.getTheme()
    }


     //TODO 提交动态数据

    suspend fun submitTrends(requestBody: RequestBody) = withContext(Dispatchers.IO){
        serviceApi.submitTrends(requestBody)
    }


     //TODO 获取动态列表数据

    suspend fun trendsList(command:Int,channelid:Int,page:Int,size:Int) = withContext(Dispatchers.IO){
        serviceApi.trendsList(command,channelid,page,size)
    }



}