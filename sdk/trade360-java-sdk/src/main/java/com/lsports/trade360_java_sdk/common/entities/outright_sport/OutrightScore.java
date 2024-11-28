package com.lsports.trade360_java_sdk.common.entities.outright_sport;

import com.lsports.trade360_java_sdk.common.entities.enums.FixtureStatus;

/**
 * The {@code OutrightScore} class represents the score of an outright fixture.
 */
public class OutrightScore {

    /**
     * The results of the participants in the fixture.
     */
    public Iterable<OutrightParticipantResult> participantResults;

    /**
     * The status of the fixture.
     */
    public FixtureStatus status;
}