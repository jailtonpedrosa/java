package com.adm.usermicroservice.services;

import com.adm.usermicroservice.models.UserModel;
import com.adm.usermicroservice.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public UserModel save(UserModel userModel) {
        return this.userRepository.save(userModel);
    }
}
