package edu.depaul.cdm.se.demo.service;


import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import edu.depaul.cdm.se.demo.dao.IGuestDao;
import edu.depaul.cdm.se.demo.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;

@Service
public class GuestService {

    @Autowired
    @Qualifier("firebaseGuestData")
    //@Qualifier("mongoGuestData")
    //@Qualifier("fakeGuestData")

    private IGuestDao guestDao;

/*    public Collection<Guest> getAllGuests(){
        return this.guestDao.getA_temp();
    }*/

    public Guest getGuestById(String id){
        return this.guestDao.getGuestById(id);
    }

    public void deleteGuestById(String id) {
        this.guestDao.deleteGuestById(id);
    }

    public void updateGuest(Guest guest){
        this.guestDao.updateGuest(guest);
    }

    public Guest update(String id,Guest updatedGuest) {
        return this.guestDao.updateById(id, updatedGuest);
    }

    public void insertGuest(Guest guest) {
        this.guestDao.insertGuest(guest);
    }

    public DeferredResult<Map<String, Guest>> getAll() {return this.guestDao.getAllGuests();};

    public ApiFuture<String> incompleteFuture() {
        final SettableApiFuture<String> future = SettableApiFuture.create();
        new Thread() {
            @Override
            public void run() {
                try {
                    future.set("testAsync-------hi there moya");
                } catch (Exception e) {
                    future.setException(e);
                }
            }
        }.start();
        return future;
    }
}
