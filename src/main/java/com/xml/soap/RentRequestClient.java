package com.xml.soap;

import com.xml.RentCar.wsdl.*;
import com.xml.dto.AdvertisementDto;
import com.xml.dto.RentRequestDto;
import com.xml.enummeration.RentRequestStatus;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RentRequestClient extends WebServiceGatewaySupport {

    public RentRequestResponse postRentRequest(RentRequestDto rentRequestDto) {
        RentRequestRequest request = new RentRequestRequest();
        request.setReservedFrom(rentRequestDto.getReservedFrom().toString());
        request.setReservedTo(rentRequestDto.getReservedTo().toString());
        request.setStatus(RentRequestStatus.PAID.toString());
        List<Long> advertisementsForRentIds = new ArrayList<>();
        Set<AdvertisementDto> advertisementsForRent = rentRequestDto.getAdvertisementsForRent();
        for(AdvertisementDto advertisementDto: advertisementsForRent){
            advertisementsForRentIds.add(advertisementDto.getId());
        }
        request.setAdvertisementsForRent(advertisementsForRentIds);

        User user = new User();
        user.setType(rentRequestDto.getCustomer().getType());
        user.setFirstName(rentRequestDto.getCustomer().getFirstName());
        user.setLastName(rentRequestDto.getCustomer().getLastName());
        user.setCountry(rentRequestDto.getCustomer().getCountry());
        user.setCity(rentRequestDto.getCustomer().getCity());
        user.setEmail(rentRequestDto.getCustomer().getEmail());
        user.setPhone(rentRequestDto.getCustomer().getPhone());
        user.setAddress(rentRequestDto.getCustomer().getAddress());

        request.setUser(user);

        RentRequestResponse response = (RentRequestResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8089/ws/rent-request-service-schema", request,
                        new SoapActionCallback("http://localhost:8089/ws/rent-request-service-schema/rentRequestRequest"));

        return response;
    }
}
