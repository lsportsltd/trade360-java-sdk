package com.lsports.trade360_java_sdk.common.entities.outright;

import java.time.LocalDateTime;
import com.lsports.trade360_java_sdk.common.entities.enums.*;
import com.lsports.trade360_java_sdk.common.entities.fixtures.*;
import com.lsports.trade360_java_sdk.common.entities.shared.*;

public class OutrightFixture {

    public Sport Sport;

    public Location Location;

    public LocalDateTime StartDate;

    public LocalDateTime LastUpdate;

    public FixtureStatus Status;

    public Iterable<Participant> Participants;

    public Iterable<NameValuePair> FixtureExtraData;

    public String ExternalFixtureId;
}
