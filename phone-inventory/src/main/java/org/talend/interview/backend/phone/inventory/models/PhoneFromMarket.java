package org.talend.interview.backend.phone.inventory.models;

import java.util.Date;

/**
 * Classe permettant de serialiser les données provenant du projet Market
 */

public class PhoneFromMarket {

    private Date lastUpdate;

    private String name;

    private Long price;

    public PhoneFromMarket() {

    }

    public PhoneFromMarket(Date lastUpdate, String name, Long price) {
        this.lastUpdate = lastUpdate;
        this.name = name;
        this.price = price;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
