package com.epam.training.services.support;

import de.hybris.platform.core.model.user.CustomerModel;

import java.util.Collection;
import java.util.List;

public class OrganisationMailContext {
    private String organisation;
    private Collection<CustomerModel> customers;

    public OrganisationMailContext(String organisation, Collection<CustomerModel> customers) {
        this.organisation = organisation;
        this.customers = customers;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public Collection<CustomerModel> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerModel> customers) {
        this.customers = customers;
    }
}
