package com.cafe.querocafe.extensions

import android.app.Activity
import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.cafe.querocafe.App
import com.cafe.querocafe.ioc.ApplicationComponent

val Activity.ioc: ApplicationComponent
    get() = (application as App).component

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(factory: ViewModelProvider.Factory? = null): T =
    ViewModelProviders.of(this, factory).get(T::class.java)

inline fun <reified T : Activity> Activity.startActivity() {
    startActivity(Intent(this, T::class.java))
}

inline fun <reified T : ViewDataBinding> Activity.dataBindView(layoutId: Int): T =
    DataBindingUtil.setContentView(this, layoutId)
