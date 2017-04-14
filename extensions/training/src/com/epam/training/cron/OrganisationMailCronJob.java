package com.epam.training.cron;

import com.epam.training.model.OrganisationModel;
import com.epam.training.services.OrganisationMailService;
import com.epam.training.services.OrganisationService;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.JobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrganisationMailCronJob implements JobPerformable<CronJobModel> {

    @Autowired
    private OrganisationService organisationService;

    @Autowired
    private OrganisationMailService organisationMailService;

    @Override
    public PerformResult perform(CronJobModel cronJobModel) {
        List<OrganisationModel> organisations = organisationService.findAll();
        for (OrganisationModel organisation: organisations) {
            organisationMailService.sendEmail(organisation);
        }

        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }

    @Override
    public boolean isPerformable() {
        return true;
    }

    @Override
    public boolean isAbortable() {
        return false;
    }
}
