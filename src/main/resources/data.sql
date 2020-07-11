/* users */
INSERT INTO `xml-agent`.`users` (`type`, `id`, `address`, `city`, `country`, `email`, `enabled`, `password`, `phone`, `username`, `last_name`, `first_name`,`advertisements_posted`) VALUES ('CUSTOMER', '1', 'Janka Veselinovica 1', 'Novi Sad', 'Serbia', 'marko@gmail.com', b'1', '$2a$10$1hoVKaxcWC6/T/.NSGcOm.F7E8vT2xbuJfFuIWEl4hexg28P09CJm', '0651111111', 'markomarkovic', 'Markovic', 'Marko','0');
INSERT INTO `xml-agent`.`users` (`type`, `id`, `address`, `city`, `country`, `email`, `enabled`, `password`, `phone`, `username`, `first_name`, `last_name`,`advertisements_posted`, `business_social_number`) VALUES ('AGENT', '2', 'Cara Dusana 51', 'Novi Sad', 'Serbia', 'mara@gmail.com', b'1', '$2a$10$1hoVKaxcWC6/T/.NSGcOm.F7E8vT2xbuJfFuIWEl4hexg28P09CJm', '063555333', 'maricm', 'Maric', 'Mara','10', '12345');
INSERT INTO `xml-agent`.`users` (`type`, `id`, `address`, `city`, `country`, `email`, `enabled`, `password`, `phone`, `username`, `last_name`, `first_name`,`advertisements_posted`) VALUES ('CUSTOMER', '3', 'Laze Kostica 36', 'Indjija', 'Serbia', 'petar@gmail.com', b'1', '$2a$10$1hoVKaxcWC6/T/.NSGcOm.F7E8vT2xbuJfFuIWEl4hexg28P09CJm', '063555333', 'peraPetar', 'Peric', 'Pera','0');

/* brands */
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`, `enabled`) VALUES ('1', 'Volvo', b'1');
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`, `enabled`) VALUES ('2', 'Saab', b'1');
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`, `enabled`) VALUES ('3', 'Mercedes Benz', b'1');
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`, `enabled`) VALUES ('4', 'BMW', b'1');
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`, `enabled`) VALUES ('5', 'Audi', b'1');
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`, `enabled`) VALUES ('6', 'Opel', b'1');
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`, `enabled`) VALUES ('7', 'Peugeot', b'1');
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`, `enabled`) VALUES ('8', 'Renault', b'1');
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`, `enabled`) VALUES ('9', 'Ford', b'1');
INSERT INTO `xml-agent`.`car_brand` (`id`, `name`, `enabled`) VALUES ('10', 'Hyundai', b'1');

/* models */
/* volvo */
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('1', 'S60', '1', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('2', 'S80', '1', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('3', 'V70', '1', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('4', 'XC90', '1', b'1');
/* saab */
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('5', '9-5', '2', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('6', '9-3', '2', b'1');
/* mercedes */
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('7', 'A-Class', '3', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('8', 'S-Class', '3', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('9', 'ML-Class', '3', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('10', '124', '3', b'1');
/* bmw */
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('11', '520', '4', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('12', 'M3', '4', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('13', 'X7', '4', b'1');
/*audi */
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('14', 'A4', '5', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('15', 'A6', '5', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('16', 'A8', '5', b'1');
/* opel */
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('17', 'Astra', '6', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('18', 'Corsa', '6', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('19', 'Vectra', '6', b'1');
/* peugeot */
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('20', '307', '7', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('21', '407', '7', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('22', '5008', '7', b'1');
/* renault */
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('23', 'Clio', '8', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('24', 'Megane', '8', b'1');
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('25', 'Laguna', '8', b'1');
/* ford */
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('26', 'Focus', '9', b'1');
/* hyundai */
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`, `enabled`) VALUES ('27', 'Tucson', '10', b'1');

