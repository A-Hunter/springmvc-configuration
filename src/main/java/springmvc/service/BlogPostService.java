package springmvc.service;

import java.util.List;

import springmvc.entity.BlogPost;
import springmvc.entity.User;

public interface BlogPostService {

	void savePost(BlogPost blogPost);
	void saveAsDraft(BlogPost blogPost);
	void deleteBlogPost(BlogPost blogPost);
	List<BlogPost> listAllBlogPostsByUserAndDraftStatus(User user, boolean draft);
	List<BlogPost> listAllBlogPostsByUserAndTitleLike(User user, String title);
	BlogPost findBlogPostById(long id);
}
