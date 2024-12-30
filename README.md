# Spring-Boot AI Integration

A number of services utilizing OpenAI api.


# How to Run Locally

Make sure to go to OpenAI and retrieve an API key if you do not have one already. Once an OpenAI API key has been obtained, 
create and application.properties variable as the following and insert key after equal sign. No quotation marks or anything, just raw key value.

  - `spring.ai.openai.api-key=your_key_here`

  The line above causes GitHub to reject pushes to the repository to a false positive secret. Follow git link to allow. OpenAI will deactivate the api key. Create a new api key on OpenAI's website.

  **But please add an API key, otherwise project will not build or run!**

## Maven 
Ensure you have maven 3.5+ and Java 17 installed on your machine. Then run the following commands: 
  - `mvn install`
  - `mvn spring-boot:run`

  To run a different environment profile for the sake of allowed origins, run following commands:
  - `mvn clean install` Do not forget OpenAI API Key
  - `cd target`
  - `java -jar Generator-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod`


  # Explore Generator

  Once you have an OpenAI api key and the local code running. Be sure to download Postman and test out the endpoints in the Postman collection in the root of this project's directory.