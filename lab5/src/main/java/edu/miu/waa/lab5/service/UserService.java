package edu.miu.waa.lab5.service;

import edu.miu.waa.lab5.domain.User;

public interface UserService {

    User findByEmail(String email);

}
