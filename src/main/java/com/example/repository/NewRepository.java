package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.NewEntity;
import org.springframework.stereotype.Repository;


@Repository
public interface NewRepository extends JpaRepository<NewEntity, Long> {

}