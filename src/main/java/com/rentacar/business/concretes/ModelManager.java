package com.rentacar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rentacar.business.abstracts.ModelService;
import com.rentacar.business.responses.GetAllBrandsResponse;
import com.rentacar.business.responses.GetAllModelsResponse;
import com.rentacar.core.utilities.mappers.ModelMapperService;
import com.rentacar.dataAccess.abstracts.ModelRepository;
import com.rentacar.entities.concretes.Brand;
import com.rentacar.entities.concretes.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
	
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		
		List<GetAllModelsResponse> getAllModelsResponse = models.stream().map(model->this.modelMapperService.forResponse()
				.map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
		
		return getAllModelsResponse;
	}
	


}
