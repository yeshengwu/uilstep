package com.evan.uilstep;

import kotlin.jvm.internal.Intrinsics;

public final class Aquarium<T extends WaterSupply> {
    private final T waterSupply;

    public Aquarium(T waterSupply) {
        Intrinsics.checkParameterIsNotNull(waterSupply, "waterSupply");
        this.waterSupply = waterSupply;
    }

    public final T getWaterSupply() {
        return this.waterSupply;
    }

    public final void addWater() {
        if (!this.waterSupply.getNeedsProcessing()) {
            System.out.println((Object) ("adding water from " + this.waterSupply));
            return;
        }
        throw new IllegalStateException("water supply needs processing first".toString());
    }
}