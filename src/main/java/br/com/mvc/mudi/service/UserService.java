package br.com.mvc.mudi.service;

import br.com.mvc.mudi.model.User;
import br.com.mvc.mudi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User findByUsername(String username){
        return userRepo.findByUsername(username);
    }
}
