package edu.depaul.cdm.se.demo.entity;


import com.google.firebase.database.IgnoreExtraProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;





@IgnoreExtraProperties
@Getter
@Setter
@ToString
public class Amenity {
    @Id
    private String id;

    private String name;

    private int quantity;


    public Amenity(){};

    public Amenity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Amenity(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
}
