package com.lsports.trade360_java_sdk.common.entities.markets;

import java.time.LocalDateTime;
import com.lsports.trade360_java_sdk.common.entities.enums.*;
import jakarta.annotation.Nullable;

public class Bet {

    public long id;

    @Nullable public String name;

    @Nullable public String line;

    @Nullable public String baseLine;

    public BetStatus status;

    @Nullable public String startPrice;

    @Nullable public String price;

    @Nullable public String priceVolume;

    public SettlementType settlement;

    @Nullable public String providerBetId;

    public LocalDateTime lastUpdate;

    @Nullable public String priceIN;

    @Nullable public String priceUS;

    @Nullable public String priceUK;

    @Nullable public String priceMA;

    @Nullable public String priceHK;

    public int isChanged = -1;

    public double probability;

    public int participantId;

    @Nullable public String playerName;
}
