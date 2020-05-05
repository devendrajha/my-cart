package io.smartnexus.ats.utils;

public class PostJsonToken {
  private String username;
  private String grant_type;
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getGrant_type() {
    return grant_type;
  }

  public void setGrant_type(String grant_type) {
    this.grant_type = grant_type;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "PostJsonToken [username = " + username + ", grant_type = " + grant_type + ", password = " + password + "]";
  }
}