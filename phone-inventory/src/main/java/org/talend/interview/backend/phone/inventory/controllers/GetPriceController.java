package org.talend.interview.backend.phone.inventory.controllers;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.talend.interview.backend.phone.inventory.models.Phone;
import org.talend.interview.backend.phone.inventory.models.PhonePrice;
import org.talend.interview.backend.phone.inventory.models.Price;
import org.talend.interview.backend.phone.inventory.repositories.BrandRepository;
import org.talend.interview.backend.phone.inventory.repositories.PhoneRepository;
import scala.util.parsing.json.JSONObject;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class GetPriceController {

    @Resource
    PhoneRepository phoneRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/api/phones",produces = "application/json")

    public List<PhonePrice> getPhonesListPrice() {

        RestTemplate restTemplate = new RestTemplate();
        List<PhonePrice> phonePrices = new ArrayList<>();

        List<Phone> phones = phoneRepository.findAll();


        for(Phone phone : phones) {
            if(StringUtils.isNotEmpty(phone.getName())) {
                Price price = restTemplate.getForObject("http://localhost:9010/price/"+phone.getName(), Price.class);
                if(price != null) {
                     PhonePrice phonePrice = new PhonePrice();
                     phonePrice.name = phone.getName();
                     phonePrice.currentPrice = price.getPrice();
                     phonePrices.add(phonePrice);
                }

            }

        }

        return phonePrices;
    }

}
