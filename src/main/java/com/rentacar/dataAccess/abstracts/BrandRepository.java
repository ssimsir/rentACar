package com.rentacar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rentacar.entities.concretes.Brand;


public interface BrandRepository extends JpaRepository<Brand, Integer> {
	boolean existsByName(String name); //spring jpa keyword araştır
}
