package com.rentacar.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentacar.business.abstracts.BrandService;
import com.rentacar.business.requests.CreateBrandRequest;
import com.rentacar.business.responses.GetAllBrandsResponses;
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
	public List<GetAllBrandsResponses> getAll() {
		
		List<Brand> brands = brandRepository.findAll();
		
		List<GetAllBrandsResponses> getAllBrandsResponses = new ArrayList<GetAllBrandsResponses>();
		
		for (Brand brand : brands) {
			GetAllBrandsResponses responseItem = new GetAllBrandsResponses();
			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			getAllBrandsResponses.add(responseItem);
		}
		
		
		return getAllBrandsResponses;
	}


	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		Brand brand=new Brand();
		
		brand.setName(createBrandRequest.getName());
		
		this.brandRepository.save(brand);
		
	}
	
}
