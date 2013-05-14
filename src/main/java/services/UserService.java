package services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import model.Suggestion;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import repository.SuggestionRepository;
import repository.UserRepository;


@Named
public class UserService {
	
	@Inject
	private UserRepository userrepository;
	
	@Inject
	private SuggestionRepository suggestionRepository;

	
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

	public UserService() {
		super();
	}
	

}
