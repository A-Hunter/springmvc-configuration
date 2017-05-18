package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import config.ServiceConfig;
import springmvc.service.BlogPostService;
import springmvc.service.impl.BlogPostServiceImpl;
import springmvc.service.impl.MediumBlogPostServiceImpl;
import springmvc.service.impl.WordPressBlogPostServiceImpl;


@ComponentScan(basePackages={"spring"})
@Import(value={ServiceConfig.class})
public class JavaConfig {
	
	@Autowired
	DBConfig dbConfig;
	
	@Autowired
	ServiceConfig serviceConfig;
	
	@Bean // default bean id is the method name
	public BlogPostService blogPostService(){
		return new BlogPostServiceImpl();
	}
	
	@Bean(name="WordPressBlogPostService")
	public BlogPostService wordPressBlogPostService(){
		return new WordPressBlogPostServiceImpl();
	}
	
	@Bean(name="MediumBlogPostService")
	public BlogPostService mediumBlogPostService(){
		return new MediumBlogPostServiceImpl();
	}

}
