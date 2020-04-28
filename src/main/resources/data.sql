INSERT INTO `xml-agent`.`users` (`type`, `id`, `address`, `city`, `country`, `email`, `enabled`, `password`, `phone`, `username`, `business_social_number`, `firm_name`) VALUES ('FIRM', '1', 'Sime Milosevica 5', 'Novi Sad', 'Serbia', 'baijc@gmail.com', b'1', '$2a$10$1hoVKaxcWC6/T/.NSGcOm.F7E8vT2xbuJfFuIWEl4hexg28P09CJm', '063555333', 'agentfirm', '12345', 'Dom Baijc');


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
INSERT INTO `xml-agent`.`car_model` (`id`, `name`, `car_brand_id`) VALUES ('19', '306', '7');
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


















