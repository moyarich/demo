package edu.depaul.cdm.se.demo.controller;

import com.google.api.core.ApiFuture;
import edu.depaul.cdm.se.demo.entity.Guest;
import edu.depaul.cdm.se.demo.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/guests")
public class GuestController {
    @Autowired
    private GuestService guestService;


    @RequestMapping("testAsync")
    public ApiFuture<String> incompleteFuture() {
        return guestService.incompleteFuture();
    }

    @RequestMapping(method = RequestMethod.GET)
    public DeferredResult<Map<String, Guest>> create() {
        return guestService.getAll();
    }


/*

    public Collection<Guest> getAllGuests(){
        return guestService.getAllGuests();
    }*/

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Guest getGuestById(@PathVariable("id") String id){
        return guestService.getGuestById(id);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
    public void deleteGuestById(@PathVariable("id") String id){
        guestService.deleteGuestById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateGuest(@RequestBody Guest guest){
        guestService.updateGuest(guest);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertGuest(@RequestBody Guest guest){
        guestService.insertGuest(guest);
    }
}
