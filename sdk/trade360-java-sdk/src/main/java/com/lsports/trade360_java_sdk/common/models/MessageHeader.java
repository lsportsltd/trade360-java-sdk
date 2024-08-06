package com.lsports.trade360_java_sdk.common.models;

import java.time.LocalDateTime;

public class MessageHeader {

    public int type;
    public Integer msgSeq;
    public String msgGuid;
    public LocalDateTime creationDate;
    public long serverTimestamp;
}
