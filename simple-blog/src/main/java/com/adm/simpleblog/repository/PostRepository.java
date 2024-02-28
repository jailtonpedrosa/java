package com.adm.simpleblog.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adm.simpleblog.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {

}
