package com.bank.domain.history;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
public class History {
    private final int periodInDays;
    private final List<Transaction> transactions;

    public History(Builder builder) {
        this.periodInDays = builder.periodInDays;
        this.transactions = builder.transactions;
    }

    public static class Builder {
        private int periodInDays;
        private List<Transaction> transactions;

        public static Builder newInstance() {
            return new Builder();
        }

        private Builder() {}

        public Builder setPeriodInDays(int periodInDays) {
            this.periodInDays = periodInDays;
            return this;
        }

        public Builder setTransactions(List<Transaction> transactions) {
            this.transactions = transactions;
            return this;
        }

        public History build() {
            return new History(this);
        }
    }
}
