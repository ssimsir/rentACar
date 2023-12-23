package com.rentacar.business.abstracts;

import java.util.List;

import com.rentacar.business.responses.GetAllModelsResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
}
