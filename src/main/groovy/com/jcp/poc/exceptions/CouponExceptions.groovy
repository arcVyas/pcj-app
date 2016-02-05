package com.jcp.poc.exceptions
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.http.HttpStatus

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such coupon")  // 404
class CouponNotFoundException extends RuntimeException{
  String couponId
  
  CouponNotFoundException(id){
    couponId = id
  }
}

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Trying to create a coupon which already exists")  // 404
class CouponAlreadyExistsException extends RuntimeException{
  
}
