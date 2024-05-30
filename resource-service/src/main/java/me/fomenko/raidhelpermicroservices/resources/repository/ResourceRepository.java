package me.fomenko.raidhelpermicroservices.resources.repository;

import me.fomenko.raidhelpermicroservices.resources.entity.ResourceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Resource repository.
 */
@Repository
public interface ResourceRepository extends MongoRepository<ResourceEntity, String> {
}
