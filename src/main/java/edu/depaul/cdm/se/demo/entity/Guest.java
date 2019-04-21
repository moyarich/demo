package edu.depaul.cdm.se.demo.entity;

//https://firebase.google.com/docs/database/android/read-and-write

import com.google.firebase.database.IgnoreExtraProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * POJO representing a Guest stored in the Firebase Database.
 */



@IgnoreExtraProperties
@Getter
@Setter
@ToString
public class Guest {

    private String id;

    private String name;

    private String email;

    public Guest() {
        // Default constructor required for calls to DataSnapshot.getValue(Guest.class)
    }

    public Guest(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}