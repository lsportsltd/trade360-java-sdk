package com.lsports.trade360_java_sdk.common.entities.markets;

import java.time.LocalDateTime;
import com.lsports.trade360_java_sdk.common.entities.enums.*;

public class Bet {

    public long Id;

    public String Name;

    public String Line;

    public String BaseLine;

    public BetStatus Status;

    public String StartPrice;

    public String Price;

    public String PriceVolume;

    public SettlementType Settlement;

    public String ProviderBetId;

    public LocalDateTime LastUpdate;

    public String PriceIN;

    public String PriceUS;

    public String PriceUK;

    public String PriceMA;

    public String PriceHK;

    public int IsChanged = -1;

    public double Probability;

    public int ParticipantId;

    public String PlayerName;
}
