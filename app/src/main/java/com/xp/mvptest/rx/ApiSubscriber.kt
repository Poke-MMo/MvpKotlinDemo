package com.xp.mvptest.rx

import com.google.gson.JsonSyntaxException

import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

import io.reactivex.subscribers.ResourceSubscriber

/**
 * @author xp
 */
abstract class ApiSubscriber<T> : ResourceSubscriber<T>() {

    public override fun onStart() {
        request(Integer.MAX_VALUE.toLong())
    }

    override fun onComplete() {

    }

    /**
     * 只要链式调用中抛出了异常都会走这个回调
     */
    override fun onError(e: Throwable) {
        if (e is ApiException) {
            /*if (((ApiException) e).getCode().equals(Constant.REQUEST_KICK_OUT_CODE)) {
                CenterToast.show(((ApiException) e).getMsg());
                EventBus.getDefault().postSticky("logout");
                Utils.logout();
            } else {
                onError(((ApiException) e).getCode(), ((ApiException) e).getMsg());
            }*/
        } else if (e is ConnectException || e is UnknownHostException) {
            /*if (!Utils.isNetworkAvailable(AppManager.appContext())) {
                onError(Constant.NO_NETWORK, "网络异常，请检查网络！");
            } else {
//                onError(Constant.SERVER_ERROR, "服务端错误");
            }*/
        } else if (e is TimeoutException || e is SocketTimeoutException) {
            onError("", "连接超时，请稍后再试！")
        } else if (e is JsonSyntaxException) {
            onError("", "数据解析异常！")
        } else {
            onError("", "服务端错误")
        }
        e.printStackTrace()
    }

    protected abstract fun onError(errorCode: String, errorMsg: String)

}
