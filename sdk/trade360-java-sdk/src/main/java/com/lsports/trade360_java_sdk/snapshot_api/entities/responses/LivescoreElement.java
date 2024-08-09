package com.lsports.trade360_java_sdk.snapshot_api.entities.responses;

import org.springframework.lang.Nullable;

import com.lsports.trade360_java_sdk.common.entities.livescore.Livescore;

public record LivescoreElement(int fixtureId, @Nullable Livescore livescore) {
}
