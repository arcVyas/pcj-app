package com.jcp.poc.mgr

import com.jcp.poc.beans.*
import com.jcp.poc.dao.CouponDAO

class CouponMgr{
  
  Coupon[] getCoupons(){
    return new CouponDAO().getCoupons()
  }
  
  CouponCategory[] getCouponsCategorized(){
    
    def coupons = getCoupons()
    def couponCategories=[:]
    def couponCategoryArr=[]
    coupons.each{ coupon ->
        def couponCategory = couponCategories[coupon.category]
        if(couponCategory==null){
          couponCategory = new CouponCategory(category:coupon.category, coupons:null)
        }
        def couponList = couponCategory.coupons
        if(couponList==null){
          couponList=new ArrayList<Coupon>()
        }
        couponList.add coupon
        couponCategory.coupons = couponList
        couponCategories[coupon.category] = couponCategory
    }
    couponCategories.each{k,v ->
      couponCategoryArr.add v
    }
    return couponCategoryArr
  }
  
  boolean createCoupon(Coupon coupon){
    return new CouponDAO().createCoupon(coupon)
  }
  
  boolean updateCoupon(String couponId,Coupon coupon){
    return new CouponDAO().updateCoupon(couponId,coupon)
  }
  
  boolean deleteCoupon(String couponId){
    return new CouponDAO().deleteCoupon(couponId)
  }
  
}
