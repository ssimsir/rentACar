package com.rentacar.business.abstracts;

import java.util.List;

import com.rentacar.business.requests.CreateBrandRequest;
import com.rentacar.business.responses.GetAllBrandsResponses;

public interface BrandService {
	List<GetAllBrandsResponses> getAll();
	void add(CreateBrandRequest createBrandRequest);
}
