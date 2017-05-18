package springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import springmvc.entity.BlogPost;
import springmvc.service.BlogPostService;
import springmvc.service.ServiceManager;

public class ServiceManagerImpl implements ServiceManager{

	@Autowired
	@Qualifier("WordPressBlogPostService")
	private BlogPostService blogPostService;
	@Override
	public void sendBlogPost(BlogPost blogPost) {

		blogPostService.savePost(blogPost);
	}

}
