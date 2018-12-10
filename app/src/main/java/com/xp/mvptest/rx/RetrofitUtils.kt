package com.xp.mvptest.rx

import android.util.Log

import com.google.gson.Gson
import com.google.gson.GsonBuilder

import java.io.IOException
import java.util.concurrent.TimeUnit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtils(BASE_URL: String) {

    private val retrofit: Retrofit
    private val client: OkHttpClient

    init {
        client = OkHttpClient.Builder()
                //添加HttpLoggingInterceptor拦截器方便调试接口
                .addInterceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.addHeader("token", "eyJhbGciOiJIUzUxMiJ9.eyJjcmVhdGVkIjoxNTMyOTM0MjQ4Mzk2LCJleHAiOjE1MzM1MzkwNDgsInVzZXJuYW1lIjoiMTQzMTYzNDU2ODc5ODkxMSJ9.TqHV4PwenhAzUR1Wy3UZRZwaZFPwB6IHPJDrJ-VbiD73DX2m1FGs6bVxGVjRJbfzn28twB79GVsDsTX1UlDtRw")
                    chain.proceed(builder.build())
                }
                //添加HttpLoggingInterceptor拦截器方便调试接口
                .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.e(TAG, "==============" + message) }).setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                //                .retryOnConnectionFailure(true)
                .build()

        val gson = GsonBuilder()
                //                .setLenient()
                .create()

        retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    fun <T> createService(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }

    companion object {
        private val TAG = "RetrofitUtils"
        val BASE_URL = "http://t.zuul.xinchao.mobi/crm/api/"
        private val DEFAULT_TIMEOUT = 30_000L
    }

}
