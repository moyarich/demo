package edu.depaul.cdm.se.demo.dao;



import edu.depaul.cdm.se.demo.controller.ResourceNotFoundException;
import edu.depaul.cdm.se.demo.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Repository
@Qualifier("mongoGuestData")
public class MongoGuestDaoImpl implements IGuestDao{

    @Autowired
    private IMongoGuestRepository repository;

    @Override
    public DeferredResult<Map<String, Guest>> getAllGuests() {
        final DeferredResult<Map<String, Guest>> result = new DeferredResult();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Map<String, Guest> map = repository.findAll()
                            .stream()
                            .collect(Collectors.toMap(Guest::getId, guest -> guest));

                    result.setResult(map);
                }
                catch (Exception ex) {
                    result.setErrorResult(ex);
                }
            }
        }).start();
        return result;
    }

    @Override
    public Guest getGuestById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
    }



/*    public Guest getGuestById(String id) {
        return repository.getGuestById(id);
    }*/

    @Override
    public void deleteGuestById(String id) {
        repository.deleteById(id);
    }

    @Override
    public void updateGuest(Guest updatedGuest) {
        Guest guest = repository.findById(updatedGuest.getId())
                .orElseThrow(() -> new ResourceNotFoundException());

        repository.save(updatedGuest);
    }

    public Guest updateById(String id, Guest updatedGuest) {
        Guest guest = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());

        guest.setName(updatedGuest.getName());
        guest.setEmail(updatedGuest.getEmail());
        guest.setAddress(updatedGuest.getAddress());

        return repository.save(guest);
    }


    @Override
    public void insertGuest(Guest guest) {
        System.out.println(guest);
        repository.insert(guest);
    }

/*    CompletableFuture<Guest> findOneById(final String id){

    };*/
}
