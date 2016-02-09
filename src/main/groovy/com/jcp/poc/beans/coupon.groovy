package com.jcp.poc.beans

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "coupons")
class Coupon{
  @Id
  String id
  String category
  String channel
  ArrayList<Offer> offers
  String validity
  String code
  ArrayList<Link> links
  Date validFrom
  Date validTo 
} 
