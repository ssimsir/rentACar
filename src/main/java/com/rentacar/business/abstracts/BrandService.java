package com.rentacar.business.abstracts;

import java.util.List;

import com.rentacar.entities.concretes.Brand;

public interface BrandService {
	List<Brand> getAll();
}
