package eu.lsports.trade360_java_sdk.common.entities.enums;

public enum RefundReason {
    NotSet(0),
    MarketSettlementRules(1),
    EventCancelled(2),
    EventAbandoned(3),
    PlayerNotPlayed(4),
    PlayerNotInLineUp(5),
    MinPeriodsNotReached(6),
    MinBallsNotReached(7),
    NonessentialMarket(8);

    private final int id;
    RefundReason(int id) { this.id = id; }
    public int getId() { return id; }
}
