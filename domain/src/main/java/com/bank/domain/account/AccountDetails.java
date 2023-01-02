package com.bank.domain.account;

import lombok.Data;

import java.util.Date;

@Data
public class AccountDetails {
    private String Id;
    private String firstName;
    private String lastName;
    private Date memberSince;
    private String address;
    private String zip;
    private String state;
    private String country;
}
