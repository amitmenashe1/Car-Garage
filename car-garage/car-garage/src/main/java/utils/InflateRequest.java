package utils;

public class InflateRequest {
  private String licenseNumber;
  private int inflateAmount;

  public InflateRequest(String licenseNumber, int inflateAmount) {
    this.licenseNumber = licenseNumber;
    this.inflateAmount = inflateAmount;
  }

  public String GetLicenseNumber() {
    return this.licenseNumber;
  }

  public int GetInflateAmount() {
    return this.inflateAmount;
  }
}
