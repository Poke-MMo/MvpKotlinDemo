package com.xp.mvptest.base

import android.os.Bundle
import android.view.View

/**
 * @author xp
 * @date 2017/12/7
 */

abstract class BaseLazyFragment<T : BasePresenter<*>> : BaseFragment<T>() {

    private var isPrepared: Boolean = false//是否初始化完成
    private var isFirstLoad: Boolean = false//是否第一次加载
    private var isSee: Boolean = true//是否可见

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isPrepared = true
        isFirstLoad = true
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lazyLoad()
    }

    /**
     * 如果是与ViewPager一起使用，调用的是setUserVisibleHint
     *
     * @param isVisibleToUser 是否显示出来了
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (userVisibleHint) {
            isSee = true
            onVisible()
        } else {
            isSee = false
            onInvisible()
        }
    }

    /**
     * 如果是通过FragmentTransaction的show和hide的方法来控制显示，调用的是onHiddenChanged.
     * 若是初始就show的Fragment 为了触发该事件 需要先hide再show
     *
     * @param hidden hidden True if the fragment is now hidden, false if it is not
     * visible.
     */
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            isSee = true
            onVisible()
        } else {
            isSee = false
            onInvisible()
        }
    }

    protected fun onVisible() {
        lazyLoad()
    }

    protected fun onInvisible() {

    }

    protected fun lazyLoad() {
        if (!isPrepared || !isVisible || !isFirstLoad) {
            return
        }
        isFirstLoad = false
        fetchData()
    }

    /**
     * 在此请求网络数据
     */
    abstract fun fetchData()
}
