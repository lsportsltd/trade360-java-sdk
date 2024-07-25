package com.lsports.trade360_java_sdk.common.entities.outright;

public class OutrightCompetition<TEvent> {

    public int Id;
    
    public String Name;
    
    public int Type;
    
    public Iterable<OutrightCompetition<TEvent>> Competitions;
    
    public Iterable<TEvent> Events;
}
