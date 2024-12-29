package com.ai.Generator.service.ChatService;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;
import com.ai.Generator.model.ChatVersions;

@Service // mark as service to inject in controller constructor
public class ChatService {

  private final ChatModel chatModel;

  public ChatService(ChatModel model) {
    this.chatModel = model;
  }

  public String getResponse(String prompt) {
    return chatModel.call(prompt);
  }

  public String getResponseOptions(String prompt, String model, Double temperature) {

    ChatResponse response = chatModel.call(new Prompt(prompt, OpenAiChatOptions.builder()
        .withModel(ChatVersions.findVersionByName(model))
        .withTemperature(temperature == null ? 0.8 : temperature)
        .build()));

    return response.getResult().getOutput().getContent();
  }
}
