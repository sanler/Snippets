package com.tid.snippets.model;

import java.util.List;

import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Named
@Entity
public class User {
	
	
	@Id
	private String username;
	@Column(nullable = false)
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<Suggestion> suggestions;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Suggestion> getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}
	public User() {
		super();
	}
	
	
}
