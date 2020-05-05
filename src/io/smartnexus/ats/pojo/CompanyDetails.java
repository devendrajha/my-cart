package io.smartnexus.ats.pojo;

import java.util.List;

public class CompanyDetails {
  private String Name;
  private String CUID;
  private String Status;
  private String CompanyId;
  private String Description;
  private String Url;
  private String LogoUrl;
  private List<Options> Options;
  private String EnvironmentUrl;
  private String CompanyEmail;

  public String getName() {
    return Name;
  }

  public void setName(String Name) {
    this.Name = Name;
  }

  public String getCUID() {
    return CUID;
  }

  public void setCUID(String CUID) {
    this.CUID = CUID;
  }

  public String getDescription() {
    return Description;
  }

  public void setDescription(String Description) {
    this.Description = Description;
  }

  public String getUrl() {
    return Url;
  }

  public void setUrl(String Url) {
    this.Url = Url;
  }

  public String getLogoUrl() {
    return LogoUrl;
  }

  public String getStatus() {
    return Status;
  }

  public void setLogoUrl(String LogoUrl) {
    this.LogoUrl = LogoUrl;
  }

  public List<Options> getOptions() {
    return Options;
  }

  public void setOptions(List<Options> Options) {
    this.Options = Options;
  }

  public String getEnvironmentUrl() {
    return EnvironmentUrl;
  }

  public void setEnvironmentUrl(String EnvironmentUrl) {
    this.EnvironmentUrl = EnvironmentUrl;
  }

  public String getCompanyId() {
    return CompanyId;
  }

  public void setCompanyId(String companyId) {
    CompanyId = companyId;
  }

  public String getCompanyEmail() {
    return CompanyEmail;
  }

  public void setCompanyEmail(String companyEmail) {
    CompanyEmail = companyEmail;
  }

  public void setStatus(String status) {
    Status = status;
  }

  @Override
  public String toString() {
    return "CompanyDetails [Name=" + Name + ", CUID=" + CUID + ", Status=" + Status + ", CompanyId=" + CompanyId + ", Description=" + Description + ", Url="
        + Url + ", LogoUrl=" + LogoUrl + ", Options=" + Options + ", EnvironmentUrl=" + EnvironmentUrl + ", CompanyEmail=" + CompanyEmail + "]";
  }

}
