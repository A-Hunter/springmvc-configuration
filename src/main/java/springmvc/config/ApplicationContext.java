package springmvc.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springmvc.service.BlogPostService;
import springmvc.service.impl.BlogPostServiceImpl;

@EnableJpaRepositories(basePackages={"springmvc.dao"})
@EnableTransactionManagement
@Configuration
public class ApplicationContext {

	@Autowired
	private Environment environment;
	
	@Bean
	public DriverManagerDataSource dataFromMysql(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClass"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		return dataSource;
	}
	
	/**
	 * Used for embedded database
	 */
	
	@Bean
	@Qualifier("embedded")
	public EmbeddedDatabase data(){
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase embeddedDatabase = builder.setType(EmbeddedDatabaseType.HSQL)
													.addScript("dbschema.sql")
													.addScript("test-data.sql")
													.build();
		return embeddedDatabase;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory factory){
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(factory);
		return jpaTransactionManager;
	}
	
	
	@Bean
	public JpaVendorAdapter vendor(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		return adapter;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManager(){
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataFromMysql());
		
		entityManager.setPackagesToScan("springmvc.entity");
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		entityManager.setJpaProperties(jpaProperties);
		
		return entityManager;
	}
	
	@Bean
	public BlogPostService blogPostService(){
			return new BlogPostServiceImpl();
	}
	
	@Bean
	public DatabasePopulator populator(){
		ResourceDatabasePopulator resource = new ResourceDatabasePopulator();
		resource.setContinueOnError(true);
	}
}
