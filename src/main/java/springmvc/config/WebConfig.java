package springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Configuration class dispatcher-servlet.xml
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"springmvc"})
@Import({ApplicationContext.class})
@PropertySource("classpath:application.properties")
public class WebConfig extends WebMvcConfigurerAdapter{

	//more custom rules/beans
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// index mapping
		// / -> index.jsp
		// Now Map the index.jsp :
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/newblogpost.html").setViewName("/newblogpost");
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		// map Strings to Views
		// success from a controller -> prefix/success/suffix
		//success from controller -> /WEB-INF/Pages/success.jsp
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolder(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
