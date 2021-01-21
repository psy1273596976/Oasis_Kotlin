package com.example.oasis.viewmodel

import androidx.fragment.app.Fragment
import com.example.oasis.base.BaseViewModel
import com.example.oasis.net.Injection
import com.example.oasis.ui.info.InfoFragment
import com.example.oasis.ui.home.HomeFragment
import com.example.oasis.ui.me.MeFragment
import com.example.oasis.ui.search.SearchFragment

class OasisViewModel : BaseViewModel(Injection.repository){
    var fragments:MutableList<Fragment> = mutableListOf()

    //添加进入集合
    init {
        fragments.add(HomeFragment.instance)
        fragments.add(SearchFragment.instance)
        fragments.add(InfoFragment.instance)
        fragments.add(MeFragment.instance)
    }
}