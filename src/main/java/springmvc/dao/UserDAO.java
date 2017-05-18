package springmvc.dao;

import org.springframework.data.repository.CrudRepository;

import springmvc.entity.User;

public interface UserDAO extends CrudRepository<User, Long> {
    public User findUserByUsername(String username);
}
