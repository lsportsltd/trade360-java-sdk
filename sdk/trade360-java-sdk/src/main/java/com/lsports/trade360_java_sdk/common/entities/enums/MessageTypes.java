package com.lsports.trade360_java_sdk.common.entities.enums;

public enum MessageTypes {
    FixtureMetadataUpdate(1),
    LivescoreUpdate(2),
    MarketUpdate(3),
    KeepAliveUpdate(31),
    HeartbeatUpdate(32),
    SettlementUpdate(35);

    private int value;

    MessageTypes(int value) {
        this.value = value;
    }
    public void setValue(int value) { this.value = value;}

    public int getValue() { return this.value; }

    public static MessageTypes finMessageType(int typeId){
        for(MessageTypes v : values()){
            if( v.value == typeId){
                return v;
            }
        }
        return null;
    }
}
