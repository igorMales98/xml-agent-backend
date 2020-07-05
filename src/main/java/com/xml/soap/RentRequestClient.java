package com.xml.soap;

import com.xml.RentCar.wsdl.*;
import com.xml.dto.RentRequestDto;
import com.xml.enummeration.RentRequestStatus;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class RentRequestClient extends WebServiceGatewaySupport {

    public RentRequestResponse postRentRequest(RentRequestDto rentRequestDto) {
        // ISPRAVITI ZA USERNAME, PASSWORD I ADVERTISEMENTS FOR RENT
        RentRequestRequest request = new RentRequestRequest();
        request.setReservedFrom(rentRequestDto.getReservedFrom().toString());
        request.setReservedTo(rentRequestDto.getReservedTo().toString());
        request.setStatus(RentRequestStatus.PAID.toString());
        //request.setAdvertisementsForRent(rentRequestDto.getAdvertisementsForRent().toString());

        User user = new User();
        user.setType(rentRequestDto.getCustomer().getType());
        //user.setUsername(rentRequestDto.getCustomer().getUsername());
        //user.setPassword(rentRequestDto.getCustomer().getPassword());
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