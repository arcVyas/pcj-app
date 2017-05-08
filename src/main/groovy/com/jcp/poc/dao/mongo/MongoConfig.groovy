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
		def host = System.getProperty("mongoDBHost")
		def port = System.getProperty("mongoDBPort")
		println "Reading mongoHost and port from JVM args - $host:$port"
		if(host==null)
			host = "localhost"
		if (port==null)
			port = 27017
		
		port=port as int
		println "Connecting MongoDB @ $host:$port"
		try{
			mongodb =  new SimpleMongoDbFactory(new MongoClient(host,port), "jcp-poc");
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
