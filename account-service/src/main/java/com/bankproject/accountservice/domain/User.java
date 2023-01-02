package com.bankproject.accountservice.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String userId;
    private String firstName;
    private String lastName;
    private Date memberSince;
    private String address;
    private String zip;
    private String state;
    private String country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return userId != null && Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
