package com.jcp.poc.controllers

import com.jcp.poc.controllers.CouponController
import spock.lang.Specification

/**
 * Created by vyas on 2/8/16.
 */
class CouponControllerTest extends Specification {
    static def couponCategoryList
    static def coupons

    def setupSpec() {
        couponCategoryList = ['STOREWIDE & SITEWIDE OFFERS', 'HOME', 'MENS', 'ONLINE ONLY OFFERS', 'SERVICES']
        coupons = new CouponController().getCoupons()
    }

    def "GetCoupons - Validate Category Name"() {
        expect:
        coupons.each { couponCategory ->
            assert couponCategoryList.contains(couponCategory.category)
        }
    }

    def "GetCoupons - Make sure offer details are not BLANK"() {
        expect:
        coupons.each { couponCategory ->
            couponCategory.coupons.each { coupon ->
                coupon.offers.each { offer ->
                    assert offer.name != null && offer.name != ""
                    assert offer.description != null && offer.description != ""
                }

            }
        }
    }

    def "GetCoupons - Make sure coupon's validity start date is in the past and end date is in future"() {
        expect:
        coupons.each { couponCategory ->
            couponCategory.coupons.each { coupon ->
                if (coupon.validTo != null) {
                    assert coupon.validTo > new Date()
                }
                if (coupon.validFrom != null) {
                    assert coupon.validFrom < new Date()
                }

            }
        }
    }

    def "CreateCoupon"() {

    }

    def "UpdateCoupon"() {

    }

    def "DeleteCoupon"() {

    }
}