/* classes */
INSERT INTO `xml-agent`.`car_class` (`id`, `name`, `enabled`) VALUES ('1', 'Sedan', b'1');
INSERT INTO `xml-agent`.`car_class` (`id`, `name`, `enabled`) VALUES ('2', 'Hatchback', b'1');
INSERT INTO `xml-agent`.`car_class` (`id`, `name`, `enabled`) VALUES ('3', 'Roadster', b'1');
INSERT INTO `xml-agent`.`car_class` (`id`, `name`, `enabled`) VALUES ('4', 'Minivan', b'1');
INSERT INTO `xml-agent`.`car_class` (`id`, `name`, `enabled`) VALUES ('5', 'SUV', b'1');
INSERT INTO `xml-agent`.`car_class` (`id`, `name`, `enabled`) VALUES ('6', 'Pickup', b'1');
INSERT INTO `xml-agent`.`car_class` (`id`, `name`, `enabled`) VALUES ('7', 'Cabriolet', b'1');
INSERT INTO `xml-agent`.`car_class` (`id`, `name`, `enabled`) VALUES ('8', 'Caravan', b'1');

/* fuel types */
INSERT INTO `xml-agent`.`fuel_type` (`id`, `name`, `enabled`) VALUES ('1', 'Petrol', b'1');
INSERT INTO `xml-agent`.`fuel_type` (`id`, `name`, `enabled`) VALUES ('2', 'Diesel', b'1');
INSERT INTO `xml-agent`.`fuel_type` (`id`, `name`, `enabled`) VALUES ('3', 'Petrol + Gas', b'1');
INSERT INTO `xml-agent`.`fuel_type` (`id`, `name`, `enabled`) VALUES ('4', 'Electric', b'1');
INSERT INTO `xml-agent`.`fuel_type` (`id`, `name`, `enabled`) VALUES ('5', 'Hybrid', b'1');

/* transmission types */
INSERT INTO `xml-agent`.`transmission_type` (`id`, `name`, `enabled`) VALUES ('1', 'Manual', b'1');
INSERT INTO `xml-agent`.`transmission_type` (`id`, `name`, `enabled`) VALUES ('2', 'Automatic', b'1');
INSERT INTO `xml-agent`.`transmission_type` (`id`, `name`, `enabled`) VALUES ('3', 'Semi-automatic', b'1');

