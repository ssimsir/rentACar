package com.rentacar.business.abstracts;

import java.util.List;

import com.rentacar.business.requests.CreateBrandRequest;
import com.rentacar.business.requests.UpdateBrandRequest;
import com.rentacar.business.responses.GetAllBrandsResponses;
import com.rentacar.business.responses.GetByIdBrandResponse;

public interface BrandService {
	List<GetAllBrandsResponses> getAll();
	GetByIdBrandResponse getById(int id);
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
}
