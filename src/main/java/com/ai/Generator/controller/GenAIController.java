package com.ai.Generator.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ai.Generator.service.ChatService.ChatService;
import com.ai.Generator.service.ImageService.ImageService;
import com.ai.Generator.service.RecipeService.RecipeService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("v1")
// @CrossOrigin("http://localhost:3000")
public class GenAIController {

  private final ChatService chatService;

  private final ImageService imageService;

  private final RecipeService recipeService;

  public GenAIController(ChatService chatService, ImageService imageService, RecipeService recipeService) {
    this.chatService = chatService;
    this.imageService = imageService;
    this.recipeService = recipeService;
  }

  @GetMapping("ask-ai")
  public String getResponse(@RequestParam String prompt) {
    return chatService.getResponse(prompt);
  }

  @GetMapping("ask-ai-options")
  public String getResponseOptions(@RequestParam String prompt) {
    return chatService.getResponseOptions(prompt, "gpt-4o", null);
  }

  // @GetMapping("generate-image")
  // public void generateImage(HttpServletResponse response, @RequestParam String
  // prompt) throws IOException {
  // ImageResponse imageResponse = imageService.generateImage(prompt);
  // String imageUrl = imageResponse.getResult().getOutput().getUrl();
  // response.sendRedirect(imageUrl);
  // }

  @GetMapping("generate-image")
  public List<String> generateImage(HttpServletResponse response, @RequestParam String prompt,
      @RequestParam(defaultValue = "hd") String quality,
      @RequestParam(defaultValue = "2") int n,
      @RequestParam(defaultValue = "256") int height,
      @RequestParam(defaultValue = "256") int width) throws IOException {
    ImageResponse imageResponse = imageService.generateImage(prompt, quality, n, width, height);
    // Use Streams for multiple image urls
    return imageResponse.getResults().stream().map(result -> result.getOutput().getUrl())
        .collect(Collectors.toList());
  }

  @GetMapping("recipe-creator")
  public String recipeCreator(@RequestParam String ingredients, @RequestParam(defaultValue = "any") String cuisine,
      @RequestParam(defaultValue = "") String dietaryRestrictions) {
    return recipeService.createRecipe(ingredients, cuisine, dietaryRestrictions);
  }
}
