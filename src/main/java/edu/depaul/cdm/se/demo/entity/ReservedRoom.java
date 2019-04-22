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
public class ReservedRoom {
    @Id
    private String id;

    private String ReservationID;

    private Integer numberOfGuest;

    private Room Room;

    public ReservedRoom() {
    }
}