package com.softserve.message_sender.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class UserReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String mail;
    private double cost;

    public static final String TITLE = "Electronic receipt";

    @Override
    public String toString() {
        return String.format("Hello, %s. Thanks for a ride. We hope you've enjoyed it.%nTotal cost: %.2f $", getFirstName(), getCost());
    }

    //TODO add date
    //TODO util class for static strings?
}
