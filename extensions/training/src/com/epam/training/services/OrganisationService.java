package com.epam.training.services;

import com.epam.training.model.OrganisationModel;

import java.util.List;

public interface OrganisationService {
    List<OrganisationModel> findAll();
}
