package entity;

import java.sql.Timestamp;

public class Mutter {

	private String content;
	private User user;
	private Timestamp postDate;
	
	public Mutter(String content, User user, Timestamp postDate) {
		this.content = content;
		this.user = user;
		this.postDate = postDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getPostDate() {
		return postDate;
	}

	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}
	
	
}
