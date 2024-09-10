package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import java.time.LocalDateTime;

public class PackageQuotaResponse {

    public int creditRemaining;

    public int creditLimit;

    public int usedCredit;

    public LocalDateTime currentPeriodStartDate;

    public LocalDateTime currentPeriodEndDate;
}
