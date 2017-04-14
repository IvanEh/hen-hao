package com.epam.training.services;

import com.epam.training.model.OrganisationModel;

public interface OrganisationMailService {
    void sendEmail(OrganisationModel organisationModel);

    String getMessage(OrganisationModel organisationModel);

    String getSubject();
}
