package com.bankproject.accountservice.util;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "checking", url = "http://localhost:8002")
public interface CheckingFeignServiceUtil {
}
