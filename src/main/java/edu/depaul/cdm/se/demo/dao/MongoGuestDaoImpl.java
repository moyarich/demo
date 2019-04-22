package edu.depaul.cdm.se.demo.dao;



import edu.depaul.cdm.se.demo.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

@Repository
@Qualifier("mongoGuestData")
public class MongoGuestDaoImpl implements IGuestDao{

    @Autowired
    private IMongoGuestRepository repository;

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
