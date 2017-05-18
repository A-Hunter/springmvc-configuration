package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springmvc.service.EmailService;
import springmvc.service.ServiceManager;
import springmvc.service.impl.EmailServiceImpl;
import springmvc.service.impl.ServiceManagerImpl;

@Configuration
public class ServiceConfig {

	@Bean
	public EmailService emailService(){
		return new EmailServiceImpl();
	}
	
	@Bean
	public ServiceManager serviceManager(){
		return new ServiceManagerImpl();
	}
}
