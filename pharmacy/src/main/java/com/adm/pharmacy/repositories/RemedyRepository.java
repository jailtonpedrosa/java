package com.adm.pharmacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adm.pharmacy.models.RemedyModel;

@Repository
public interface RemedyRepository extends JpaRepository<RemedyModel, Long> {
}
