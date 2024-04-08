package org.example.springmongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;
public interface BlogsRep
extends MongoRepository<Blogs,String> {
    Optional<Blogs>findBlogsByTitle(String title);

}
