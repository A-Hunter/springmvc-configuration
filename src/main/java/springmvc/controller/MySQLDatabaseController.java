package springmvc.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MySQLDatabaseController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MySQLDatabaseController.class);

	@Autowired
	private DriverManagerDataSource data;
	
	// Access to database without opening/closing database each time
	private JdbcTemplate jdbcTemplate;

	@RequestMapping(value="/displayUsersFromMySQL")
	public void displayUsers(){
		jdbcTemplate = new JdbcTemplate(data);
		List<Map<String, Object>> users = jdbcTemplate.queryForList("SELECT * FROM USER");
		
		for (Map<String, Object> user : users) {
			LOGGER.debug("MySQL - username : "+user.get("username"));
		}
	}
}
