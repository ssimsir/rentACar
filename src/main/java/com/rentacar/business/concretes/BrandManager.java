package com.rentacar.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rentacar.business.abstracts.BrandService;
import com.rentacar.business.requests.CreateBrandRequest;
import com.rentacar.business.requests.UpdateBrandRequest;
import com.rentacar.business.responses.GetAllBrandsResponses;
import com.rentacar.business.responses.GetByIdBrandResponse;
import com.rentacar.core.utilities.mappers.ModelMapperService;
import com.rentacar.dataAccess.abstracts.BrandRepository;
import com.rentacar.entities.concretes.Brand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	



	@Override
	public List<GetAllBrandsResponses> getAll() {
		
		List<Brand> brands = brandRepository.findAll();
		
		/*
		 * List<GetAllBrandsResponses> getAllBrandsResponses = new
		 * ArrayList<GetAllBrandsResponses>();
		 * 
		 * for (Brand brand : brands) { GetAllBrandsResponses responseItem = new
		 * GetAllBrandsResponses(); responseItem.setId(brand.getId());
		 * responseItem.setName(brand.getName());
		 * getAllBrandsResponses.add(responseItem); }
		 */
		
		List<GetAllBrandsResponses> getAllBrandsResponses = brands.stream().map(brand->this.modelMapperService.forResponse()
				.map(brand, GetAllBrandsResponses.class)).collect(Collectors.toList());
		
		return getAllBrandsResponses;
	}


	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		//Brand brand=new Brand();
		//brand.setName(createBrandRequest.getName()); Herbir alan için tek tek yapmak yerine model mapper tek seferde yapıyor
		
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandRepository.save(brand);
		
	}


	@Override
	public GetByIdBrandResponse getById(int id) {
		
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse getByIdBrandResponse = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class); 
		
		return getByIdBrandResponse;
	}


	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);//updateBrandRequest içerisinde id olduğu için save işlemi update yapar
		
	}


	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
		
	}
	
}
