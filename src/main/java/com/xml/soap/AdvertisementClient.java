package com.xml.soap;

import com.xml.RentCar.wsdl.*;
import com.xml.dto.CreateAdvertisementDto;
import com.xml.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.io.IOException;

public class AdvertisementClient extends WebServiceGatewaySupport {

    @Autowired
    AdvertisementService advertisementService;

    public AdvertisementResponse postAdvertisement(CreateAdvertisementDto advertisement) throws IOException {

        AdvertisementRequest request = new AdvertisementRequest();
        request.setAdvertiserId(1L);
        request.setAvailableFrom(advertisement.getAvailableFrom().toString());
        request.setAvailableTo(advertisement.getAvailableTo().toString());
        request.setPricelistId(advertisement.getPricelist().getId());
        request.setDiscount(advertisement.getDiscount());

        Car car = new Car();
        car.setAllowedDistance(advertisement.getAllowedDistance());
        car.setCarBrandId(advertisement.getCarBrand().getId());
        car.setCarClassId(advertisement.getCarClass().getId());
        car.setCarModelId(advertisement.getCarModel().getId());
        car.setFuelTypeId(advertisement.getFuelType().getId());
        car.setTransmissionTypeId(advertisement.getTransmissionType().getId());
        car.setCollisionDamageWaiverExists(advertisement.isHasACDW());
        car.setHasAndroid(advertisement.isHasAndroid());
        car.setMileage(advertisement.getMileage());

        request.setCar(car);

        AdvertisementResponse response = (AdvertisementResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8085/ws/advertisement-service-schema", request,
                        new SoapActionCallback("http://localhost:8085/ws/advertisement-service-schema/advertisementRequest"));

        return response;
    }

    public GetAdvertisementsResponse getAgentAdvertisements() throws IOException {

        GetAdvertisementsRequest request = new GetAdvertisementsRequest();
        request.setAgentId(2L);

        GetAdvertisementsResponse response = (GetAdvertisementsResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8085/ws/advertisement-service-schema", request,
                        new SoapActionCallback("http://localhost:8085/ws/advertisement-service-schema/getAdvertisementsRequest"));

        return response;
    }

}
