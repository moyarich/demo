package edu.depaul.cdm.se.demo.entity;

import org.springframework.data.annotation.Id;

public class Address {
    @Id
    private String id;

    private String streetAddress;

    private String city;

    private String state;

    private String zipCode;
}
