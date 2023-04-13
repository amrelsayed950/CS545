package edu.miu.waa.lab5.service.impl;

import edu.miu.waa.lab5.domain.User;
import edu.miu.waa.lab5.repository.UserRepo;
import edu.miu.waa.lab5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;


    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }


}
