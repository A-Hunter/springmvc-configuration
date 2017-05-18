package springmvc.service.impl;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import springmvc.service.EmailService;

public class EmailServiceImpl implements EmailService{

	public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(EmailServiceImpl.class);
	
	@Override
	public void sendEmail() {
		LOGGER.debug("EmailServiceImpl : sendEmail is called.");
	}

}
