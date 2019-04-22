package edu.depaul.cdm.se.demo.dao;



import edu.depaul.cdm.se.demo.entity.Amenity;
import edu.depaul.cdm.se.demo.entity.Guest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.*;

@Repository
@Qualifier("fakeGuestData")
public class FakeGuestDaoImpl implements IGuestDao {

    private static Map<String, Guest> guestList;

    static {

        guestList = new HashMap<String, Guest>(){

            {
                Guest g1 = new Guest();
                g1.setId("1");
                g1.setName("Said");
                g1.setEmail("anon@example.com");

                Guest g2 = new Guest();
                g2.setId("2");
                g2.setName("Alex U");
                g2.setEmail("alex@example.com");

                Guest g3 = new Guest();
                g3.setId("3");
                g3.setName("Anna");
                g3.setEmail("anna@example.com");


                put("1", g1);
                put("2", g2);
                put("3", g3);
                put("4", g3);
            }
        };
    }

    @Override
    public DeferredResult<Map<String, Guest>> getAllGuests() {
        final DeferredResult<Map<String, Guest>> result = new DeferredResult();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    result.setResult(guestList);
                }
                catch (Exception ex) {
                    result.setErrorResult(ex);
                }
            }
        }).start();
        return result;
    }

 /*   @Override
    public Collection<Guest> getA_temp(){
        return this.guestList.values();
    }
*/
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
