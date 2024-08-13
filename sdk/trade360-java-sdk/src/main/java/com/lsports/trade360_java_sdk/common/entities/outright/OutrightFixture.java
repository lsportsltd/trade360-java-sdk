package com.lsports.trade360_java_sdk.common.entities.outright;

import java.time.LocalDateTime;
import com.lsports.trade360_java_sdk.common.entities.enums.*;
import com.lsports.trade360_java_sdk.common.entities.fixtures.*;
import com.lsports.trade360_java_sdk.common.entities.shared.*;

public class OutrightFixture {

    public Sport sport;

    public Location location;

    public LocalDateTime startDate;

    public LocalDateTime lastUpdate;

    public FixtureStatus status;

    public Iterable<Participant> participants;

    public Iterable<NameValuePair> ExtraData;

    public Subscription Subscription;
}
