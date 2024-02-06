package com.adm.sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adm.sales.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
