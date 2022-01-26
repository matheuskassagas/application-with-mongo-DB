package applicationwithmongoDB.service;

import applicationwithmongoDB.DTO.UserDTO;
import applicationwithmongoDB.repositoryMongoBD.PostRepository;
import applicationwithmongoDB.repositoryMongoBD.UserRepository;
import applicationwithmongoDB.repositoryMongoBD.entity.Post;
import applicationwithmongoDB.repositoryMongoBD.entity.User;
import applicationwithmongoDB.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
