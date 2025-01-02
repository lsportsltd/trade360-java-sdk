package eu.lsports.trade360_java_sdk.common.entities.outright_sport;

import eu.lsports.trade360_java_sdk.common.entities.shared.NameValuePair;
import jakarta.annotation.Nullable;

/**
 * The {@code OutrightParticipant} class represents a participant in an outright fixture.
 */
public class OutrightParticipant {

    /**
     * The ID of the participant.
     */
    public int id;

    /**
     * The name of the participant.
     * This can be {@code null} if not set.
     */
    @Nullable
    public String name;

    /**
     * The position of the participant.
     * This can be {@code null} if not set.
     */
    @Nullable public String position;

    /**
     * The rotation ID of the participant.
     * This can be {@code null} if not set.
     */
    @Nullable public Integer rotationId;

    /**
     * Indicates whether the participant is active.
     * {@code -1} represents unknown value.
     */
    public int isActive = -1;


    /**
     * Extra data associated with the participant.
     * This can be {@code null} if not set.
     */
    @Nullable public Iterable<NameValuePair> extraData;
}