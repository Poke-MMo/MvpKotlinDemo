package com.xp.mvptest.base

import com.trello.rxlifecycle2.LifecycleTransformer

interface BaseView {

    fun showToast(msg: String)
    /**
     * 显示加载动画
     */
    fun showLoading()

    /**
     * 隐藏加载
     */
    fun dismissLoading()

    /**
     * 绑定生命周期
     */
    fun <T> bindToLife(): LifecycleTransformer<T>
}
