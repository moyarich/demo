package edu.depaul.cdm.se.demo.entity;

//https://firebase.google.com/docs/database/android/read-and-write

import com.google.firebase.database.IgnoreExtraProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO representing a Guest stored in the Firebase Database.
 */



@IgnoreExtraProperties
@Getter
@Setter
@ToString
public class Hotel {

    @Id
    private String id;

    private String name;

    private Address address;

    private List<Room> rooms = new ArrayList<>();

    public Hotel() {
    }

    public Hotel(String id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}