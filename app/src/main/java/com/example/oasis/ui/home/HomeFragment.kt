package com.example.oasis.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TableLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.oasis.R
import com.example.oasis.base.BaseFragment
import com.example.oasis.databinding.FragmentHomeBinding
import com.example.oasis.viewmodel.home.HomeViewModel
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*

//TODO 首页页面
class HomeFragment : BaseFragment<HomeViewModel,FragmentHomeBinding>
    (R.layout.fragment_home,HomeViewModel::class.java){

    var pagerAdapter:ViewPage?=null

    //采用伴生对象 companion object==static 只能创建一次
    companion object {
        val instance by lazy { HomeFragment() }
    }

    override fun initView() {
        initVp()
    }

    private fun initVp() {
        mDataBinding.homeTab.getTabAt(0)?.setIcon(R.drawable.menu_attention_select)
        mDataBinding.homeTab.getTabAt(1)?.setIcon(R.drawable.menu_recommend_select)
        mDataBinding.homeTab.getTabAt(2)?.setIcon(R.drawable.menu_local_select)

        //设置适配器
        pagerAdapter = ViewPage(childFragmentManager,mViewModel.fragments)
        //绑定适配器
        mDataBinding.homeViewpager.adapter=pagerAdapter
        //设置ViewPager和Tab联动
        mDataBinding.homeTab.setupWithViewPager(mDataBinding.homeViewpager)
        initClick()
    }

    private fun initClick() {
        //在这里插入代码片
        mDataBinding.homeTab.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab) {}
            override fun onTabUnselected(tab: TabLayout.Tab) {
//                if (tab.customView!=null){
//                    val view  = tab.customView as TextView
//                    // 改变 tab 未选择状态下的字体大小
//                    view.textSize = 18F
//                    // 改变 tab 未选择状态下的字体颜色
//                    context?.let { ContextCompat.getColor(it, R.color.home_tab_unselected) }?.let {
//                        view.setTextColor(
//                            it
//                        )
//                    }
//                }

            }
            override fun onTabSelected(tab: TabLayout.Tab) {
//                if (tab.customView!=null){
//                    // 获取 tab 组件
//                    val view = tab.customView as TextView
//                    // 改变 tab 选择状态下的字体大小
//                    view.textSize = 22F
//                    // 改变 tab 选择状态下的字体颜色
//                    context?.let { ContextCompat.getColor(it, R.color.home_tab_selected) }?.let {
//                        view.setTextColor(
//                            it
//                        )
//                    }
//                }
                if(tab.position==0){
                    mDataBinding.homeTab.getTabAt(0)?.setIcon(R.drawable.menu_attention_select)
                }else if(tab.position==1){
                    mDataBinding.homeTab.getTabAt(1)?.setIcon(R.drawable.menu_recommend_select)
                }else{
                    mDataBinding.homeTab.getTabAt(2)?.setIcon(R.drawable.menu_local_select)
                }

            }
        })
    }

    override fun initVM() {

    }

    override fun initData() {

    }

    override fun initVariable() {

    }

    override fun onResume() {
        super.onResume()
        home_tab.getTabAt(0)!!.setIcon(R.drawable.menu_attention_select);
        home_tab.getTabAt(1)?.setIcon(R.drawable.menu_recommend_select)
        home_tab.getTabAt(2)?.setIcon(R.drawable.menu_local_select)
    }

    //TODO  viewpager适配器
    class ViewPage(supportFragmentManager: FragmentManager, val list: List<Fragment>):
        FragmentStatePagerAdapter(supportFragmentManager) {
        override fun getCount(): Int {
            return list.size
        }

        override fun getItem(position: Int): Fragment {
            return list.get(position)
        }

        //var mNames: Array<String>
//        override fun getPageTitle(position: Int): CharSequence? {
//            return mNames[position]
//        }
    }
}