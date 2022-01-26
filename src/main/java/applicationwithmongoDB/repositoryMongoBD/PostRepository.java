package applicationwithmongoDB.repositoryMongoBD;

import applicationwithmongoDB.repositoryMongoBD.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text); //consultas do query methods spring data mongodb
}
