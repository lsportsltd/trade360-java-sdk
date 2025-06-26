package eu.lsports.trade360_java_sdk.common.models;

import java.time.LocalDateTime;

/**
 * The {@code MessageHeader} class represents the header of a message.
 */
public class MessageHeader {

    /**
     * The type of the message.
     */
    public int type;

    /**
     * The sequence number of the message.
     * This can be {@code null} if not set.
     */
    public Integer msgSeq;

    /**
     * The GUID of the message.
     * This can be {@code null} if not set.
     */
    public String msgGuid;

    /**
     * The creation date and time of the message in UTC.
     */
    public LocalDateTime creationDate;

    /**
     * The server timestamp of the message.
     */
    public long serverTimestamp;

    /***
     * A timestamp (ms, UTC) representing the exact time the message was pushed into the broker queue on the server side.
     */
    public long messageBroketTimestamp;
}