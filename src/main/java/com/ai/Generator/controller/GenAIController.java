package com.ai.Generator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ai.Generator.service.ChatService;

@RestController
@RequestMapping("v1")
public class GenAIController {

  ChatService chatService;

  public GenAIController(ChatService service) {
    this.chatService = service;
  }

  @GetMapping("ask-ai")
  public String getResponse(@RequestParam String prompt) {
    return chatService.getResponse(prompt);
  }

  @GetMapping("ask-ai-options")
  public String getResponseOptions(@RequestParam String prompt) {
    return chatService.getResponseOptions(prompt, "gpt-4o", null);
  }

}
