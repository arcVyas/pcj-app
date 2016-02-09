package stepdefs.coupons

/**
 * Created by vyas on 2/8/16.
 */

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

import groovy.json.JsonSlurper

def couponJson = null
Given(~/^Coupons API is up and running$/) { ->
    assert true
}

When(~/^Coupons API is called to get the details$/) { ->
    couponJson = new JsonSlurper().parseText(new URL('http://ec2-52-88-137-255.us-west-2.compute.amazonaws.com:443/exp-comm-rest/coupons').text)
}

Then(~/^Coupon Category should be one of these "([^"]*)"$/) { String arg1 ->
    def couponCategoryList = arg1.split(",")*.trim()
    couponJson.each { couponCategory ->
        assert couponCategoryList.contains(couponCategory.category): "Error: Can't find ${couponCategory.category} in $couponCategoryList"
    }
}

Then(~/^offer details should not be blank$/) { ->

}

Then(~/^coupon should show up only if its validFrom date is in past and validTo date is in the future$/) { ->

}

Then(~/^urls in the coupon should be active$/) { ->

}
