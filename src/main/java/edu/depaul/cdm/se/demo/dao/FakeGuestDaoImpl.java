package edu.depaul.cdm.se.demo.dao;



import edu.depaul.cdm.se.demo.entity.Guest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeGuestDaoImpl implements IGuestDao {

    private static Map<String, Guest> guestList;

    static {

        guestList = new HashMap<String, Guest>(){

            {
                put("1", new Guest("1", "Said","anon@example.com"));
                put("2", new Guest("2", "Alex U","alex@example.com"));
                put("3", new Guest("3", "Anna","anna@example.com"));
            }
        };
    }

    @Override
    public Collection<Guest> getAllGuests(){
        return this.guestList.values();
    }

    @Override
    public Guest getGuestById(String id){
        return this.guestList.get(id);
    }

    @Override
    public void deleteGuestById(String id) {
        this.guestList.remove(id);
    }

    @Override
    public void updateGuest(Guest guest){
        Guest s = guestList.get(guest.getId());
        s.setName(guest.getName());
        guestList.put(guest.getId(), guest);
    }

    @Override
    public void insertGuest(Guest guest) {
        this.guestList.put(guest.getId(), guest);
    }
}
