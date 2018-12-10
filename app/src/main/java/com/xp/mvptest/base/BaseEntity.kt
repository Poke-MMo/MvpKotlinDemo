package com.xp.mvptest.base

import java.io.Serializable

/**
 * @author: xp
 * @date: 2017/4/26
 */

class BaseEntity<T> : Serializable {

    /**
     * status : true
     * code : 200
     * msg : 查询成功
     */

    var isStatus: Boolean = false
    var code: String? = null
    var msg: String? = null
    var data: T? = null
}
