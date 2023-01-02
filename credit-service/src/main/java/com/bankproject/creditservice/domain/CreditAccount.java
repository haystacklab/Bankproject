package com.bankproject.creditservice.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "CREDITS")
public class CreditAccount {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String accountId; // maybe foreign key to Account
    private String userId;
    @Enumerated(EnumType.STRING)
    private AccountType accountType = AccountType.CREDIT;
    private Float balance;
    @Enumerated(EnumType.STRING)
    private Status status = Status.CREATED;
//    private List<History> history = List.of(new History());

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CreditAccount that = (CreditAccount) o;
        return accountId != null && Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
