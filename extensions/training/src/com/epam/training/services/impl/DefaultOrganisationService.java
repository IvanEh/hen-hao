package com.epam.training.services.impl;

import com.epam.training.daos.OrganisationDao;
import com.epam.training.model.OrganisationModel;
import com.epam.training.services.OrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultOrganisationService implements OrganisationService {

    @Autowired
    private OrganisationDao organisationDao;

    @Override
    public List<OrganisationModel> findAll() {
        return organisationDao.findAll();
    }
}
