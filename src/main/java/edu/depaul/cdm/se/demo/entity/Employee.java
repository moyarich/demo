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
public class Employee {

    @Id
    private String id;

    private String name;

    private String email;

    private Address address;

    public Employee() {
    }

    public Employee(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}