package com.xml.service.impl;

import com.xml.dto.AdvertisementDto;
import com.xml.dto.RentRequestDto;
import com.xml.enummeration.RentRequestStatus;
import com.xml.mapper.AdvertisementDtoMapper;
import com.xml.model.Advertisement;
import com.xml.model.Customer;
import com.xml.model.RentRequest;
import com.xml.repository.RentRequestRepository;
import com.xml.service.RentRequestService;
import com.xml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RentRequestServiceImpl implements RentRequestService {

    @Autowired
    private RentRequestRepository rentRequestRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AdvertisementDtoMapper advertisementDtoMapper;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

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

        if (customer.getFirstName().matches("[a-zA-Z]+") && customer.getLastName().matches("[a-zA-Z]+") &&
                customer.getAddress().matches("[a-zA-Z0-9]+") && customer.getCity().matches("[a-zA-Z]+") &&
                customer.getCountry().matches("[a-zA-Z]+") && customer.getPhone().matches("[0-9]+") &&
                customer.getEmail().matches("[a-zA-Z0-9.']+@(gmail.com)|(yahoo.com)|(uns.ac.rs)")) {

            SecureRandom sri = new SecureRandom();
            String sni = Long.toString(Math.abs(sri.nextLong()));
            customer.setUsername("PhysicalUser" + sni);
            customer.setPassword(passwordEncoder.encode(sni));
            this.userService.saveUser(customer);

            Set<Advertisement> advertisementSet = new HashSet<>();
            for (AdvertisementDto advertisementDto : rentRequestDto.getAdvertisementsForRent()) {
                Advertisement advertisement = advertisementDtoMapper.toEntity(advertisementDto);
                advertisementSet.add(advertisement);
            }

            RentRequest newRentRequest = new RentRequest();
            newRentRequest.setReservedFrom(rentRequestDto.getReservedFrom());
            newRentRequest.setReservedTo(rentRequestDto.getReservedTo());
            newRentRequest.setCustomer(customer);
            newRentRequest.setRentRequestStatus(RentRequestStatus.RESERVED);
            newRentRequest.setAdvertisementsForRent(advertisementSet);

            List<RentRequest> rentRequests = this.rentRequestRepository.findAll();
            for (RentRequest request : rentRequests) {
                if (request.getRentRequestStatus().equals(RentRequestStatus.PENDING)) {
                    for (Advertisement advertisement : request.getAdvertisementsForRent()) {
                        for (Advertisement a : advertisementSet) {
                            if (a.getId().equals(advertisement.getId())) {
                                request.setRentRequestStatus(RentRequestStatus.CANCELED);
                                this.rentRequestRepository.save(request);
                            }
                        }
                    }
                }
            }
            this.rentRequestRepository.save(newRentRequest);
        } else {
            System.out.println("Customer data is invalid.");
        }
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
