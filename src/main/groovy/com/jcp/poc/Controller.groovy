package com.jcp.poc

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.CrossOrigin
import com.jcp.poc.beans.Coupon

@RestController
class GreetingController {

    @RequestMapping("/greeting")
    String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @CrossOrigin(origins = "http://localhost:9080")
    @RequestMapping(value = "/coupons", produces = "application/json")
    Coupon[] getCoupons() {
      return [
        new Coupon(
          offerType: "IN STORE",
          offerText: "30% OFF IN STORE",
          offerDetails: "select orig and reg-priced apparel, shoes, accessories, fine jewelry & fashion jewelry",
          offerConditions: "VALID THROUGH JANUARY 30, 2016, NO CODE NECESSARY",
          offerGroup: "STOREWIDE & SITEWIDE OFFERS"
        )
      ]
    }
}
