package com.example.springapplication.service;

import com.example.springapplication.model.User;
import com.example.springapplication.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    ModelRepository repo;
    public User insert(User user) {
        User usernew = new User(user);
        return repo.save(usernew); //parameterobject
    }

    public User update(int id, User user) {
//new user
        User user1 = repo.findById(id).get();
        if (repo.findById(id).isPresent()){
            user1.setId(user.getId());
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            return repo.save(user1);
        }
        return  null;

    }

    public User search(int id) {
        User user1 = repo.findById(id).get();
        if (repo.findById(id).isPresent()){
            return user1;
        }
        return  null;
    }

    public List<User> displayAll() {
        List<User> listUser = repo.findAll();
        return listUser;
    }
}
