package org.talend.interview.backend.phone.inventory.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Phone {

    @Id
    private String name;

    private String brand;

    private long originalPrice;
}
