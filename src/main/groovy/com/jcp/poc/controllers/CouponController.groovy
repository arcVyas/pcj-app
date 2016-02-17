package com.jcp.poc.controllers

import com.jcp.poc.beans.Coupon
import com.jcp.poc.beans.CouponCategory
import com.jcp.poc.exceptions.CouponAlreadyExistsException
import com.jcp.poc.exceptions.CouponNotFoundException
import com.jcp.poc.mgr.CouponMgr
import org.springframework.web.bind.annotation.*

import io.swagger.annotations.*

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
@Api(value="Coupons", description="Coupons APIs")
class CouponController {

    @ApiOperation(value = "Get Coupons", response=CouponCategory.class, responseContainer="List")
    @RequestMapping(value = "/coupons", produces = "application/json", method=RequestMethod.GET)
    CouponCategory[] getCoupons() {
      println 'Came in'
      def response = new CouponMgr().getCouponsCategorized()
      println response.toString()
      return response
    }

    @ApiOperation(value = "Create Coupon", response=String.class)
    @RequestMapping(value = "/coupons", method=RequestMethod.POST, consumes="application/json")
    String createCoupon(@ApiParam(name="coupon", value="Coupon Json", required=true) @RequestBody Coupon coupon) {
      println coupon.id
      if(new CouponMgr().createCoupon(coupon))
        println "Created Coupon = " + coupon.id
      else
        throw new CouponAlreadyExistsException()
    }

    @ApiOperation(value = "Update Coupon", response=String.class)
    @RequestMapping(value = "/coupons/{couponId}", method=RequestMethod.POST)
    String updateCoupon(@ApiParam(name="couponId", value="Coupon ID", required=true) @PathVariable String couponId, @ApiParam(name="coupon", value="Coupon Json", required=true) @RequestBody Coupon coupon) {
      println couponId
      if(new CouponMgr().updateCoupon(couponId,coupon)){
        println "Updated Coupon = " + couponId
      }else{
        println "CouponId not found"
        throw new CouponNotFoundException(couponId)
      }
    }

    @ApiOperation(value = "Delete Coupon", response=String.class)
    @RequestMapping(value = "/coupons/{couponId}", method=RequestMethod.DELETE)
    String deleteCoupon(@ApiParam(name="couponId", value="Coupon ID", required=true) @PathVariable String couponId) {
      println couponId
      if(new CouponMgr().deleteCoupon(couponId)){
        println "Deleted Coupon = " + couponId
      }else{
        println "CouponId not found"
        throw new CouponNotFoundException(couponId)
      }
    }
}
