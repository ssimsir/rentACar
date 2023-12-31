package com.rentacar.business.abstracts;

import java.util.List;

import com.rentacar.business.requests.CreateModelRequest;
import com.rentacar.business.requests.UpdateModelRequest;
import com.rentacar.business.responses.GetAllModelsResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	
	void add(CreateModelRequest createModelRequest);
	void delete(int id);
	void update(UpdateModelRequest updateModelRequest);
}
