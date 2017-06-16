package org.talend.interview.backend.phone.inventory.listeners;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.talend.interview.backend.phone.inventory.models.Brand;
import org.talend.interview.backend.phone.inventory.models.Phone;
import org.talend.interview.backend.phone.inventory.repositories.BrandRepository;
import org.talend.interview.backend.phone.inventory.repositories.PhoneRepository;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    BrandRepository brandRepository;

    PhoneRepository phoneRepository;

    @Value("${inventory.brands.path:phone-inventory/db/brands.json}")
    String brandDataPath;

    @Value("${inventory.phones.path:phone-inventory/db/phones.json}")
    String phoneDataPath;

    public ApplicationStartup(@Autowired BrandRepository brandRepository, @Autowired PhoneRepository phoneRepository) {
        this.phoneRepository=phoneRepository;
        this.brandRepository=brandRepository;
    }

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JavaType listOfBrandsType = mapper.getTypeFactory().constructCollectionType(List.class, Brand.class);
            List<Brand> brands = mapper.readValue(new File(brandDataPath).getAbsoluteFile(), listOfBrandsType);
            JavaType listOfPhonesType = mapper.getTypeFactory().constructCollectionType(List.class, Phone.class);
            List<Phone> phones = mapper.readValue(new File(phoneDataPath).getAbsoluteFile(), listOfPhonesType);
            brandRepository.insert(brands);
            phoneRepository.insert(phones);
        } catch (IOException ioe) {
            throw new IllegalStateException("can not initialize brands and phones data.",ioe);
        }
    }
}