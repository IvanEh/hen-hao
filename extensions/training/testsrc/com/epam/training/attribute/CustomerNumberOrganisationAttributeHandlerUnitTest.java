package com.epam.training.attribute;

import com.epam.training.jalo.Organisation;
import com.epam.training.model.OrganisationModel;
import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.user.CustomerModel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@UnitTest
public class CustomerNumberOrganisationAttributeHandlerUnitTest {

    @Mock
    OrganisationModel organisationModel;

    CustomerNumberOrganisationAttributeHandler handler;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        handler = new CustomerNumberOrganisationAttributeHandler();
    }

    @Test
    public void handlerGetWhenNoCustomers() throws Exception {
        Mockito.when(organisationModel.getCustomers()).thenReturn(Collections.emptyList());

        Assert.assertEquals(Integer.valueOf(0), handler.get(organisationModel));
    }

    @Test
    public void handlerGetWhenTwoCustomers() throws Exception {
        CustomerModel mockCustomer1 = Mockito.mock(CustomerModel.class);
        CustomerModel mockCustomer2 = Mockito.mock(CustomerModel.class);

        Mockito.when(organisationModel.getCustomers())
                .thenReturn(Arrays.asList(mockCustomer1, mockCustomer2));

        Assert.assertEquals(Integer.valueOf(2), handler.get(organisationModel));
    }
}
