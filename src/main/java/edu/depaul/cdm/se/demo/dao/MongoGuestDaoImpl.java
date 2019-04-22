package edu.depaul.cdm.se.demo.dao;



import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import edu.depaul.cdm.se.demo.entity.Guest;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Qualifier("mongoData")
public class MongoGuestDaoImpl implements IGuestDao{

    @Autowired
    private GuestRepository repository;

    private static Map<String, Guest> guestList;

    @Override
    public Collection<Guest> getAllGuests(){
        return repository.findAll();
    }

    @Override
    public Guest getGuestById(String id) {
        return repository.getGuestById(id);
    }

    @Override
    public void deleteGuestById(String id) {
        repository.deleteById(id);
    }

    @Override
    public void updateGuest(Guest guest) {
        repository.save(guest);
    }

    @Override
    public void insertGuest(Guest guest) {
        System.out.println(guest);
        repository.insert(guest);
    }
}
