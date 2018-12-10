package com.xp.mvptest

class CustomerListRequest {

    /**
     * customer : {"userId":1203,"industry":"111","area":"","attribute":"","source":"","level":"","followStatus":"","status":"1"}
     * action : {"meet":"","wechat":"","dinner":"","gifts":"","office":1,"home":"","advertisement":1,"submitPlan":1,"deal":1,"introduce":1}
     * type : 0
     * pageSize : 5
     * pageNum : 0
     */


    var customer: CustomerBean? = null
    var action: ActionBean? = null
    var type: String? = null
    var pageSize: String? = null
    var pageNum: String? = null
    var sort: String? = null
    var preUserId: String? = null
    var condition: String? = null
    var recordCondition: String? = null
    var token: String? = null
    var userId: String? = null

    class CustomerBean {
        /**
         * userId : 1203
         * industry : 111
         * area :
         * attribute :
         * source :
         * level :
         * followStatus :
         * status : 1
         */

        var userId: String? = null
        var industry: String? = null
        var area: String? = null
        var attribute: String? = null
        var source: String? = null
        var level: String? = null
        var followStatus: String? = null
        var status = "1"
        var organizationId: String? = null
        var chargeId: String? = null
        var departmentId: String? = null
        var belong: String? = null
        var attitude: String? = null
        var dateType: String? = null
        var isAttachment: String? = null
        var headquarters: String? = null
    }

    class ActionBean {
        /**
         * meet :
         * wechat :
         * dinner :
         * gifts :
         * office : 1
         * home :
         * advertisement : 1
         * submitPlan : 1
         * deal : 1
         * introduce : 1
         */

        var meet: String? = null
        var wechat: String? = null
        var dinner: String? = null
        var gifts: String? = null
        var office: String? = null
        var home: String? = null
        var advertisement: String? = null
        var submitPlan: String? = null
        var deal: String? = null
        var introduce: String? = null
    }
}
