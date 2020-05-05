package io.smartnexus.ats.packages;

public class PackageGroup {
  private String name;
  private String description;
  private String hardwareVersion;
  private String imageId;
  private String typeId;
  private String type;
  private String version;
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public String getImageId() {
    return imageId;
  }
  public void setImageId(String imageId) {
    this.imageId = imageId;
  }
  public String getTypeId() {
    return typeId;
  }
  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }
  public String getVersion() {
    return version;
  }
  public void setVersion(String version) {
    this.version = version;
  }
  public String getHardwareVersion() {
    return hardwareVersion;
  }
  public void setHardwareVersion(String hardwareVersion) {
    this.hardwareVersion = hardwareVersion;
  }
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

}
