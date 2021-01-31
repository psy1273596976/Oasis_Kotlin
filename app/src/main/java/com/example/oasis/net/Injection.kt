package com.example.oasis.net
import android.util.Log


/**
 * 数据仓库的代理类
 */
object Injection {
    // 创建数据仓库  这里的lazy类似java中的饿汉单例
    val repository:SystemRepository by lazy {
        SystemRepository()
    }

    // 创建数据仓库
    //var repository:SystemRepository = SystemRepository()
}