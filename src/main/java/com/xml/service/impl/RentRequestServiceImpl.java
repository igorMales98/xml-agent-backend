package com.xml.service.impl;

import com.xml.dto.AdvertisementDto;
import com.xml.dto.RentRequestDto;
import com.xml.enummeration.RentRequestStatus;
import com.xml.mapper.AdvertisementDtoMapper;
import com.xml.model.Advertisement;
import com.xml.model.Customer;
import com.xml.model.Pricelist;
import com.xml.model.RentRequest;
import com.xml.repository.RentRequestRepository;
import com.xml.service.RentRequestService;
import com.xml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RentRequestServiceImpl implements RentRequestService {

    @Autowired
    private RentRequestRepository rentRequestRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AdvertisementDtoMapper advertisementDtoMapper;

    @Override
    public List<RentRequest> getAll() {
        return this.rentRequestRepository.findAll();
    }

    @Override
    public void createRentRequest(RentRequestDto rentRequestDto) throws ParseException {
        System.out.println(rentRequestDto.toString());

        Customer customer = new Customer();
        customer.setFirstName(rentRequestDto.getCustomer().getFirstName());
        customer.setLastName(rentRequestDto.getCustomer().getLastName());
        customer.setEmail(rentRequestDto.getCustomer().getEmail());
        customer.setCountry(rentRequestDto.getCustomer().getCountry());
        customer.setCity(rentRequestDto.getCustomer().getCity());
        customer.setAddress(rentRequestDto.getCustomer().getAddress());
        customer.setPhone(rentRequestDto.getCustomer().getPhone());

        customer.setUsername("notInUseasdf");
        customer.setPassword("notInUseasdf");
        this.userService.saveUser(customer);

        Set<Advertisement> advertisementSet = new HashSet<>();
        AdvertisementDtoMapper advertisementDtoMapper1 = advertisementDtoMapper;
        for (AdvertisementDto advertisementDto : rentRequestDto.getAdvertisementsForRent()) {
            Advertisement advertisement = advertisementDtoMapper1.toEntity(advertisementDto);
            advertisementSet.add(advertisement);
        }

        RentRequest newRentRequest = new RentRequest();
        newRentRequest.setReservedFrom(rentRequestDto.getReservedFrom());
        newRentRequest.setReservedTo(rentRequestDto.getReservedTo());
        newRentRequest.setCustomer(customer);
        newRentRequest.setRentRequestStatus(RentRequestStatus.RESERVED);
        newRentRequest.setAdvertisementsForRent(advertisementSet);

        this.rentRequestRepository.save(newRentRequest);
    }

    @Override
    public RentRequest getOne(Long id) {
        return this.rentRequestRepository.getOne(id);
    }

    @Override
    public List<RentRequest> getFinishedRents() {
        return this.rentRequestRepository.getFinishedRents();
    }
}
