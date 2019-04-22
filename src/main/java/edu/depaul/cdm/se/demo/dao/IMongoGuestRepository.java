package edu.depaul.cdm.se.demo.dao;

import edu.depaul.cdm.se.demo.entity.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IMongoGuestRepository extends MongoRepository<Guest, String> {

    // Declare query methods here

    @Query("{ 'id' : ?0 }")
    Guest getGuestById(String model);
}