

package com.jcp.poc.dao.mongo

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

class Mongo{
  static ApplicationContext ctx= new AnnotationConfigApplicationContext(MongoConfig.class);
  static MongoOperations mongoOperation=null
  
  static MongoOperations getMongoOperation(){
    if (mongoOperation==null){
  	 mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    }
    return mongoOperation
  }
  
}
