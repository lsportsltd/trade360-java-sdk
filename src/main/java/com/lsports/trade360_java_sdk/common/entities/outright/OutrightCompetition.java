package com.lsports.trade360_java_sdk.common.entities.outright;

public class OutrightCompetition<TEvent> {

    public int id;
    
    public String name;
    
    public int type;
    
    public Iterable<OutrightCompetition<TEvent>> competitions;
    
    public Iterable<TEvent> events;
}