/* cars */
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('1', '1000000', '4.7', '2', b'1', b'1', '100000', '7', '1', '1', '1', '1', '1');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('2', '1000000', '4.5', '0', b'1', b'0', '200000', '2', '2', '8', '5', '2', '3');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('3', '500', '3', '0', b'0', b'0', '155000', '3', '7', '2', '20', '2', '1');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('4', '1200', '5', '0', b'1', b'1', '12000', '3', '5', '8', '14', '2', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('5', '1500', '3.5', '1', b'0', b'0', '300000', '2', '3', '1', '10', '3', '1');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('6', '500', '4.2', '2', b'1', b'1', '124000', '3', '9', '2', '26', '5', '2');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('7', '1000', '4.6', '1', b'1', b'0', '24000', '5', '10', '4', '27', '2', '3');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('8', '300', '5.0', '0', b'1', b'0', '96000', '3', '4', '3', '12', '1', '1');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('9', '2000', '3.9', '3', b'0', b'1', '196000', '4', '8', '8', '24', '2', '3');
INSERT INTO `xml-agent`.`car` (`id`, `allowed_distance`, `average_rating`, `child_seats`, `collision_damage_waiver_exists`, `has_android`, `mileage`, `times_rated`, `car_brand_id`, `car_class_id`, `car_model_id`, `fuel_type_id`, `transmission_type_id`) VALUES ('10', '2000', '4.1', '0', b'1', b'1', '106000', '4', '6', '2', '17', '2', '2');

/* pricelists */
INSERT INTO `xml-agent`.`pricelist` (`id`, `price_forcdw`, `price_per_day`, `price_per_km`, `enabled`) VALUES ('1', '100', '10', '3', b'1');
INSERT INTO `xml-agent`.`pricelist` (`id`, `price_forcdw`, `price_per_day`, `price_per_km`, `enabled`) VALUES ('2', '150', '20', '7', b'1');
INSERT INTO `xml-agent`.`pricelist` (`id`, `price_forcdw`, `price_per_day`, `price_per_km`, `enabled`) VALUES ('3', '120', '30', '2', b'1');
INSERT INTO `xml-agent`.`pricelist` (`id`, `price_forcdw`, `price_per_day`, `price_per_km`, `enabled`) VALUES ('4', '80', '15', '1', b'1');
INSERT INTO `xml-agent`.`pricelist` (`id`, `price_forcdw`, `price_per_day`, `price_per_km`, `enabled`) VALUES ('5', '300', '17', '10', b'1');
INSERT INTO `xml-agent`.`pricelist` (`id`, `price_forcdw`, `price_per_day`, `price_per_km`, `enabled`) VALUES ('6', '250', '12', '7', b'1');
INSERT INTO `xml-agent`.`pricelist` (`id`, `price_forcdw`, `price_per_day`, `price_per_km`, `enabled`) VALUES ('7', '50', '11', '1', b'1');

/* advertisements */
INSERT INTO `xml-agent`.`advertisement` (`id`, `available_from`, `available_to`, `advertiser_id`, `car_id`, `pricelist_id`) VALUES ('1', '2020-05-01 22:00:00.000000', '2020-05-20 22:00:00.000000', '1', '1', '1');
INSERT INTO `xml-agent`.`advertisement` (`id`, `available_from`, `available_to`, `advertiser_id`, `car_id`, `pricelist_id`) VALUES ('2', '2020-05-01 22:00:00.000000', '2020-05-25 22:00:00.000000', '1', '2', '1');
INSERT INTO `xml-agent`.`advertisement` (`id`, `available_from`, `available_to`, `advertiser_id`, `car_id`, `pricelist_id`) VALUES ('3', '2020-05-01 22:00:00.000000', '2020-05-20 22:00:00.000000', '1', '3', '2');
INSERT INTO `xml-agent`.`advertisement` (`id`, `available_from`, `available_to`, `advertiser_id`, `car_id`, `pricelist_id`) VALUES ('4', '2020-05-10 22:00:00.000000', '2020-06-05 22:00:00.000000', '1', '4', '3');
INSERT INTO `xml-agent`.`advertisement` (`id`, `available_from`, `available_to`, `advertiser_id`, `car_id`, `pricelist_id`) VALUES ('5', '2020-04-10 22:00:00.000000', '2020-04-25 22:00:00.000000', '1', '5', '5');
INSERT INTO `xml-agent`.`advertisement` (`id`, `available_from`, `available_to`, `advertiser_id`, `car_id`, `pricelist_id`) VALUES ('6', '2020-04-10 22:00:00.000000', '2020-06-25 22:00:00.000000', '1', '6', '7');
INSERT INTO `xml-agent`.`advertisement` (`id`, `available_from`, `available_to`, `advertiser_id`, `car_id`, `pricelist_id`) VALUES ('7', '2020-05-01 22:00:00.000000', '2020-07-05 22:00:00.000000', '1', '7', '4');
INSERT INTO `xml-agent`.`advertisement` (`id`, `available_from`, `available_to`, `advertiser_id`, `car_id`, `pricelist_id`) VALUES ('8', '2020-05-25 22:00:00.000000', '2020-06-05 22:00:00.000000', '1', '8', '7');
INSERT INTO `xml-agent`.`advertisement` (`id`, `available_from`, `available_to`, `advertiser_id`, `car_id`, `pricelist_id`) VALUES ('9', '2020-06-10 22:00:00.000000', '2020-07-05 22:00:00.000000', '1', '9', '2');
INSERT INTO `xml-agent`.`advertisement` (`id`, `available_from`, `available_to`, `advertiser_id`, `car_id`, `pricelist_id`) VALUES ('10', '2020-05-01 22:00:00.000000', '2020-06-01 22:00:00.000000', '1', '10', '3');

/* advertisement-discount */
INSERT INTO `xml-agent`.`advertisement_discount` (`advertisement_id`, `discount`, `days`) VALUES ('1', '10', '10');
INSERT INTO `xml-agent`.`advertisement_discount` (`advertisement_id`, `discount`, `days`) VALUES ('2', '20', '20');
INSERT INTO `xml-agent`.`advertisement_discount` (`advertisement_id`, `discount`, `days`) VALUES ('3', '7', '5');
INSERT INTO `xml-agent`.`advertisement_discount` (`advertisement_id`, `discount`, `days`) VALUES ('4', '15', '15');
INSERT INTO `xml-agent`.`advertisement_discount` (`advertisement_id`, `discount`, `days`) VALUES ('5', '12', '13');
INSERT INTO `xml-agent`.`advertisement_discount` (`advertisement_id`, `discount`, `days`) VALUES ('6', '2', '2');
INSERT INTO `xml-agent`.`advertisement_discount` (`advertisement_id`, `discount`, `days`) VALUES ('7', '14', '12');
INSERT INTO `xml-agent`.`advertisement_discount` (`advertisement_id`, `discount`, `days`) VALUES ('8', '8', '22');
INSERT INTO `xml-agent`.`advertisement_discount` (`advertisement_id`, `discount`, `days`) VALUES ('9', '21', '12');
INSERT INTO `xml-agent`.`advertisement_discount` (`advertisement_id`, `discount`, `days`) VALUES ('10', '9', '5');
INSERT INTO `xml-agent`.`advertisement_discount` (`advertisement_id`, `discount`, `days`) VALUES ('1', '15', '15');
INSERT INTO `xml-agent`.`advertisement_discount` (`advertisement_id`, `discount`, `days`) VALUES ('3', '10', '10');
INSERT INTO `xml-agent`.`advertisement_discount` (`advertisement_id`, `discount`, `days`) VALUES ('4', '17', '16');
INSERT INTO `xml-agent`.`advertisement_discount` (`advertisement_id`, `discount`, `days`) VALUES ('6', '4', '4');
INSERT INTO `xml-agent`.`advertisement_discount` (`advertisement_id`, `discount`, `days`) VALUES ('7', '20', '15');
INSERT INTO `xml-agent`.`advertisement_discount` (`advertisement_id`, `discount`, `days`) VALUES ('4', '18', '17');

/* comments */
INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('1', b'1', 'Volvo je masinerija.', 'Kao tenk.', '1', '2');
INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('2', b'1', 'Auto je bas lep. Ide ovaj volvo', 'Jeste slazem se', '1', '5');
INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('3', b'1', 'Al je udoban.', 'Kao u duseku.', '1', '3');
INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('4', b'1', 'Auto je bas lep', 'Jeste slazem se', '2', '7');
INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('5', b'1', 'Auto je bas lep', 'Jeste slazem se', '3', '8');
INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('6', b'1', 'Sve je super', 'Jeste slazem se', '4', '5');
INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('7', b'1', 'Auto je bas lep', 'Jeste slazem se', '5', '2');
INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('8', b'1', 'Auto je bas lep', 'Jeste slazem se', '6', '6');
INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('9', b'1', 'Auto je bas lep', 'Jeste slazem se', '6', '2');
INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('10', b'1', 'Auto je bas lep', 'Jeste slazem se', '7', '3');
INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('11', b'1', 'Auto je bas lep', 'Jeste slazem se', '8', '4');
INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('12', b'1', 'Auto je bas lep', 'Jeste slazem se', '8', '5');
INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('13', b'1', 'Auto je bas lep', 'Jeste slazem se', '9', '6');
INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('14', b'1', 'Auto je bas lep', 'Jeste slazem se', '9', '7');
INSERT INTO `xml-agent`.`comment` (`id`, `approved`, `comment`, `reply`, `advertisement_id`, `commenter_id`) VALUES ('15', b'1', 'Auto je bas lep', 'Jeste slazem se', '10', '8');

/* messages */
INSERT INTO `xml-agent`.`message` (`id`,`message`,`message_date`,`receiver_id`,`sender_id`) VALUES ('1','cao','2020-05-06 19:48:40.614962','2','1');
INSERT INTO `xml-agent`.`message` (`id`,`message`,`message_date`,`receiver_id`,`sender_id`) VALUES ('2','cao','2020-05-06 20:06:40.614962','1','2');
INSERT INTO `xml-agent`.`message` (`id`,`message`,`message_date`,`receiver_id`,`sender_id`) VALUES ('3','sta radis?','2020-05-06 20:08:40.614962','2','1');
INSERT INTO `xml-agent`.`message` (`id`,`message`,`message_date`,`receiver_id`,`sender_id`) VALUES ('4','nista','2020-05-06 20:10:40.614962','1','2');
INSERT INTO `xml-agent`.`message` (`id`,`message`,`message_date`,`receiver_id`,`sender_id`) VALUES ('5','ti?','2020-05-06 20:10:40.614962','1','2');
INSERT INTO `xml-agent`.`message` (`id`,`message`,`message_date`,`receiver_id`,`sender_id`) VALUES ('6','nista','2020-05-06 20:18:40.614962','2','1');

/* rent-requests */
INSERT INTO `xml-agent`.`rent_request` (`id`, `status`, `reserved_from`, `reserved_to`, `customer_id`) VALUES ('1', 'PENDING', '2020-05-11 17:58:00.000000', '2020-05-11 17:58:00.000000', '2');
INSERT INTO `xml-agent`.`rent_request` (`id`, `status`, `reserved_from`, `reserved_to`, `customer_id`) VALUES ('2', 'PENDING', '2020-05-11 17:58:00.000000', '2020-05-11 17:58:00.000000', '2');
INSERT INTO `xml-agent`.`rent_request` (`id`, `status`, `reserved_from`, `reserved_to`, `customer_id`) VALUES ('3', 'PENDING', '2020-05-11 17:58:00.000000', '2020-05-11 17:58:00.000000', '2');
INSERT INTO `xml-agent`.`rent_request` (`id`, `status`, `reserved_from`, `reserved_to`, `customer_id`) VALUES ('4', 'PENDING', '2020-05-11 17:58:00.000000', '2020-05-11 17:58:00.000000', '2');
INSERT INTO `xml-agent`.`rent_request` (`id`, `status`, `reserved_from`, `reserved_to`, `customer_id`) VALUES ('5', 'RESERVED', '2020-05-10 17:00:00.000000', '2020-05-15 17:00:00.000000', '2');
INSERT INTO `xml-agent`.`rent_request` (`id`, `status`, `reserved_from`, `reserved_to`, `customer_id`) VALUES ('6', 'RESERVED', '2020-06-01 17:58:00.000000', '2020-06-10 17:58:00.000000', '2');
INSERT INTO `xml-agent`.`rent_request` (`id`, `status`, `reserved_from`, `reserved_to`, `customer_id`) VALUES ('7', 'RESERVED', '2020-05-05 17:58:00.000000', '2020-06-10 17:58:00.000000', '2');
INSERT INTO `xml-agent`.`rent_request` (`id`, `status`, `reserved_from`, `reserved_to`, `customer_id`) VALUES ('8', 'PAID', '2020-05-01 17:58:00.000000', '2020-05-02 17:58:00.000000', '2');
INSERT INTO `xml-agent`.`rent_request` (`id`, `status`, `reserved_from`, `reserved_to`, `customer_id`) VALUES ('9', 'PAID', '2020-05-01 17:58:00.000000', '2020-05-03 17:58:00.000000', '2');
INSERT INTO `xml-agent`.`rent_request` (`id`, `status`, `reserved_from`, `reserved_to`, `customer_id`) VALUES ('10', 'PAID', '2020-04-11 17:58:00.000000', '2020-04-21 17:58:00.000000', '2');

/* rented-advertisements */
INSERT INTO `xml-agent`.`rented_advertisements` (`rent_request_id`, `advertisement_id`) VALUES ('5', '3');
INSERT INTO `xml-agent`.`rented_advertisements` (`rent_request_id`, `advertisement_id`) VALUES ('5', '4');
INSERT INTO `xml-agent`.`rented_advertisements` (`rent_request_id`, `advertisement_id`) VALUES ('6', '6');
INSERT INTO `xml-agent`.`rented_advertisements` (`rent_request_id`, `advertisement_id`) VALUES ('7', '7');
INSERT INTO `xml-agent`.`rented_advertisements` (`rent_request_id`, `advertisement_id`) VALUES ('8', '1');
INSERT INTO `xml-agent`.`rented_advertisements` (`rent_request_id`, `advertisement_id`) VALUES ('9', '2');
INSERT INTO `xml-agent`.`rented_advertisements` (`rent_request_id`, `advertisement_id`) VALUES ('9', '3');
INSERT INTO `xml-agent`.`rented_advertisements` (`rent_request_id`, `advertisement_id`) VALUES ('10', '5');

/* reports */
INSERT INTO `xml-agent`.`report` (`id`, `additional_information`, `km`, `car_id`, `rent_request_id`) VALUES ('1', 'Isao je lepo bas', '100', '1', '8');
INSERT INTO `xml-agent`.`report` (`id`, `additional_information`, `km`, `car_id`, `rent_request_id`) VALUES ('2', 'Bas je udoban', '200', '2', '9');

























