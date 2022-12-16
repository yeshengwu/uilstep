package com.evan.uilstep;

public final class TapWater extends WaterSupply {
  public TapWater() {
    super(true);
  }

  public final void addChemicalCleaners() {
    setNeedsProcessing(false);
  }
}