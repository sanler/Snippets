package com.tid.snippets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Comment {

	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
	
	@Column
	private String  snippetId;
	
	@Column
	private String text;
	
	@ManyToOne(optional = false)
	private User user;
	
	public void User() {
		
	}

	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public String getSnippetId() {
		return snippetId;
	}




	public void setSnippetId(String snippetId) {
		this.snippetId = snippetId;
	}




	public Comment() {
		super();
	}
	
}
