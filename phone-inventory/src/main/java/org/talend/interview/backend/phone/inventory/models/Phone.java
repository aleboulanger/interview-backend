package org.talend.interview.backend.phone.inventory.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Phone {

    @Id
    private String name;

    private String brand;

    private long originalPrice;
}
