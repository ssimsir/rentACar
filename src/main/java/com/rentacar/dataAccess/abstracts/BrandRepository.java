package com.rentacar.dataAccess.abstracts;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rentacar.entities.concretes.Brand;


public interface BrandRepository {
	List<Brand> getAll();
}
