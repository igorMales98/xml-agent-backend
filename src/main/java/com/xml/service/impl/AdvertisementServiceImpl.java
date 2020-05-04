package com.xml.service.impl;

import com.xml.dto.CreateAdvertisementDto;
import com.xml.mapper.*;
import com.xml.model.Advertisement;
import com.xml.model.Car;
import com.xml.model.User;
import com.xml.repository.AdvertisementRepository;
import com.xml.service.AdvertisementService;
import com.xml.service.CarService;
import com.xml.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    @Autowired
    private CarBrandDtoMapper carBrandDtoMapper;

    @Autowired
    private CarModelDtoMapper carModelDtoMapper;

    @Autowired
    private CarClassDtoMapper carClassDtoMapper;

    @Autowired
    private FuelTypeDtoMapper fuelTypeDtoMapper;

    @Autowired
    private TransmissionTypeDtoMapper transmissionTypeDtoMapper;

    @Autowired
    private PricelistDtoMapper pricelistDtoMapper;

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @Override
    public Long saveAdvertisement(CreateAdvertisementDto createAdvertisementDto) throws ParseException {
        Car newCar = new Car();
        try {
            newCar.setCarBrand(carBrandDtoMapper.toEntity(createAdvertisementDto.getCarBrand()));
            newCar.setCarModel(carModelDtoMapper.toEntity(createAdvertisementDto.getCarModel()));
            newCar.setCarClass(carClassDtoMapper.toEntity(createAdvertisementDto.getCarClass()));
            newCar.setFuelType(fuelTypeDtoMapper.toEntity(createAdvertisementDto.getFuelType()));
            newCar.setTransmissionType(transmissionTypeDtoMapper.toEntity(createAdvertisementDto.getTransmissionType()));
            newCar.setMileage(createAdvertisementDto.getMileage());
            newCar.setCollisionDamageWaiverExists(createAdvertisementDto.isHasACDW());
            newCar.setChildSeats(createAdvertisementDto.getChildSeats());
            newCar.setAllowedDistance(createAdvertisementDto.getAllowedDistance());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.carService.save(newCar);

        User advertiser = this.userService.getUser(1L);

        Advertisement advertisement = new Advertisement();
        advertisement.setCar(newCar);
        advertisement.setAdvertiser(advertiser);
        createAdvertisementDto.setAvailableFrom(createAdvertisementDto.getAvailableFrom().
                plus(1, ChronoUnit.DAYS));
        createAdvertisementDto.setAvailableTo(createAdvertisementDto.getAvailableTo().
                plus(1, ChronoUnit.DAYS));
        advertisement.setAvailableFrom(createAdvertisementDto.getAvailableFrom());
        advertisement.setAvailableTo(createAdvertisementDto.getAvailableTo());
        advertisement.setPricelist(pricelistDtoMapper.toEntity(createAdvertisementDto.getPricelist()));
        this.advertisementRepository.save(advertisement);
        this.advertisementRepository.flush();
        return advertisement.getId();
    }

    @Override
    public void uploadPhotos(MultipartFile[] files, Long id) throws IOException {
        Path resourceDirectory = Paths.get("src", "main", "resources");
        String path = resourceDirectory.toFile().getAbsolutePath() + "\\images\\advertisement\\" + id + "\\";
        if (!new File(path).exists()) {
            new File(path).mkdir();
        }
        for (int i = 0; i < files.length; i++) {
            String imgName = files[i].getOriginalFilename();
            String filePath = path + imgName;
            File dest = new File(filePath);
            files[i].transferTo(dest);
        }
    }

    @Override
    public List<Advertisement> getInPeriod(String dateFrom, String dateTo) {
        dateFrom = dateFrom.replace('T', ' ');
        dateTo = dateTo.replace('T', ' ');
        System.out.println("datum od" + dateFrom);
        System.out.println("datum do" + dateTo);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateFromTime = LocalDateTime.parse(dateFrom, formatter);
        LocalDateTime dateFromTo = LocalDateTime.parse(dateTo, formatter);

        System.out.println("datum od" + dateFromTime);
        System.out.println("datum do" + dateFromTo);
        return this.advertisementRepository.getInPeriod(dateFromTime, dateFromTo);
    }

    @Override
    public List<String> getAdvertisementPhotos(Long id) throws IOException {
        Path resourceDirectory = Paths.get("src", "main", "resources");
        String path = resourceDirectory.toFile().getAbsolutePath() + "\\images\\advertisement\\" + id + "\\";
        Set<String> allFiles = Stream.of(new File(path).listFiles())
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());
        System.out.println(allFiles);
        List<String> allEncodedImages = new ArrayList<>();
        String encodeImage = null;
        for (String file : allFiles) {
            System.out.println(file);
            File image = new File(path + file);
            encodeImage = Base64.getEncoder().withoutPadding().encodeToString(Files.readAllBytes(image.toPath()));
            allEncodedImages.add(encodeImage);
        }
        return allEncodedImages;
    }

    @Override
    public List<Advertisement> getAll(Long agentId) { //TODO: prikazivanje oglasa jednog agenta
        return advertisementRepository.getAdvertisementByAdvertiser_id(agentId);
    }
}
