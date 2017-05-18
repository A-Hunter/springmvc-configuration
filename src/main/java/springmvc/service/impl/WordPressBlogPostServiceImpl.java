package springmvc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import springmvc.entity.BlogPost;
import springmvc.entity.User;
import springmvc.service.BlogPostService;

public class WordPressBlogPostServiceImpl implements BlogPostService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WordPressBlogPostServiceImpl.class);

	@Override
	public void savePost(BlogPost blogPost) {
		LOGGER.debug("WordPressBlogPostServiceImpl : savePost is called.");
		
	}

	@Override
	public void saveAsDraft(BlogPost blogPost) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBlogPost(BlogPost blogPost) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
