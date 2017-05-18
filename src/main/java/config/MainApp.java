package config;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch.qos.logback.classic.Logger;
import springmvc.entity.DataSource;

public class MainApp {
	
	public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(MainApp.class);	
	
	public static void main(String[] args) {
		/**
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
		//BlogPostService blogPostService = applicationContext.getBean(BlogPostService.class);
		BlogPostService blogPostService = (BlogPostService) applicationContext.getBean("blogPostService");
		BlogPost blogPost = new BlogPost(1,"How to create a spring projet",
				"The major steps to create a spring project","2017-05-15 19:08:00","This is a simple draft.");
		blogPostService.savePost(blogPost);
		
		DataSource dataSource = (DataSource) applicationContext.getBean(DataSource.class);

		LOGGER.debug("URL : "+ dataSource.getUrl());
		LOGGER.debug("Username : "+ dataSource.getUsername());
		LOGGER.debug("Password : "+dataSource.getPassword());
		
		
		EmailService emailService = applicationContext.getBean(EmailService.class);
		emailService.sendEmail();
		
		ServiceManager serviceManager = applicationContext.getBean(ServiceManager.class);
		serviceManager.sendBlogPost(blogPost);
		((ConfigurableApplicationContext) applicationContext).close();
		*/
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		LOGGER.debug("URL : "+dataSource.getUrl());
		LOGGER.debug("Username : "+dataSource.getUsername());
		LOGGER.debug("Password : "+dataSource.getPassword());
		((ConfigurableApplicationContext) applicationContext).close();
	}

}
