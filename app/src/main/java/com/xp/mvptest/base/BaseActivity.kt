package com.xp.mvptest.base

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager

import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity

/**
 * @author xp
 * @date 2017/12/7
 */

abstract class BaseActivity<T : BasePresenter<*>> : RxAppCompatActivity(), BaseView {
    protected lateinit var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        mPresenter = createPresenter()
        init()
    }

    protected abstract fun createPresenter(): T

    protected abstract fun init()

    protected abstract fun getLayoutId(): Int

    /**
     * 显示加载框
     */
    override fun showLoading() {

    }

    /**
     * 取消加载框
     */
    override fun dismissLoading() {

    }

    /**
     * toast提示
     *
     * @param msg
     */
    override fun showToast(msg: String) {

    }


    /**
     * 绑定生命周期
     */
    override fun <T> bindToLife(): LifecycleTransformer<T> {
        return bindUntilEvent(ActivityEvent.DESTROY)
    }

    /**
     * 关闭软键盘
     */
    fun closeKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.applicationWindowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        // 解绑view
        mPresenter.detachView()
    }

    companion object {
        private val TAG = "BaseActivity"
    }
}
