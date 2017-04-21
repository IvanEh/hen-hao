package com.epam.training.facades.populators;

import com.epam.training.facades.data.AdditionalInfoData;
import com.epam.training.model.AdditionalInfoModel;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.ArrayList;
import java.util.List;

public class AdditionalInfoPopulator implements Populator<ProductModel, ProductData> {
    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        List<AdditionalInfoData> additionalInfoDataList = new ArrayList<>();

        for (AdditionalInfoModel additionalInfo: productModel.getAdditionalInfoList()) {
            AdditionalInfoData additionalInfoData = new AdditionalInfoData();
            additionalInfoData.setContent(additionalInfo.getContent());
            additionalInfoDataList.add(additionalInfoData);
        }
        productData.setAdditionalInfoList(additionalInfoDataList);
    }
}
