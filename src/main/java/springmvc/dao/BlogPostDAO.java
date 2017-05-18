package springmvc.dao;

import org.springframework.data.repository.CrudRepository;

import springmvc.entity.BlogPost;

public interface BlogPostDAO extends CrudRepository<BlogPost, Long>{

	

}
