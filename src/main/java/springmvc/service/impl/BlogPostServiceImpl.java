package springmvc.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import springmvc.dao.BlogPostDAO;
import springmvc.entity.BlogPost;
import springmvc.entity.User;
import springmvc.service.BlogPostService;
import springmvc.service.EmailService;

public class BlogPostServiceImpl implements BlogPostService{

	private static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);
	
	@Autowired
	private BlogPostDAO blogPostDAO;
	
	@Autowired
	EmailService emailService;
	
	@Override
	public void savePost(BlogPost blogPost) {
		LOGGER.debug("BlogPostServiceImpl : savePost is called.");
		blogPost.setPublishDate(new Date());
		blogPostDAO.save(blogPost);

	}

	@Override
	public void saveAsDraft(BlogPost blogPost) {
		blogPost.setDraft(true);
		blogPostDAO.save(blogPost);
//		blogPostDAO.findAllBlogPostsByUserAndTitleContaining()
	}

	@Override
	public void deleteBlogPost(BlogPost blogPost) {

		blogPostDAO.delete(blogPost);
	}

	@Override
	public List<BlogPost> listAllBlogPostsByUserAndDraftStatus(User user, boolean draft) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlogPost> listAllBlogPostsByUserAndTitleLike(User user, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlogPost findBlogPostById(long id) {
		return blogPostDAO.findOne(id);
	}
}
