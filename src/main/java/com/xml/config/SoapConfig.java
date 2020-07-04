package com.xml.config;

import com.xml.soap.AdvertisementClient;
import com.xml.soap.PricelistClient;
import com.xml.soap.RentRequestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.xml.RentCar.wsdl");
        return marshaller;
    }


    @Bean
    public AdvertisementClient adClient(Jaxb2Marshaller marshaller) {
        AdvertisementClient client = new AdvertisementClient();
        client.setDefaultUri("http://localhost:8085/advertisement-service-schema/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public PricelistClient pricelistClient(Jaxb2Marshaller marshaller) {
        PricelistClient client = new PricelistClient();
        client.setDefaultUri("http://localhost:8084/codebook-service-schema/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public RentRequestClient rentRequestClient(Jaxb2Marshaller marshaller) {
        RentRequestClient client = new RentRequestClient();
        client.setDefaultUri("http://localhost:8089/rent-request-service-schema/ws");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }


}
