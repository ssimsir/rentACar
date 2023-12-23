package com.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.entities.concretes.Model;


public interface ModelRepository extends JpaRepository<Model, Integer>{

}

