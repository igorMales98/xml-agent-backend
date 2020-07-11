package com.xml.service.impl;

import com.xml.RentCar.wsdl.AdvertisementResponse;
import com.xml.RentCar.wsdl.GetAdvertisementsResponse;
import com.xml.dto.CreateAdvertisementDto;
import com.xml.mapper.*;
import com.xml.model.Advertisement;
import com.xml.model.Car;
import com.xml.model.User;
import com.xml.repository.*;
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
import java.util.*;
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

    @Autowired
    private CarBrandRepository carBrandRepository;

    @Autowired
    private  CarModelRepository carModelRepository;

    @Autowired
    private CarClassRepository carClassRepository;

    @Autowired
    private TransmissionTypeRepository transmissionTypeRepository;

    @Autowired
    private FuelTypeRepository fuelTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PricelistRepository pricelistRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public Long saveAdvertisement(CreateAdvertisementDto createAdvertisementDto, AdvertisementResponse response) throws ParseException {
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
            newCar.setHasAndroid(createAdvertisementDto.isHasAndroid());

            if (newCar.isHasAndroid()) {
                int leftLimit = 97; // letter 'a'
                int rightLimit = 122; // letter 'z'
                int targetStringLength = 10;
                Random random = new Random();
                String generatedString = random.ints(leftLimit, rightLimit + 1)
                        .limit(targetStringLength)
                        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                        .toString();
                newCar.setAndroidToken(generatedString);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        newCar.setRealId(response.getCarId());
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
        advertisement.setDiscount(createAdvertisementDto.convertToHashMap(createAdvertisementDto.getDiscount()));
        advertisement.setRealId(response.getAdvertisementId());
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
        if (dateFrom.matches("\\A\\d{4}\\-\\d{2}-\\d{2}T\\d{2}:\\d{2}\\z") && dateTo.matches("\\A\\d{4}\\-\\d{2}-\\d{2}T\\d{2}:\\d{2}\\z")) {
            dateFrom = dateFrom.replace('T', ' ');
            dateTo = dateTo.replace('T', ' ');

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime dateFromTime = LocalDateTime.parse(dateFrom, formatter);
            LocalDateTime dateFromTo = LocalDateTime.parse(dateTo, formatter);

            return this.advertisementRepository.getInPeriod(dateFromTime, dateFromTo);
        } else {
            return null;
        }
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
            File image = new File(path + file);
            encodeImage = Base64.getEncoder().withoutPadding().encodeToString(Files.readAllBytes(image.toPath()));
            allEncodedImages.add(encodeImage);
        }
        return allEncodedImages;
    }

    @Override
    public List<Advertisement> getAll(Long agentId) {
        return advertisementRepository.getAdvertisementByAdvertiser_id(agentId);
    }

    @Override
    public Integer getTimesRented(Long id) {
        Car car = this.carService.getOne(id);
        return this.advertisementRepository.getTimesRented(id);
    }

    @Override
    public void saveServerAdvertisements(GetAdvertisementsResponse response) {
        List<Advertisement> advertisements = this.advertisementRepository.findAll();
        List<Long> ids = new ArrayList<>();
        for(Advertisement add : advertisements){
            ids.add(add.getRealId());
        }

        for (com.xml.RentCar.wsdl.Advertisement adTemp : response.getAdvertisement()) {
            for (Long id : ids) {
                if (!ids.contains(adTemp.getId())) {
                    Advertisement advertisement = new Advertisement();
                    advertisement.setAvailableFrom(LocalDateTime.parse(adTemp.getAvailableFrom()));
                    advertisement.setAvailableTo(LocalDateTime.parse(adTemp.getAvailableTo()));
                    advertisement.setPricelist(this.pricelistRepository.findById(adTemp.getPricelistId()).get());

                    Car car = new Car();
                    car.setCarBrand(this.carBrandRepository.findById(adTemp.getCar().getCarBrandId()).get());
                    car.setCarModel(this.carModelRepository.findById(adTemp.getCar().getCarModelId()).get());
                    car.setCarClass(this.carClassRepository.findById(adTemp.getCar().getCarClassId()).get());
                    car.setTransmissionType(this.transmissionTypeRepository.findById(adTemp.getCar().getTransmissionTypeId()).get());
                    car.setFuelType(this.fuelTypeRepository.findById(adTemp.getCar().getFuelTypeId()).get());
                    car.setCollisionDamageWaiverExists(adTemp.getCar().isCollisionDamageWaiverExists());
                    car.setHasAndroid(adTemp.getCar().isHasAndroid());
                    car.setMileage(adTemp.getCar().getMileage());
                    car.setAllowedDistance(adTemp.getCar().getAllowedDistance());
                    car.setAverageRating(adTemp.getCar().getAverageRating());
                    car.setTimesRated(adTemp.getCar().getTimesRated());
                    car.setChildSeats(1);
                    this.carRepository.save(car);
                    this.carRepository.flush();

                    advertisement.setCar(car);

                    User user = this.userRepository.findOneById(adTemp.getAdvertiserId());

                    advertisement.setAdvertiser(user);
                    advertisement.setRealId(adTemp.getId());

                    this.advertisementRepository.save(advertisement);
                    break;

                }
            }
        }

    }
}
