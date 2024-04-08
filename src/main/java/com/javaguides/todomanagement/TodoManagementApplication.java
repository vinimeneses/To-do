package com.javaguides.todomanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Tag(
		name = "To-Do Management RESTful APIs",
		description = "This page lists all RESTful APIs for To-Do Management."

)
@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "To-Do Management RESTful APIs",
				description = "This page lists all RESTful APIs for To-Do Management.",
				version = "v1.0",
				contact = @Contact(
						name = "Vinícius Meneses",
						email = "viniciusmenesesdev@gmail.com",
						url = "https://github.com/vinimeneses"
				),
				license = @io.swagger.v3.oas.annotations.info.License(
						name = "Apache 2.0",
						url = "http://www.apache.org/licenses/LICENSE-2.0.html"
				)
		)
)
public class TodoManagementApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoManagementApplication.class, args);
	}

}
