package springmvc.dao;

import org.springframework.data.repository.CrudRepository;

import springmvc.entity.BlogPost;
import springmvc.entity.User;

import java.util.List;

public interface BlogPostDAO extends CrudRepository<BlogPost, Long>{

    // Custom methods -- no need for implementation
	public List<BlogPost> findAllBlogPostsByUserAndTitleContaining(User user, String title);

	public List<BlogPost> findAllBlogPostsByUserAndDraft(User user, boolean draft);
}
