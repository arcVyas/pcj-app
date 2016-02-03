package com.jcp.poc

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.CrossOrigin
import com.jcp.poc.beans.*

@RestController
class CouponController {

    @RequestMapping("/greeting")
    String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @CrossOrigin(origins = "http://localhost:9080")
    @RequestMapping(value = "/coupons", produces = "application/json")
    CouponCategory[] getCoupons() {
      println 'Came in'
      def response = [
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
      ]
      println response.toString()
      return response
    }
}
