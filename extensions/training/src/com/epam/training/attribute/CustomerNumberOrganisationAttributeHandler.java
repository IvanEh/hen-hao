package com.epam.training.attribute;

import com.epam.training.jalo.Organisation;
import com.epam.training.model.OrganisationModel;
import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;

public class CustomerNumberOrganisationAttributeHandler
        extends AbstractDynamicAttributeHandler<Integer, OrganisationModel> {

    @Override
    public Integer get(OrganisationModel model) {
        return model.getCustomers().size();
    }

}
