package com.epam.training.storefront.security.impl;

import com.epam.training.storefront.security.BruteForceAttackCounter;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class DatabaseBruteForceAttackCounter implements BruteForceAttackCounter{
    private Integer maxFailedLogins = 3;

    private ModelService modelService;

    private UserService userService;

    @Autowired
    public DatabaseBruteForceAttackCounter(ModelService modelService, UserService userService) {
        this.modelService = modelService;
        this.userService = userService;
    }

    @Override
    public void registerLoginFailure(String userUid) {
        CustomerModel customerModel = getCustomerModel(userUid);

        if(customerModel != null) {
            int attempts = ofNullable(customerModel.getAttemptCount()).orElse(0);
            customerModel.setAttemptCount(attempts + 1);
            modelService.save(customerModel);
        }
    }


    @Override
    public boolean isAttack(String userUid) {
        return getUserFailedLogins(userUid) >= maxFailedLogins;
    }

    @Override
    public void resetUserCounter(String userUid) {
        CustomerModel customerModel = getCustomerModel(userUid);
        if (!customerModel.getStatus()) {
            customerModel.setAttemptCount(0);
        }
        modelService.save(customerModel);
    }

    @Override
    public int getUserFailedLogins(String userUid) {
        CustomerModel customerModel = getCustomerModel(userUid);
        int attempts = ofNullable(customerModel).map(CustomerModel::getAttemptCount)
                .orElse(0);
        return attempts;
    }

    private CustomerModel getCustomerModel(String userUid) {
        CustomerModel customerModel;
        try {
            customerModel = userService.getUserForUID(StringUtils.lowerCase(userUid), CustomerModel.class);
        } catch (UnknownIdentifierException e) {
            customerModel = null;
        }
        return customerModel;
    }

    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(final ModelService modelService) {
         this.modelService = modelService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    public Integer getMaxFailedLogins() {
        return maxFailedLogins;
    }

    public void setMaxFailedLogins(Integer maxFailedLogins) {
        this.maxFailedLogins = maxFailedLogins;
    }
}
