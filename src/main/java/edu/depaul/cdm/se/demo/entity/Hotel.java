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

    private List<String> roomList = new ArrayList<>();

    private List<Reservation> reservations = new ArrayList<>();

    private List<Employee> employees = new ArrayList<>();

    public Hotel() {
    }
}