package applicationwithmongoDB.controller;

import applicationwithmongoDB.DTO.UserDTO;
import applicationwithmongoDB.repositoryMongoBD.entity.Post;
import applicationwithmongoDB.repositoryMongoBD.entity.User;
import applicationwithmongoDB.service.PostService;
import applicationwithmongoDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

}
