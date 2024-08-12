package com.lsports.trade360_java_sdk.common.entities.enums;

public enum MessageType {
    FixtureMetadataUpdate(1),
    LivescoreUpdate(2),
    MarketUpdate(3),
    KeepAliveUpdate(31),
    HeartbeatUpdate(32),
    SettlementUpdate(35);

    private int value;

    MessageType(int value) {
        this.value = value;
    }
    public void setValue(int value) { this.value = value;}

    public int getValue() { return this.value; }

    public static MessageType finMessageType(int typeId) throws ClassNotFoundException {
        for(MessageType v : values()){
            if( v.value == typeId){
                return v;
            }
        }
        return null;
    }
}
