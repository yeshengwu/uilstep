package com.evan.uilstep;

public class WaterSupply {

  private boolean needsProcessing;

  public WaterSupply(boolean needsProcessing) {
    this.needsProcessing = needsProcessing;
  }

  public final boolean getNeedsProcessing() {
    return this.needsProcessing;
  }

  public final void setNeedsProcessing(boolean z) {
    this.needsProcessing = z;
  }
}
