package com.tid.snippets.controllers;


import com.tid.snippets.services.MessageService;
import com.tid.snippets.services.SnippetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;


@Controller
public class SnippetController {

    private static final Logger logger = LoggerFactory.getLogger(SnippetController.class);

    private MessageService messageService;
    private SnippetService snippetService;

    public SnippetController(SnippetService snippetService, MessageService messageService) {
        this.messageService = messageService;
        this.snippetService = snippetService;
    }

}
