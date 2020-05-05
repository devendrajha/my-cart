package io.smartnexus.ats.groups;

public class OTAgroups {
  private String Name;
  private String PackageType;
  private String packageGroupId;
  private boolean ForceUpdate;
  private String StartTime;
  private String EndTime;
  private DayOfWeek DayOfWeek;
  public String getName() {
    return Name;
  }
  public void setName(String name) {
    Name = name;
  }
  public String getPackageType() {
    return PackageType;
  }
  public void setPackageType(String packageType) {
    PackageType = packageType;
  }
  public String getPackageGroupId() {
    return packageGroupId;
  }
  public void setPackageGroupId(String packageGroupId) {
    this.packageGroupId = packageGroupId;
  }
  public boolean getForceUpdate() {
    return ForceUpdate;
  }
  public void setForceUpdate(boolean forceUpdate) {
    ForceUpdate = forceUpdate;
  }
  
  public String getStartTime() {
    return StartTime;
  }
  public void setStartTime(String startTime) {
    StartTime = startTime;
  }
  public String getEndTime() {
    return EndTime;
  }
  public void setEndTime(String endTime) {
    EndTime = endTime;
  }
  public DayOfWeek getDayOfWeek() {
    return DayOfWeek;
  }
  public void setDayOfWeek(DayOfWeek dayOfWeek) {
    DayOfWeek = dayOfWeek;
  }
    
}