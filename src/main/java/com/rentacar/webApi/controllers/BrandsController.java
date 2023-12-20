package com.rentacar.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.business.abstracts.BrandService;
import com.rentacar.entities.concretes.Brand;

@RestController   //RestController
@RequestMapping("api/brands")
public class BrandsController {
	private BrandService brandService;

	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
	
	
	@GetMapping("/getall")
	public List<Brand> getAll(){
		return brandService.getAll();
	}
}
