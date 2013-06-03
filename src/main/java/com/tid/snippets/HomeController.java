package com.tid.snippets;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tid.snippets.model.Comment;
import com.tid.snippets.model.Snippet;
import com.tid.snippets.model.Suggestion;
import com.tid.snippets.model.User;
import com.tid.snippets.repository.UserRepository;
import com.tid.snippets.services.UserService;



/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private List<Suggestion> suggestionList;
	private List<Snippet> snippetList;
	private User user;
	@Inject
	private UserService sbd;
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		user= new User();
		
		user.setEmail("pepito@pep.es");
		user.setUsername("pepito");
		
		suggestionList = new ArrayList<Suggestion>();
		
		sbd.service(user);
		suggestionList = sbd.readAllSuggestion();
		
		model.addAttribute("suggestionList", suggestionList);
		
		
		snippetList = new ArrayList<Snippet>();
		snippetList= sbd.readAllSnippet();
		model.addAttribute("snippetList", snippetList);
		
		return "home";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public @ResponseBody String add(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		sbd.createSuggestion("pepito2", "Mi primer mensaje", "Ola k ase");
		
		return "ok";
	}
	
	@RequestMapping(value = "/newUser", method = RequestMethod.GET)
	public String newUser( Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "newU";
	}
	
	@RequestMapping(value = "/newSnippet", method = RequestMethod.GET)
	public String newSnippet( Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "newSnippet";
	}
	
	@RequestMapping(value = "/addSnippet", method = RequestMethod.POST)
	public String addSnippet(@ModelAttribute("snippet") Snippet snippet, @ModelAttribute("username")String username, Locale locale, Model model, BindingResult result) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
	sbd.createSnippet(snippet.getText(), snippet.getType(), username);
		
		System.out.println("snippet :" + snippet.getText() + snippet.getType());
		
	return "home";
	}
	
	
	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("user") User user, Locale locale, Model model, BindingResult result) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		sbd.service(user);
		
		System.out.println("Username:" + user.getUsername() + 
                "email" + user.getEmail());
		
		System.out.println("Usuario registrado");
	return "home";
	}
	
	@RequestMapping(value = "/addSuggestion", method = RequestMethod.POST)
	public String addSuggestion(@ModelAttribute("suggestion") Suggestion suggestion, @ModelAttribute("username")String username, Locale locale, Model model, BindingResult result) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
	sbd.createSuggestion(username, suggestion.getTitle(), suggestion.getBody());
		
		System.out.println("suggestion :" + suggestion.getBody());
	return "home";
	}
	
	@RequestMapping(value = "/userSuggestion", method = RequestMethod.GET)
	public String userSuggestion( Locale locale, Model model, @RequestParam("name") String name) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		List<Suggestion> suggestions;
		suggestions = new ArrayList<Suggestion>();
		suggestions= sbd.readSuggestion(name);
		model.addAttribute("suggestions", suggestions);
		
		return "userSuggestion";
	}
	
	@RequestMapping(value = "/addComment", method = RequestMethod.GET)
	public String addComment( Locale locale, Model model, @RequestParam("name") String name) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		model.addAttribute("snippetId", name);
		Snippet snippet =     sbd.getSnippetById(name);
        List<Comment> comments = snippet.getComments();

		return "newComment";
	}
	
	@RequestMapping(value = "/regComment", method = RequestMethod.POST)
	public String regComment( @ModelAttribute("comment") Comment comment, @ModelAttribute("nameuser")String nameuser, Locale locale, Model model, BindingResult result) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		sbd.createComment(nameuser, comment.getText(), comment.getSnippetId());
		
		System.out.println("comment :" + comment.getText());
		
		return "home";
	}
}
