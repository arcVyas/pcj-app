package com.jcp.poc.dao

import com.jcp.poc.beans.Coupon
import com.jcp.poc.dao.mongo.Mongo
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query

class CouponDAO{
  
  boolean createCoupon(Coupon coupon){
    boolean ret = false
    def mongoOperation = Mongo.getMongoOperation()
    Query couponQry = new Query(Criteria.where("id").is(coupon.id));
    if(mongoOperation.findOne(couponQry,Coupon.class)==null){
      mongoOperation.save(coupon)
      println "Inserted coupon"
      ret = true
    }else{
      println "Coupon already exists"
    }
    ret
  }
  
  boolean updateCoupon(String couponId, Coupon coupon){
    boolean ret = false
    def mongoOperation = Mongo.getMongoOperation()
    Query couponQry = new Query(Criteria.where("id").is(couponId));
    Coupon couponToUpdate = mongoOperation.findOne(couponQry,Coupon.class)
    println "CouponToUpdate: $couponToUpdate"
    if(couponToUpdate!=null){
      mongoOperation.save(coupon)
      println "Updated coupon - $couponId"
      ret=true
    }else{
      println "Coupon Id not found"
    }
    ret
  }
  
  boolean deleteCoupon(String couponId){
    boolean ret = false
    def mongoOperation = Mongo.getMongoOperation()
    Query couponQry = new Query(Criteria.where("id").is(couponId));
    Coupon couponToDelete = mongoOperation.findOne(couponQry,Coupon.class)
    println "couponToDelete: $couponToDelete"
    if(couponToDelete!=null){
      mongoOperation.remove(couponToDelete)
      println "Removed coupon - $couponId"
      ret=true
    }else{
      println "Coupon Id not found"
    }
    ret
  }

  Coupon[] getCoupons(){
    return Mongo.getMongoOperation().findAll(Coupon.class)
  }
  
}
