package com.example.oasis.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import com.example.oasis.R
import com.example.oasis.app.Constants
import com.example.oasis.base.BaseActivity
import com.example.oasis.databinding.ActivityOasisBinding
import com.example.oasis.ui.issue.IssueActivity
import com.example.oasis.utils.MyMmkv
import com.example.oasis.viewmodel.OasisViewModel

//TODO 界面搭建
class OasisActivity : BaseActivity<OasisViewModel,ActivityOasisBinding>
    (R.layout.activity_oasis,OasisViewModel::class.java),View.OnClickListener{

    private lateinit var mFm:FragmentManager

    override fun initView() {
        initListener()
        initFragment()
    }

    //TODO fragment 管理器
    private fun initFragment() {
        mFm=supportFragmentManager
        //放入布局
        mFm.beginTransaction()
            .add(R.id.mRl_oasis,mViewModel.fragments[0])  //添加
            .add(R.id.mRl_oasis,mViewModel.fragments[1])
            .add(R.id.mRl_oasis,mViewModel.fragments[2])
            .add(R.id.mRl_oasis,mViewModel.fragments[3])
            .hide(mViewModel.fragments[1])  //隐藏
            .hide(mViewModel.fragments[2])
            .hide(mViewModel.fragments[3])
            .commit() //提交
    }

    //TODO 点击事件
    private fun initListener() {
        mDataBinding.layoutHome.setOnClickListener(this)
        mDataBinding.layoutSearch.setOnClickListener(this)
        mDataBinding.layoutIssue.setOnClickListener(this)
        mDataBinding.layoutInfo.setOnClickListener(this)
        mDataBinding.layoutMe.setOnClickListener(this)
    }

    override fun initVM() {

    }

    override fun initData() {
        //模拟已经登录
        MyMmkv.setValue("uid","21244f6f-4aed-4914-b824-9deead555c79")
        MyMmkv.setValue(Constants.token_key,"sprout-token")
        MyMmkv.setValue(Constants.token,"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiMjEyNDRmNmYtNGFlZC00OTE0LWI4MjQtOWRlZWFkNTU1Yzc5IiwicmFuZG9tIjoibWpodHRnaDllNiIsImlhdCI6MTYxMzk4NTI4Nn0.3u4ruxA8OR0QwgKV38E_Vti9329wkz4UBbCRlwi_GfA")
    }

    override fun initVariable() {

    }

    //TODO 事件的点击监听
    override fun onClick(v: View?) {
        //开启事务
        val t1=mFm.beginTransaction()
        //重置所有图片
        resetImg()
        when(v!!.id){
            R.id.layout_home -> {
                mDataBinding.ivOasisHomeImg.setImageResource(R.mipmap.main_nav_home_hl)
                t1.show(mViewModel.fragments.get(0))
                    .hide(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(3))
            }
            R.id.layout_search -> {
                mDataBinding.ivOasisSearchImg.setImageResource(R.mipmap.main_nav_discover_hl)
                t1.show(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(0))
                    .hide(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(3))
            }
            R.id.layout_issue ->{
                var intent=Intent(this,IssueActivity::class.java)
                startActivity(intent)
            }
            R.id.layout_info -> {
                mDataBinding.ivOasisInfoImg.setImageResource(R.mipmap.main_nav_message_hl)
                t1.show(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(0))
                    .hide(mViewModel.fragments.get(3))

            }
            R.id.layout_me -> {
                mDataBinding.ivOasisMeImg.setImageResource(R.mipmap.main_nav_mine_hl)
                t1.show(mViewModel.fragments.get(3))
                    .hide(mViewModel.fragments.get(1))
                    .hide(mViewModel.fragments.get(2))
                    .hide(mViewModel.fragments.get(0))
            }
        }
        t1.commit()
    }

    //TODO   重置所有属性
    private fun resetImg() {
        mDataBinding.ivOasisHomeImg.setImageResource(R.mipmap.main_nav_home_normal)
        mDataBinding.ivOasisSearchImg.setImageResource(R.mipmap.main_nav_discover_normal)
        mDataBinding.ivOasisInfoImg.setImageResource(R.mipmap.main_nav_message_normal)
        mDataBinding.ivOasisMeImg.setImageResource(R.mipmap.main_nav_mine_normal)
    }

}