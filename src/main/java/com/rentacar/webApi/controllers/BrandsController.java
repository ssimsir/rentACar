package com.rentacar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.business.abstracts.BrandService;
import com.rentacar.business.requests.CreateBrandRequest;
import com.rentacar.business.responses.GetAllBrandsResponses;

@RestController   //RestController
@RequestMapping("api/brands")
public class BrandsController {
	private BrandService brandService;

	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
	
	
	@GetMapping()
	public List<GetAllBrandsResponses> getAll(){
		return brandService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody  CreateBrandRequest createBrandRequest) {
		brandService.add(createBrandRequest);
	}
}
