package org.example.springmongo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(BlogsRep rep,
							 MongoTemplate mongoTemplate){
		return args -> {

			Blogs blogs = new Blogs(
					"Python",
					List.of("Python","Flask","Numpy"),
					"My GitHub Is Amin-A-97",
					"Admin",
					LocalDateTime.now()
			);
			System.out.println(blogs.getTitle());
			rep.findBlogsByTitle(blogs.getTitle()).ifPresentOrElse(
					b -> {
						System.out.println("Warning This Title Is " + blogs.getTitle() + " Exist!");
					},
					() -> {
							rep.insert(blogs);
						System.out.println("SuccessFully!");

					}
			);
//

		};
	}

}
