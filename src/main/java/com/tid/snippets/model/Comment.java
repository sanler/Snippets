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

    @ManyToOne(optional = false)
    private Snippet snippet;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public Comment() {
		super();
	}
	
}
