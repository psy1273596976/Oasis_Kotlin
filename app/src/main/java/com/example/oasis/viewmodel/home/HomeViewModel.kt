package com.example.oasis.viewmodel.home

import androidx.fragment.app.Fragment
import com.example.oasis.base.BaseViewModel
import com.example.oasis.net.Injection
import com.example.oasis.ui.home.attention.AttentionFragment
import com.example.oasis.ui.home.local.LocalFragment
import com.example.oasis.ui.home.recommend.RecommendFragment

class HomeViewModel: BaseViewModel(Injection.repository) {
    var fragments:MutableList<Fragment> = mutableListOf()

    //添加进集合
    init {
        fragments.add(AttentionFragment.instance)
        fragments.add(RecommendFragment.instance)
        fragments.add(LocalFragment.instance)
    }
}