# Maven Springdoc client code generation example

![Code Soapbox logo](readme-images/logo.png)

This project is a sample REST service documented using Springdoc OpenAPI, with automatic Angular client code generation
done using openapi-generator-maven-plugin and springdoc-openapi-maven-plugin.

To learn how to generate client code from Spring Boot using Springdoc OpenAPI and Maven, read the post:

[Code Soapbox - Generate client code from Spring Boot using Springdoc OpenAPI and Maven](https://codesoapbox.dev/generate-client-code-from-spring-boot-using-springdoc-openapi-and-maven/)

## Getting Started

1. Clone the repository

```bash
$ git clone https://github.com/daniel-frak/client-code-generation-maven-springdoc
```

2. Build the application

```bash
$ mvn clean install
```

...or generate Angular code

```bash
$ mvn clean verify -P angular
```

## Built With

* Java 11
* [Spring Boot 2.7.0](https://start.spring.io/)
* [Maven](https://maven.apache.org/)
* [Springdoc OpenAPI](https://github.com/springdoc/springdoc-openapi/)
* [springdoc-openapi-maven-plugin](https://github.com/springdoc/springdoc-openapi-maven-plugin)
* [openapi-generator-maven-plugin](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-maven-plugin/)

## Screenshots

![Swagger UI documentation](readme-images/screenshot.png)