package com.lsports.trade360_java_sdk.customers_api.entities.metadata_api.responses;

import java.time.LocalDateTime;

/**
 * The {@code PackageQuotaResponse} record represents a response containing package quota information.
 *
 * @param creditRemaining the remaining credit
 * @param creditLimit the credit limit
 * @param usedCredit the used credit
 * @param currentPeriodStartDate the start date of the current period in UTC
 * @param currentPeriodEndDate the end date of the current period in UTC
 * @see LocalDateTime
 */
public record PackageQuotaResponse(
    int creditRemaining,
    int creditLimit,
    int usedCredit,
    LocalDateTime currentPeriodStartDate,
    LocalDateTime currentPeriodEndDate) {
}