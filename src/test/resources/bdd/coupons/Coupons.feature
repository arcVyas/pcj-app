Feature: Build an API to provide categorized coupon details for coupons page

  Scenario: Test coupon data from the API

    Given Coupons API is up and running

    When Coupons API is called to get the details

    Then Coupon Category should be one of these "STOREWIDE & SITEWIDE OFFERS, HOME, MEN's,ONLINE ONLY OFFERS,SERVICES"
    And offer details should not be blank
    And coupon should show up only if its validFrom date is in past and validTo date is in the future
    And urls in the coupon should be active
