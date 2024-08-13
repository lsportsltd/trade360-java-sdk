package com.lsports.trade360feedexample.prematch;

import com.lsports.trade360_java_sdk.common.entities.messagetypes.SettlementUpdate;
import com.lsports.trade360_java_sdk.feed.rabbitmq.interfaces.EntityHandling;

public class SettlementUpdateHandlerPrematch implements EntityHandling<SettlementUpdate> {
    @Override
    public void Process(SettlementUpdate entity) {

    }

    @Override
    public int GetEntityKey() {
        return 0;
    }
}
