package eu.lsports.trade360_java_sdk.common.entities.markets;

import eu.lsports.trade360_java_sdk.common.entities.enums.BetStatus;
import eu.lsports.trade360_java_sdk.common.entities.enums.SettlementType;
import jakarta.annotation.Nullable;
import java.time.Instant;

public abstract class BaseBet {
    public long id;
    public String name;
    @Nullable public String line;
    @Nullable public String baseLine;
    public BetStatus status;
    @Nullable public String startPrice;
    @Nullable public String price;
    @Nullable public String priceVolume;
    @Nullable public SettlementType settlement;
    @Nullable public int SuspensionReason;
    @Nullable public Integer refundReason;
    public Instant lastUpdate;
    @Nullable public String priceIN;
    @Nullable public String priceUS;
    @Nullable public String priceUK;
    @Nullable public String priceMA;
    @Nullable public String priceHK;
    @Nullable public double probability;
    @Nullable public int participantId;
    @Nullable public int playerId;
    @Nullable public String playerName;
    @Nullable public int order;
    @Nullable public BetPredictionData predictionData;
}