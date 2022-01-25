package applicationwithmongoDB.controller;

import applicationwithmongoDB.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        User u1 = new User("Maria", "maria@gmail.com");
        User u2 = new User("Alex", "alex@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(u1, u2));
        return ResponseEntity.ok().body(list);
    }
}
