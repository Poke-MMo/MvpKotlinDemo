package com.xp.mvptest.base

abstract class BasePresenter<out V : BaseView>(view: V) {
    private var mView: V? = null

    val view: V
        get() = if (mView != null) {
            mView!!
        } else {
            throw IllegalStateException("view not attached")
        }

    init {
        attachView(view)
    }

    private fun attachView(view: V) {
        this.mView = view
    }

    fun detachView() {
        if (null != mView) {
            mView = null
        }
    }
}
