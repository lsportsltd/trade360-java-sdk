package com.lsports.trade360_java_sdk.customers_api.entities.subscription_api.base;

import jakarta.annotation.Nullable;

/**
 * Represents a market in the subscription API.
 *
 * @param marketId The ID of the a market in the subscription API..
 * @param line The line of the market
 *             **/
public record Market (
     int marketId,
    @Nullable String line
){

 //   public Market(int id, String line) {
 //       this.marketId = id;
  //      this.line = line;
  //  }
}