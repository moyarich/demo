package edu.depaul.cdm.se.demo.entity;

import com.google.firebase.database.IgnoreExtraProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
    List<Amenity> g4Amenities= new ArrayList<>();
    g4Amenities.add(new Amenity("1","bed",2));
    g4Amenities.add(new Amenity("1","internet",2));

 */

@IgnoreExtraProperties
@Getter
@Setter
@ToString
public class Reservation {
    @Id
    private String id;

    private Integer confirmationNumber;
    private Date checkIn;
    private Date checkOut;

    private String guestId;

    /**
     * employee member who made reservation
     */
    private String createdBy;

    private String modifiedBy;

    /**
     * Hotel Amenities offered to customer
     */
    private List<Amenity> Amenities= new ArrayList<>();

    private List<ReservedRoom> reservedRooms= new ArrayList<>();

    public Reservation() {
    }
}