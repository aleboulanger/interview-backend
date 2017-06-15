package org.talend.interview.backend.phone.market.models;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class Price {

    private String name;

    private long price;

    private long lastUpdate;
}
