package io.smartnexus.ats.groups;

public class AddProductsToOTA {
  private String cuId;

  private String deviceIds;

  public String getCuId() {
    return cuId;
  }

  public void setCuId(String cuId) {
    this.cuId = cuId;
  }

  public String getDeviceIds() {
    return deviceIds;
  }

  public void setDeviceIds(String deviceIds) {
    this.deviceIds = deviceIds;
  }

  @Override
  public String toString() {
    return "AddProductsToOTA [cuId  = " + cuId + ", deviceIds = " + deviceIds + "]";
  }
}
