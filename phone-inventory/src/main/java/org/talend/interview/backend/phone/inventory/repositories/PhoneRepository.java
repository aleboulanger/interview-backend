package org.talend.interview.backend.phone.inventory.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.talend.interview.backend.phone.inventory.models.Phone;

@RepositoryRestResource(collectionResourceRel = "phone", path = "phone")
public interface PhoneRepository extends MongoRepository<Phone, String> {
}
