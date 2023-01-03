package com.bankproject.historyservice.domain;

import com.bank.domain.AccountType;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String transactionId;
    private String accountId;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @Column(insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionTimeStamp;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    private float transactionAmount;
    private boolean isTransactionSuccess = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Transaction that = (Transaction) o;
        return transactionId != null && Objects.equals(transactionId, that.transactionId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
