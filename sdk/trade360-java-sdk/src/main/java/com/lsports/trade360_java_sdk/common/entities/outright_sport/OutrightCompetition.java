package com.lsports.trade360_java_sdk.common.entities.outright_sport;

public class OutrightCompetition<T> {

    public int id;
    
    public String name;
    
    public int type;
    
    public Iterable<OutrightCompetition<T>> competitions;
    
    public Iterable<T> events;
}
