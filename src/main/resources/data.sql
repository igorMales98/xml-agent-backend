INSERT INTO `xml-agent`.`users` (`type`, `id`, `address`, `city`, `country`, `email`, `enabled`, `password`, `phone`, `username`, `business_social_number`, `firm_name`) VALUES ('FIRM', '1', 'Sime Milosevica 5', 'Novi Sad', 'Serbia', 'baijc@gmail.com', b'1', '$2a$10$1hoVKaxcWC6/T/.NSGcOm.F7E8vT2xbuJfFuIWEl4hexg28P09CJm', '063555333', 'agentfirm', '12345', 'Dom Baijc');
INSERT INTO `xml-agent`.`users` (`type`, `id`, `address`, `city`, `country`, `email`, `enabled`, `password`, `phone`, `username`, `last_name`, `first_name`,`advertisements_posted`) VALUES ('CUSTOMER', '2', 'Puskinova 8', 'Novi Sad', 'Serbia', 'marko@gmail.com', b'1', '$2a$10$1hoVKaxcWC6/T/.NSGcOm.F7E8vT2xbuJfFuIWEl4hexg28P09CJm', '063555333', 'jovanjo', 'Jovanovic', 'Jovan','0');
INSERT INTO `xml-agent`.`users` (`type`, `id`, `address`, `city`, `country`, `email`, `enabled`, `password`, `phone`, `username`, `last_name`, `first_name`,`advertisements_posted`) VALUES ('CUSTOMER', '3', 'Cara Dusana 51', 'Novi Sad', 'Serbia', 'mara@gmail.com', b'1', '$2a$10$1hoVKaxcWC6/T/.NSGcOm.F7E8vT2xbuJfFuIWEl4hexg28P09CJm', '063555333', 'maricm', 'Maric', 'Mara','0');


INSERT INTO `xml-agent`.`car_brand` (`id`, `name`) VALUES ('1', 'Volvo');
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`) VALUES ('2', 'Saab');
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`) VALUES ('3', 'Mercedes Benz');
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`) VALUES ('4', 'BMW');
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`) VALUES ('5', 'Audi');
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`) VALUES ('6', 'Opel');
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`) VALUES ('7', 'Peugeot');
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`) VALUES ('8', 'Renault');

INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('1', 'S60', '1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('2', 'S80', '1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('3', 'V70', '1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('4', 'XC90', '1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('5', '9-5', '2');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('6', '9-3', '2');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('7', 'A-Class', '3');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('8', 'S-Class', '3');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('9', 'ML-Class', '3');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('10', '520', '4');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('11', 'M3', '4');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('12', 'X7', '4');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('13', 'A4', '5');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('14', 'A6', '5');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('15', 'A8', '5');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('16', 'Astra', '6');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('17', 'Corsa', '6');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('18', 'Vectra', '6');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('19', '307', '7');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('20', '407', '7');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('21', '5008', '7');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('22', 'Clio', '8');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('23', 'Kangoo', '8');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('24', 'Laguna', '8');

INSERT INTO `xml-agent`.`car_class` (`id`, `name`) VALUES ('1', 'Sedan');
INSERT INTO `xml-agent`.`car_class` (`id`, `name`) VALUES ('2', 'Hatchback');
INSERT INTO `xml-agent`.`car_class` (`id`, `name`) VALUES ('3', 'Roadster');
INSERT INTO `xml-agent`.`car_class` (`id`, `name`) VALUES ('4', 'Minivan');
INSERT INTO `xml-agent`.`car_class` (`id`, `name`) VALUES ('5', 'SUV');
INSERT INTO `xml-agent`.`car_class` (`id`, `name`) VALUES ('6', 'Pickup');
INSERT INTO `xml-agent`.`car_class` (`id`, `name`) VALUES ('7', 'Cabriolet');
INSERT INTO `xml-agent`.`car_class` (`id`, `name`) VALUES ('8', 'Caravan');

INSERT INTO `xml-agent`.`fuel_type` (`id`, `name`) VALUES ('1', 'Petrol');
INSERT INTO `xml-agent`.`fuel_type` (`id`, `name`) VALUES ('2', 'Diesel');
INSERT INTO `xml-agent`.`fuel_type` (`id`, `name`) VALUES ('3', 'Petrol + Gas');
INSERT INTO `xml-agent`.`fuel_type` (`id`, `name`) VALUES ('4', 'Electric');
INSERT INTO `xml-agent`.`fuel_type` (`id`, `name`) VALUES ('5', 'Hybrid');

INSERT INTO `xml-agent`.`transmission_type` (`id`, `name`) VALUES ('1', 'Manual');
INSERT INTO `xml-agent`.`transmission_type` (`id`, `name`) VALUES ('2', 'Automatic');
INSERT INTO `xml-agent`.`transmission_type` (`id`, `name`) VALUES ('3', 'Semi-automatic');

INSERT INTO `xml-agent`.`pricelist` (`id`, `price_per_day`) VALUES ('1', '10');
INSERT INTO `xml-agent`.`pricelist` (`id`, `price_per_day`) VALUES ('2', '20');
INSERT INTO `xml-agent`.`pricelist` (`id`, `price_per_day`) VALUES ('3', '30');

INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('1', '1000000', '4', '2', b'1', b'1', '100000', '1', '1', '1', '1', '1', '1');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('2', '1000000', '3.5', '0', b'1', b'0', '200000', '2', '2', '8', '5', '2', '3');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('3', '500', '3', '0', b'0', b'0', '155000', '3', '7', '2', '19', '2', '1');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('4', '1200', '5', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('5', '1200', '2', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('6', '1200', '1', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('7', '1200', '1.5', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('8', '1200', '3.5', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('9', '1200', '6.5', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('10', '1200', '4.6', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('11', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('12', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('13', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('14', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('15', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
/*INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('16', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('17', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('18', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('19', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('20', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('21', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('22', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('23', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('24', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('25', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('26', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('27', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('28', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('29', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('30', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('31', '1200', '2.7', '0', b'1', b'1', '12000', '3', '5', '8', '13', '2', '2');
*/
INSERT INTO `xml-agent`.`advertisement` (`id`, `available_from`, `available_to`, `advertiser_id`, `car_id`, `pricelist_id`) VALUES ('1', '2020-05-01 22:00:00.000000', '2020-05-20 22:00:00.000000', '1', '1', '1');
INSERT INTO `xml-agent`.`advertisement` (`id`, `available_from`, `available_to`, `advertiser_id`, `car_id`, `pricelist_id`) VALUES ('2', '2020-05-05 22:00:00.000000', '2020-05-25 22:00:00.000000', '1', '2', '1');
INSERT INTO `xml-agent`.`advertisement` (`id`, `available_from`, `available_to`, `advertiser_id`, `car_id`, `pricelist_id`) VALUES ('3', '2020-05-10 22:00:00.000000', '2020-05-20 22:00:00.000000', '1', '3', '2');
INSERT INTO `xml-agent`.`advertisement` (`id`, `available_from`, `available_to`, `advertiser_id`, `car_id`, `pricelist_id`) VALUES ('4', '2020-05-10 22:00:00.000000', '2020-06-05 22:00:00.000000', '1', '4', '3');

INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('1', b'1', 'Neki komentar...', null, '1','2');
INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('2', b'1', 'Neki drugi komentar...', null, '1','3');



















