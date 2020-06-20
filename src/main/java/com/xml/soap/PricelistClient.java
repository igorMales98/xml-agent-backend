package com.xml.soap;

import com.xml.RentCar.wsdl.PricelistRequest;
import com.xml.RentCar.wsdl.PricelistResponse;
import com.xml.dto.PricelistDto;
import com.xml.service.PricelistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class PricelistClient extends WebServiceGatewaySupport {

    @Autowired
    private PricelistService pricelistService;

    public PricelistResponse postPricelist(PricelistDto pricelist) {

        PricelistRequest request = new PricelistRequest();
        request.setPriceForCDW(pricelist.getPriceForCDW());
        request.setPricePerDay(pricelist.getPricePerDay());
        request.setPricePerKm(pricelist.getPricePerKm());

        PricelistResponse response = (PricelistResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8084/ws/codebook-service-schema", request,
                        new SoapActionCallback("http://localhost:8084/ws/codebook-service-schema/pricelistRequest"));

        return response;
    }
}
