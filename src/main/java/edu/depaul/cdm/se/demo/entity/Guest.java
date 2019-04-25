package edu.depaul.cdm.se.demo.entity;

//https://firebase.google.com/docs/database/android/read-and-write

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO representing a Guest stored in the Firebase Database.
 */



@IgnoreExtraProperties
@Getter
@Setter
@ToString
@Document(collection = "guests")
public class Guest {

    @Id
    private String id;

    private String name;

    @Indexed(unique = true)
    private String email;

    private Address address;


    public Guest() {
    }

    public Guest(String id, String name, String email, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
}