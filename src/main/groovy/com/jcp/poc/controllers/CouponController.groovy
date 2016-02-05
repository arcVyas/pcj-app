package com.jcp.poc

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.CrossOrigin  
import com.jcp.poc.mgr.CouponMgr
import com.jcp.poc.beans.*
import com.jcp.poc.exceptions.CouponNotFoundException
import com.jcp.poc.exceptions.CouponAlreadyExistsException

@RestController
@CrossOrigin(origins="*")
class CouponController {
    
    
    @RequestMapping(value = "/coupons", produces = "application/json", method=RequestMethod.GET)
    CouponCategory[] getCoupons() {
      println 'Came in'
      /*def response = [
        new CouponCategory(
          category:"STOREWIDE & SITEWIDE OFFERS", 
          coupons:
          [
            new Coupon(
              id: "coupon-123",
              channel: "IN STORE",
              category: "STOREWIDE & SITEWIDE OFFERS",
              code : "NO CODE NECESSARY",
              validity : "VALID THROUGH JANUARY 30, 2016",
              links: 
              [
                new Link(name:"shopURL", title:"shop now", desktopURL:"http://www.jcpenney.com/dotcom/sale/dept.jump?id=dept20022370024&cm_re=S2-_-FS-_-SHIPHOME"),
                new Link(name:"getDetails", title:"get details", desktopURL:"http://www.jcpenney.com/dotcom/jsp/browse/marketing/promotion.jsp?pageId=pg40047900009&cm_re=S2-_-FS-_-SHIPHOME")
              ],
              offers: 
              [ 
                new Offer(
                  name: "30% OFF IN STORE",
                  description: "select orig and reg-priced apparel, shoes, accessories, fine jewelry & fashion jewelry"
                )
              ]
            ),
            new Coupon(
              id: "coupon-241",
              channel: "IN STORE",
              category: "STOREWIDE & SITEWIDE OFFERS",
              code : "NO CODE NECESSARY",
              validity : "VALID THROUGH JANUARY 30, 2016",
              links: 
              [
                new Link(name:"shopURL", title:"shop now", desktopURL:"#"),
                new Link(name:"getDetails", title:"get details", desktopURL:"#")
              ],
              offers: 
              [ 
                new Offer(
                  name: "30% OFF IN STORE",
                  description: "select orig and reg-priced apparel, shoes, accessories, fine jewelry & fashion jewelry"
                )
              ]
            ),
            
          ]
        ),
        new CouponCategory(
          category:"IN STORE ONLY", 
          coupons:
          [
            new Coupon(
              id: "coupon-123",
              channel: "IN STORE",
              category: "STOREWIDE & SITEWIDE OFFERS",
              code : "NO CODE NECESSARY",
              validity : "VALID THROUGH JANUARY 30, 2016",
              links: 
              [
                new Link(name:"shopURL", title:"shop now", desktopURL:"http://www.jcpenney.com/dotcom/sale/dept.jump?id=dept20022370024&cm_re=S2-_-FS-_-SHIPHOME"),
                new Link(name:"getDetails", title:"get details", desktopURL:"http://www.jcpenney.com/dotcom/jsp/browse/marketing/promotion.jsp?pageId=pg40047900009&cm_re=S2-_-FS-_-SHIPHOME")
              ],
              offers: 
              [ 
                new Offer(
                  name: "30% OFF IN STORE",
                  description: "select orig and reg-priced apparel, shoes, accessories, fine jewelry & fashion jewelry"
                )
              ]
            ),
            new Coupon(
              id: "coupon-241",
              channel: "IN STORE",
              category: "STOREWIDE & SITEWIDE OFFERS",
              code : "NO CODE NECESSARY",
              validity : "VALID THROUGH JANUARY 30, 2016",
              links: 
              [
                new Link(name:"shopURL", title:"shop now", desktopURL:"#"),
                new Link(name:"getDetails", title:"get details", desktopURL:"#")
              ],
              offers: 
              [ 
                new Offer(
                  name: "30% OFF IN STORE",
                  description: "select orig and reg-priced apparel, shoes, accessories, fine jewelry & fashion jewelry"
                )
              ]
            )    
          ]
        )
      ]*/
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
