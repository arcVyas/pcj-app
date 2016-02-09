package com.jcp.poc

import com.jcp.poc.beans.Coupon
import com.jcp.poc.beans.CouponCategory
import com.jcp.poc.exceptions.CouponAlreadyExistsException
import com.jcp.poc.exceptions.CouponNotFoundException
import com.jcp.poc.mgr.CouponMgr
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins="*")
class CouponController {
    
    
    @RequestMapping(value = "/coupons", produces = "application/json", method=RequestMethod.GET)
    CouponCategory[] getCoupons() {
      println 'Came in'
      def response = new CouponMgr().getCouponsCategorized()
      println response.toString()
      return response
    }

    @RequestMapping(value = "/coupons", method=RequestMethod.POST, consumes="application/json")
    String createCoupon(@RequestBody Coupon coupon) {
      println coupon.id
      if(new CouponMgr().createCoupon(coupon))
        println "Created Coupon = " + coupon.id
      else
        throw new CouponAlreadyExistsException()
    }
    

    @RequestMapping(value = "/coupons/{couponId}", produces = "application/json", method=RequestMethod.POST)
    String updateCoupon(@PathVariable String couponId, @RequestBody Coupon coupon) {
      println couponId
      if(new CouponMgr().updateCoupon(couponId,coupon)){
        println "Updated Coupon = " + couponId
      }else{
        println "CouponId not found"
        throw new CouponNotFoundException(couponId)
      }
    }


    @RequestMapping(value = "/coupons/{couponId}", produces = "application/json", method=RequestMethod.DELETE)
    String deleteCoupon(@PathVariable String couponId) {
      println couponId
      if(new CouponMgr().deleteCoupon(couponId)){
        println "Deleted Coupon = " + couponId
      }else{
        println "CouponId not found"
        throw new CouponNotFoundException(couponId)
      }
    }
}
