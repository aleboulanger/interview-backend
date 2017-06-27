package org.talend.interview.backend.phone.inventory.models;

import org.springframework.data.annotation.Id;

public class PhonePrice {

    @Id
    public String name;

    private String brand;

    private long originalPrice;

    public long currentPrice;
}
