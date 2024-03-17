package com.adm.usermicroservice.services;

import com.adm.usermicroservice.models.UserModel;
import com.adm.usermicroservice.producers.UserProducer;
import com.adm.usermicroservice.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserProducer userProducer;

    @Transactional
    public UserModel save(UserModel userModel) {
        userModel = this.userRepository.save(userModel);
        this.userProducer.publishMessageEmail(userModel);
        return userModel;
    }
}
