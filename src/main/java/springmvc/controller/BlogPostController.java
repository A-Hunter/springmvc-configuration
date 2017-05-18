package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import springmvc.entity.BlogPost;
import springmvc.entity.User;
import springmvc.service.BlogPostService;
import springmvc.service.UserService;

import java.util.List;

@Controller
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/saveBlogPost", method = RequestMethod.POST)
    public ModelAndView saveBlogPost(@RequestParam(value = "title") String title,
                                     @RequestParam(value = "content") String content,
                                     @RequestParam(value = "draft", required = false) boolean draft) {
        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(title);
        blogPost.setContent(content);
        blogPost.setDraft(draft);

        blogPost.setUser(userService.findUserWithBlogPostByUsername("user"));

        if (draft) {
            blogPostService.saveAsDraft(blogPost);
        } else {
            blogPostService.savePost(blogPost);
        }

        return new ModelAndView("newblogpost", "message", "BlogPost is saved.");
    }

    @RequestMapping(value = "/blogposts", method = RequestMethod.GET)
    public ModelAndView blogPosts() {
        User user = userService.findUserWithBlogPostByUsername("user");
        List<BlogPost> blogPosts = user.getBogPosts();
        return new ModelAndView("blogposts","blogposts",blogPosts);
    }

    @RequestMapping(value = "/draftblogposts", method = RequestMethod.GET)
    public ModelAndView draftBlogPost(){
        User user = userService.findUserWithBlogPostByUsername("user");
        List<BlogPost> draftBlogPosts = blogPostService.listAllBlogPostsByUserAndDraftStatus(user,true);
        return new ModelAndView("draftblogposts","draftblogposts",draftBlogPosts);
    }

    @RequestMapping(value = "/searchByTitle", method = RequestMethod.POST)
    public ModelAndView searchByTitle(@RequestParam(value="title") String title){
        User user = userService.findUserWithBlogPostByUsername("user");
        List<BlogPost> blogPosts = blogPostService.listAllBlogPostsByUserAndTitleLike(user,title);
        return new ModelAndView("draftblogposts","draftblogposts",blogPosts);
    }

    @RequestMapping(value = "/getBlogPostById/{id}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public @ResponseBody BlogPost getBlogPostById(@PathVariable(value="id") Long id){
        return blogPostService.findBlogPostById(id);
    }
}
