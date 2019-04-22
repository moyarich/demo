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
public class Bed {
    @Id
    private String id;

    /**
     * King, Queen, Double, Twin
     */
    private String type;

    public Bed() {
    }
}