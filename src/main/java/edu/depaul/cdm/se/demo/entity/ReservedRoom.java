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

    private Integer numberOfGuest;

    private String roomId;

    public ReservedRoom() {
    }
}