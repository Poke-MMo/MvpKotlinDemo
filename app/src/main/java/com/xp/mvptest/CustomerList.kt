package com.xp.mvptest

class CustomerList {

    /**
     * totalPage : 3
     * totalCustomer : 13
     * list : [{"area":"中关村科技园区","reason":"2018-01-06掉入公海(未跟进)","headquarters":0,"followStatus":null,"level":"A类（100万以上）","phone":null,"customerId":1,"customerCompany":"a","attribute":"4A","time":null,"brand":"a"},{"area":"中关村科技园区","reason":"2018-01-09掉入公海(未跟进)","headquarters":0,"followStatus":null,"level":"A类（100万以上）","phone":"123123","customerId":10,"customerCompany":"公司全称","attribute":"4A","time":null,"brand":"华商"},{"area":"中关村科技园区","reason":"","headquarters":0,"followStatus":null,"level":"A类（100万以上）","phone":"电r话","customerId":13,"customerCompany":"公司fsdfa全称","attribute":"4A","time":null,"brand":"华sadfa商"},{"area":"中关村科技园区","reason":"原因","headquarters":0,"followStatus":null,"level":"A类（100万以上）","phone":"电r话","customerId":14,"customerCompany":"fsd1a全称","attribute":"4A","time":null,"brand":"华sa01fa商"},{"area":"中关村科技园区","reason":"原因","headquarters":0,"followStatus":null,"level":"A类（100万以上）","phone":"电r话","customerId":15,"customerCompany":"fsdfa全称","attribute":"4A","time":null,"brand":"a;ia商"}]
     * currentPage : 1
     */

    var totalPage: Int = 0
    var totalCustomer: Int = 0
    var currentPage: Int = 0
    var list: List<ListBean>? = null

    class ListBean(var brand: String?) {

        /**
         * area : 中关村科技园区
         * reason : 2018-01-06掉入公海(未跟进)
         * headquarters : 0
         * followStatus : null
         * level : A类（100万以上）
         * phone : null
         * customerId : 1
         * customerCompany : a
         * attribute : 4A
         * time : null
         * brand : a
         */

        var area: String? = null
        var reason: String? = null
        var headquarters: Int = 0
        var followStatus: String? = null
        var level: String? = null
        var phone: String? = null
        var customerId: Int = 0
        var customerCompany: String? = null
        var attribute: String? = null
        var time: String? = null
        var fullBrand: String? = null
        var isRed: Int = 0
        var isChoose = false
    }
}
