package edu.depaul.cdm.se.demo.entity;

import com.google.firebase.database.IgnoreExtraProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@IgnoreExtraProperties
@Getter
@Setter
@ToString
public class Address {
    private String street;

    private String city;

    private String state;

    private String zipCode;
}
