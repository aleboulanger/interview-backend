package org.talend.interview.backend.phone.inventory.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.talend.interview.backend.phone.inventory.models.Phone;
import org.talend.interview.backend.phone.inventory.models.PhoneFromMarket;
import org.talend.interview.backend.phone.inventory.repositories.BrandRepository;
import org.talend.interview.backend.phone.inventory.repositories.PhoneRepository;

@RestController
public class PhoneController {

    private PhoneRepository phoneRepository;

    private BrandRepository brandRepository;

    private RestTemplate restTemplate;

    public PhoneController(PhoneRepository phoneRepository, BrandRepository brandRepository, RestTemplate restTemplate) {
        this.phoneRepository = phoneRepository;
        this.brandRepository = brandRepository;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/api/phones/prices")
    public List<Phone> getPhonesWithPrice() {

        List<Phone> listPhones = phoneRepository.findAll();

        return listPhones
                .stream()
                .parallel()
                .map(phone -> {
                    return mapLocalPhoneWithMarket(phone);
                }).collect(Collectors.toList());

    }

    public Phone mapLocalPhoneWithMarket(Phone myLocalPhone) {
        PhoneFromMarket phoneFromMarket = restTemplate.getForObject("http://localhost:9010/price/{phoneName}", PhoneFromMarket.class, myLocalPhone.getName());
        System.out.println("phoneFromMarket = " + phoneFromMarket.getName() + " " +phoneFromMarket.getPrice());
        Phone newPhone = new Phone();
        newPhone.setName(myLocalPhone.getName());
        newPhone.setBrand(myLocalPhone.getBrand());
        newPhone.setOriginalPrice(phoneFromMarket.getPrice());
        return newPhone;
    }
}
