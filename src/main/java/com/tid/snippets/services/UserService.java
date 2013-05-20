package com.tid.snippets.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.tid.snippets.model.Comment;
import com.tid.snippets.model.Snippet;
import com.tid.snippets.model.Suggestion;
import com.tid.snippets.model.User;
import com.tid.snippets.repository.CommentRepository;
import com.tid.snippets.repository.SnippetRepository;
import com.tid.snippets.repository.SuggestionRepository;
import com.tid.snippets.repository.UserRepository;



@Named
public class UserService {
	
	@Inject
	private UserRepository userrepository;
	
	@Inject
	private SuggestionRepository suggestionRepository;

	@Inject
	private SnippetRepository snippetRepository;
	
	@Inject
	private CommentRepository commentRepository;
	
	@Transactional
	public void createSnippet(String text, String type, String name){
		//rellenar
		
		User user = userrepository.findOne(name);
		
		if(user!=null){
			Snippet snippet = new Snippet();
			snippet.setText(text);
			snippet.setType(type);
			snippet.setUser(user);
			snippetRepository.save(snippet);
		}
	}
	
	
	
	@Transactional
    public void service(User user) {
		userrepository.save(user);
	}

	public UserRepository getUserrepository() {
		return userrepository;
	}

	public void setUserrepository(UserRepository userrepository) {
		this.userrepository = userrepository;
	}
	
	@Transactional
	public void createSuggestion(String name, String title, String body){
		//rellenar
		
		User user = userrepository.findOne(name);
		
		if(user!=null){
			Suggestion suggestion = new Suggestion();
			suggestion.setTitle(title);
			suggestion.setBody(body);
			suggestion.setUser(user);
			suggestionRepository.save(suggestion);
		}
	}
	
	@Transactional
	public List<Suggestion> readAllSuggestion(){
		
		
		return suggestionRepository.findAll();
			
		
	}
	
	public List<Suggestion> readSuggestion(String name){

		return suggestionRepository.readUserSuggestion(name) ;

	}
	
	@Transactional
	public List<Snippet> readAllSnippet(){
		
		
		return snippetRepository.findAll();
			
		
	}
	
	@Transactional
	public void createComment(String name, String text, String snippetId){
		//rellenar
		
		User user = userrepository.findOne(name);
		
		if(user!=null){
			Comment comment = new Comment();
			comment.setText(text);
			comment.setSnippetId(snippetId);
			comment.setUser(user);
			commentRepository.save(comment);
		}
	}

	public UserService() {
		super();
	}
	

}
