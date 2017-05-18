package springmvc.service;

import springmvc.entity.User;

public interface UserService {

	public User findUserById(Long id);
	public User findUserWithBlogPostByUsername(String username);
	
}
