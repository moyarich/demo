package edu.depaul.cdm.se.demo.dao;
import edu.depaul.cdm.se.demo.entity.Guest;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Collection;
import java.util.Map;

public interface IGuestDao {
    //Collection<Guest> getA_temp();
    DeferredResult<Map<String, Guest>> getAllGuests();

    Guest getGuestById(String id);

    void deleteGuestById(String id);

    void updateGuest(Guest updatedGuest);

    Guest updateById(String id, Guest updatedGuest);

    void insertGuest(Guest guest);
}
