import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfig {

	public @Bean
	MongoDbFactory mongoDbFactory() throws Exception {
		def mongodb=null
		try{
			mongodb =  new SimpleMongoDbFactory(new MongoClient("172.17.0.2",27017), "jcp-poc");
		}catch(Exception e){
			mongodb =  new SimpleMongoDbFactory(new MongoClient(), "jcp-poc");
		}
		mongodb
	}

	public @Bean
	MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;

	}

}
