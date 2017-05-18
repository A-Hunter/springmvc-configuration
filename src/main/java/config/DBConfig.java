package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springmvc.entity.DataSource;

@Configuration
public class DBConfig {

	@Bean
	public DataSource dataSource(){
		DataSource dataSource = new DataSource();
		dataSource.setUrl("http:\\x.y.z");
		dataSource.setUsername("Mr.hmat");
		dataSource.setPassword("hmatcorp");
		return dataSource;
	}
}
