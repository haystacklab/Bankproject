package com.bank.domain.history;

import lombok.Data;

import java.util.List;

@Data
public class History {
    private HistoryType historyType;
    private int periodInDays;
    private List<Transaction> transactions;
}
