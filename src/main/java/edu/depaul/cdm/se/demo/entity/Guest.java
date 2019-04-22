package edu.depaul.cdm.se.demo.entity;

//https://firebase.google.com/docs/database/android/read-and-write

import com.google.firebase.database.IgnoreExtraProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * POJO representing a Guest stored in the Firebase Database.
 */



@IgnoreExtraProperties
@Getter
@Setter
@ToString
public class Guest {

    @Id
    private String id;

    private String name;

    private String email;

    public Guest() {
        // Default constructor required for calls to DataSnapshot.getValue(Guest.class)
    }

    public Guest(String name, String email) {
        this.name = name;
        this.email = email;
    }
    // Lombok adds the getters, setters and toString

}