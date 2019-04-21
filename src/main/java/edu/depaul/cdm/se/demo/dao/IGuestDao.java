package edu.depaul.cdm.se.demo.dao;
import edu.depaul.cdm.se.demo.entity.Guest;

import java.util.Collection;

public interface IGuestDao {
    Collection<Guest> getAllGuests();

    Guest getGuestById(String id);

    void deleteGuestById(String id);

    void updateGuest(Guest guest);

    void insertGuest(Guest guest);
}
