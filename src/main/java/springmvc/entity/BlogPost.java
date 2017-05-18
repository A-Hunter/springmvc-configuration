package springmvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="blog_post")
public class BlogPost {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="content", nullable=false)
	private String content;
	
	@Column(name="publishDate", nullable=true)
	private Date publishDate;
	
	@Column(name="draft", nullable=false)
	private boolean draft;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	
	public BlogPost(){
		super();
	}
	
	public BlogPost(long id, String title, String content, 
			Date publishDate, boolean draft) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.publishDate = publishDate;
		this.draft = draft;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public boolean getDraft() {
		return draft;
	}
	public void setDraft(boolean draft) {
		this.draft = draft;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
