package com.example.oasis.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TableLayout
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.oasis.R
import com.example.oasis.base.BaseFragment
import com.example.oasis.databinding.FragmentHomeBinding
import com.example.oasis.ui.home.type.CareFragment
import com.example.oasis.ui.home.type.CityFragment
import com.example.oasis.ui.home.type.RecommendFragment
import com.example.oasis.viewmodel.home.HomeViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*

//TODO 首页页面
class HomeFragment : BaseFragment<HomeViewModel,FragmentHomeBinding>
    (R.layout.fragment_home,HomeViewModel::class.java){

    var mf=ArrayList<Fragment>()

    //采用伴生对象 companion object==static 只能创建一次
    companion object {
        val instance by lazy { HomeFragment() }
    }

    override fun initView() {
        initVp()
    }

    private fun initVp() {
        mf!!.add(CityFragment())
        mf!!.add(CareFragment())
        mf!!.add(RecommendFragment())
        home_viewpager.adapter=object :FragmentStatePagerAdapter(childFragmentManager){
            override fun getItem(position: Int): Fragment {
                return mf[position]
            }

            override fun getCount(): Int {
                return mf.size
            }

        }
        home_tab.setupWithViewPager(home_viewpager)
        home_tab.getTabAt(0)?.text = "同城"
        home_tab.getTabAt(1)?.text = "关注"
        home_tab.getTabAt(2)?.text = "推荐"
    }

    override fun initVM() {

    }

    override fun initData() {

    }

    override fun initVariable() {

    }

}