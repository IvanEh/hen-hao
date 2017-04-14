package com.epam.training.daos;

import com.epam.training.model.OrganisationModel;

import java.util.List;

public interface OrganisationDao {
    List<OrganisationModel> findAll();
}
