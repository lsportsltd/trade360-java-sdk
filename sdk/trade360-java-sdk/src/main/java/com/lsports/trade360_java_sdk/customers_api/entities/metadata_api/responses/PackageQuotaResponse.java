package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import java.time.LocalDateTime;

public record PackageQuotaResponse ( int creditRemaining,
                                     int creditLimit,
                                     int usedCredit,
                                     LocalDateTime currentPeriodStartDate,
                                     LocalDateTime currentPeriodEndDate) {
}
