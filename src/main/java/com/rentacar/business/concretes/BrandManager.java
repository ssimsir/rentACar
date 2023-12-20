package com.rentacar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.business.abstracts.BrandService;
import com.rentacar.dataAccess.abstracts.BrandRepository;
import com.rentacar.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService {
	
	private BrandRepository brandRepository;
	
	@Autowired
	public BrandManager(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}


	@Override
	public List<Brand> getAll() {
		// Buraya iş kuralları yazılacak
		return brandRepository.getAll();
	}
	
}
