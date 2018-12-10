package com.xp.mvptest.rx

class ApiException(val code: String, val msg: String) : IllegalArgumentException(msg)
