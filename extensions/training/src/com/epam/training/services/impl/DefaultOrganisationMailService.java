package com.epam.training.services.impl;

import com.epam.training.model.OrganisationModel;
import com.epam.training.services.OrganisationMailService;
import com.epam.training.services.support.OrganisationMailContext;
import de.hybris.platform.commons.model.renderer.RendererTemplateModel;
import de.hybris.platform.commons.renderer.RendererService;
import de.hybris.platform.servicelayer.i18n.L10NService;
import de.hybris.platform.util.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.io.StringWriter;


@Service
public class DefaultOrganisationMailService implements OrganisationMailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultOrganisationMailService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private RendererService rendererService;

    @Autowired
    private L10NService l10NService;

    @Override
    public void sendEmail(OrganisationModel organisationModel) {
        MimeMessagePreparator mimeMessagePreparator = getOrganisationMessagePreparator(organisationModel);
        mailSender.send(mimeMessagePreparator);
    }

    private MimeMessagePreparator getOrganisationMessagePreparator(OrganisationModel organisationModel) {
        return mimeMessage -> {
            mimeMessage.setText(getMessage(organisationModel));
            mimeMessage.setContent(getMessage(organisationModel), "text/html");
            mimeMessage.setSubject(getSubject());
            mimeMessage.setRecipients(Message.RecipientType.TO, new Address[]{getAddress(organisationModel)});
        };
    }

    @Override
    public String getMessage(OrganisationModel organisationModel) {
        OrganisationMailContext ctx = new OrganisationMailContext(organisationModel.getName(),
                organisationModel.getCustomers());
        StringWriter message = new StringWriter();

        RendererTemplateModel template = rendererService.getRendererTemplateForCode("organisation-members");
        rendererService.render(template, ctx, message);

        return message.toString();
    }

    private Address getAddress(OrganisationModel organisationModel) {
        Address address;
        try {
            address = new InternetAddress(organisationModel.getEmail());
        } catch (AddressException ex) {
            address = null;
        }

        return address;
    }

    @Override
    public String getSubject() {
        return l10NService.getLocalizedString("organisation.mail.members.template");
    }

}
