package edu.depaul.cdm.se.demo.service;


import edu.depaul.cdm.se.demo.dao.IGuestDao;
import edu.depaul.cdm.se.demo.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class GuestService {

    @Autowired
    @Qualifier("mongoData")
    private IGuestDao guestDao;

    public Collection<Guest> getAllGuests(){
        return this.guestDao.getAllGuests();
    }

    public Guest getGuestById(String id){
        return this.guestDao.getGuestById(id);
    }

    public void deleteGuestById(String id) {
        this.guestDao.deleteGuestById(id);
    }

    public void updateGuest(Guest guest){
        this.guestDao.updateGuest(guest);
    }

    public void insertGuest(Guest guest) {
        this.guestDao.insertGuest(guest);
    }
}
