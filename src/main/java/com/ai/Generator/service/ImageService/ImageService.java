package com.ai.Generator.service.ImageService;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

  private final OpenAiImageModel openAiImageModel;

  public ImageService(OpenAiImageModel imageModel) {
    this.openAiImageModel = imageModel;
  }

  /*
   * Generates AI Image. Properties set to Dall-e-2 model
   * to allow for vary image sizes below 1024x1024 that are
   * unavailable in the Dall-e-3 default model.
   * 
   * @param String prompt - description of image
   * return ImageResponse object
   */
  public ImageResponse generateImage(String prompt) {
    // ImageResponse response = openAiImageModel.call(new ImagePrompt(prompt));
    ImageResponse imageResponse = openAiImageModel
        .call(new ImagePrompt(prompt,
            OpenAiImageOptions.builder().withN(3).withQuality("hd").build()));

    return imageResponse;
  }

  /*
   * Generates AI Image. Properties set to Dall-e-2 model
   * to allow for vary image sizes below 1024x1024 that are
   * unavailable in the Dall-e-3 default model.
   * 
   * @param String prompt - description of image
   * 
   * @param String quality
   * 
   * @param int n number of images
   * 
   * @param int width
   * 
   * @param int height
   * return ImageResponse object
   */
  public ImageResponse generateImage(String prompt, String quality, int n, int width, int height) {
    ImageResponse imageResponse = openAiImageModel
        .call(new ImagePrompt(prompt,
            OpenAiImageOptions.builder().withN(n).withHeight(height).withWidth(width)
                .withQuality(quality).build()));

    return imageResponse;
  }
}
