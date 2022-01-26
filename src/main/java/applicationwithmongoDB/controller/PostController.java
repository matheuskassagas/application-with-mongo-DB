package applicationwithmongoDB.controller;

import applicationwithmongoDB.DTO.UserDTO;
import applicationwithmongoDB.controller.util.URL;
import applicationwithmongoDB.repositoryMongoBD.entity.Post;
import applicationwithmongoDB.repositoryMongoBD.entity.User;
import applicationwithmongoDB.service.PostService;
import applicationwithmongoDB.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<?> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text); //decodifica o texto no formato necessario para url
        List<Post> list = postService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<?> fullsearch(@RequestParam(value = "text", defaultValue = "") String text, @RequestParam(value = "minDate", defaultValue = "") String minDate, @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        Date min = URL.converteDate(minDate, new Date(0L));
        Date max = URL.converteDate(maxDate, new Date());
        List<Post> list = postService.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }
}
