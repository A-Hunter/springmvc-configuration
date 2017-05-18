package springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.dao.UserDAO;
import springmvc.entity.User;
import springmvc.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User findUserById(Long id) {
		
		return userDAO.findOne(id);
	}

	@Override
	public User findUserWithBlogPostByUsername(String username) {
		return userDAO.findUserByUsername(username);
	}

}
