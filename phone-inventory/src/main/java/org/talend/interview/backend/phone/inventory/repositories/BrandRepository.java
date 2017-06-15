package org.talend.interview.backend.phone.inventory.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.talend.interview.backend.phone.inventory.models.Brand;

@RepositoryRestResource(collectionResourceRel = "brand", path = "brand")
public interface BrandRepository extends MongoRepository<Brand, String> {
}
