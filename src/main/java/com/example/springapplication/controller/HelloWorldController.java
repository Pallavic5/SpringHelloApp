package com.example.springapplication.controller;

import com.example.springapplication.model.User;
import com.example.springapplication.repository.ModelRepository;
import com.example.springapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class HelloWorldController {
@Autowired //Dependency injection(Create another class of object with the help of loose coupling with interface)
    UserService service;
@Autowired
ModelRepository repo;
    @RequestMapping(value = {"/hello-w"}, method = RequestMethod.GET)
    public String sayHelloDifferently() {
        return "Hello Everyone!!!";
    }

    @RequestMapping(value = {"/query"}, method = RequestMethod.GET) //previously using like this(RequestMapping)
    public String sayHello(@RequestParam(value = "name") String name) {
        return "Hello " + name  + "!!!";
    }

    @GetMapping("/param/{name}")        //getmapping means fetching the details from database
    public String sendParam(@PathVariable String name) {
        return "Hello " + "Mr/Mrs." + name  + "!!!";
    }

    @PostMapping("/post")
    public User insert(@RequestBody User user) {
       return service.insert(user);
    }

    @PutMapping("/put/{id}")    //to update
    public User updateData(@PathVariable int id, @RequestBody User user ){  //insert update (requestbody)
        return service.update(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){ //findout id (pathvariable)
        repo.deleteById(id);
        return "deleted";
    }
    @GetMapping("/getById/{id}")
    public User findId(@PathVariable int id){
        User userFindId = service.search(id);
        return userFindId;
    }

    @GetMapping("/getAllDetails")
    public List<User> getAllDetails(){
        List<User> userList = service.displayAll();
        return userList;
    }
}
