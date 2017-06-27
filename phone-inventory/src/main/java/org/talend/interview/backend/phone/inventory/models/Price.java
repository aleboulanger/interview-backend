package org.talend.interview.backend.phone.inventory.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Price {

    private String name;

    private long price;

    private long lastUpdate;
}
