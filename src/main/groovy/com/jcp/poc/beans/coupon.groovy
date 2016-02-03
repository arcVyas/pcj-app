package com.jcp.poc.beans

class Coupon{
  String id
  String category
  String channel
  Offer[] offers
  String validity
  String code
  Link[] links
  Date validFrom
  Date validTo 
} 

class Link{
  String name
  String title
  String desktopURL
  String tabletURL
  String mobileURL
}
