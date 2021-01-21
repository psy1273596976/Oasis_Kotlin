package com.example.oasis.ext

import android.view.View

/**
* View扩展 FindViewById的操作*/


fun <V :View> View.findView(id: Int):Lazy<V> = lazy {
    this.findViewById<V>(id)
}
