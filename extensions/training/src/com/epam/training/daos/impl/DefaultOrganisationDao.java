package com.epam.training.daos.impl;

import com.epam.training.daos.OrganisationDao;
import com.epam.training.model.OrganisationModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DefaultOrganisationDao implements OrganisationDao {
   @Autowired
    private FlexibleSearchService flexibleSearchService;

   @Override
   public List<OrganisationModel> findAll() {
       String query = String.format("SELECT {PK} FROM {%s}", OrganisationModel._TYPECODE);
       return flexibleSearchService.<OrganisationModel> search(query).getResult();
   }
}
