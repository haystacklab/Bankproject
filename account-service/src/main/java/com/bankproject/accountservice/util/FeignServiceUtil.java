package com.bankproject.accountservice.util;

import com.bank.domain.checking.CheckingAccount;
import com.bank.domain.credit.CreditAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "feignDemo", url = "http://localhost:8000/")
public interface FeignServiceUtil {

    @GetMapping("/checking/get/{userId}")
    List<CheckingAccount> getCheckingAccounts(@PathVariable String userId);

    @GetMapping("/credit/get/{userId}")
    List<CreditAccount> getCreditAccounts(@PathVariable String userId);

    @GetMapping("/history/get")
    String getHistory();
}
