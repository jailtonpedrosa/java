package com.adm.emailmicroservice.repositories;

import com.adm.emailmicroservice.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
}
