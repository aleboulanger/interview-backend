package org.talend.interview.backend.phone.market.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.talend.interview.backend.phone.market.models.Price;

import java.time.Instant;

/**
 * simulate price calculation for a phone.
 *
 */
@RestController
public class PriceController {

    @RequestMapping(method = RequestMethod.GET, path = "/price/{phone}",produces = "application/json")
    public HttpEntity<Price> getPrice(@PathVariable("phone") String phone) {
        Price result = Price
                .builder()
                .lastUpdate(Instant.now().toEpochMilli()).name(phone)
                .price(400)
                .build();
        return new HttpEntity<>(result);
    }

}
