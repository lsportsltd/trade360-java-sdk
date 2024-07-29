package com.lsports.trade360_java_sdk.common.entities.markets;

import java.time.LocalDateTime;
import com.lsports.trade360_java_sdk.common.entities.enums.*;

public class Bet {

    public long id;

    public String name;

    public String line;

    public String baseLine;

    public BetStatus status;

    public String startPrice;

    public String price;

    public String priceVolume;

    public SettlementType settlement;

    public String providerBetId;

    public LocalDateTime lastUpdate;

    public String priceIN;

    public String priceUS;

    public String priceUK;

    public String priceMA;

    public String priceHK;

    public int isChanged = -1;

    public double probability;

    public int participantId;

    public String playerName;
}
