package com.ai.Generator.model;

/*
 * Some of the Available OpenAI models 
 * More info at https://platform.openai.com/docs/models/gp
 */
public enum ChatVersions {
  FLAGSHIP("gpt-4o"), // flagship chat-gpt model
  CHEAP("gpt-4o-mini"), // affordable chat-gpt model
  SPOKEN_AUDIO("tts"), // convert text to natuaral sounding spoken audio
  REALTIME("gpt-4o-realtime"), // capable of realtime text and audio inputs and outpust
  MULTI_STEP("o1-mini"); // multi-step processing

  private String model;

  ChatVersions(String model) {
    this.model = model;
  }

  public String getModel() {
    return model;
  }

  public static String findVersionByName(String enumName) {
    try {

      return ChatVersions.valueOf(enumName).model;

    } catch (IllegalArgumentException e) {
      return ChatVersions.FLAGSHIP.model;
    }
  }
}
