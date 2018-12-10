package com.xp.mvptest.rx


import com.xp.mvptest.base.BaseEntity

import org.reactivestreams.Publisher

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.FlowableOnSubscribe
import io.reactivex.FlowableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

/**
 * @author xp
 */
object DefaultTransformer {

    fun <T> transform(): FlowableTransformer<BaseEntity<T>, T> {
        return FlowableTransformer { upstream ->
            upstream.onBackpressureBuffer()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap { tBaseEntity ->
                        if (tBaseEntity.code == "000") {
                            createData(tBaseEntity.data)
                        } else {
                            Flowable.error(ApiException(tBaseEntity.code!!, tBaseEntity.msg!!))
                        }
                    }
        }
    }

    fun <T> createData(result: T): Flowable<T> {
        return Flowable.create({ e ->
            try {
                e.onNext(result)
                e.onComplete()
            } catch (exception: Exception) {
                e.onError(exception)
            }
        }, BackpressureStrategy.BUFFER)
    }
}
