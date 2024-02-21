package com.adm.simpleblog.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adm.simpleblog.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
