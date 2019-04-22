package edu.depaul.cdm.se.demo.entity;

import com.google.firebase.database.IgnoreExtraProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;


@IgnoreExtraProperties
@Getter
@Setter
@ToString
public class Room {
    @Id
    private String id;

    /**
     * User friendly name for the group
     */
    private String name;

    /**
     * The id for the Room that identifies it's location
     * So that guest can find it
     */
    private String roomLocationID;

    /**
     * Random meta data about room
     * Description of room
     * Floor number
     * door color, etc
     */
    private String description;

    private String type;

    private Integer maxCapacity;

    private Boolean smoke;

    private Boolean handicap;

    /**
     * occupied
     * unavailable
     */
    private String status;

    private List<Bed> beds = new ArrayList<>();

    /**
     * Amenities available in room
     */
    private List<Amenity> Amenities= new ArrayList<>();

    public Room() {
    }
}