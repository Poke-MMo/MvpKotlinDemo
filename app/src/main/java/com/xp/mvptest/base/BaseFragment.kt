package com.xp.mvptest.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.android.FragmentEvent
import com.trello.rxlifecycle2.components.support.RxFragment

/**
 * @author xp
 * @date 2017/12/7
 */

abstract class BaseFragment<T : BasePresenter<*>> : RxFragment(), BaseView {

    protected lateinit var mPresenter: T

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(getLayoutId(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter = createPresenter()
        init()
    }

    /**
     * 创建presenter
     *
     * @return
     */
    protected abstract fun createPresenter(): T

    /**
     * 初始化
     */
    protected abstract fun init()

    protected abstract fun getLayoutId(): Int

    /**
     * 在此请求网络数据
     */
    override fun showToast(msg: String) {

    }

    override fun showLoading() {}

    override fun dismissLoading() {}

    /**
     * 绑定生命周期
     */
    override fun <T> bindToLife(): LifecycleTransformer<T> {
        return bindUntilEvent(FragmentEvent.DESTROY_VIEW)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter.detachView()
    }
}
