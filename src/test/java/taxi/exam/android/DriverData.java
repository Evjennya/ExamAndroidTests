package taxi.exam.android;

public class DriverData {
  private final String number;
  private final String famil;
  private final String name;
  private final String middleName;
  private final String birthday;
  private final String drivLicense;
  private final String licenseDate;
  private final String address;

  public DriverData(String number, String famil, String name, String middleName, String birthday, String drivLicense, String licenseDate, String address) {
    this.number = number;
    this.famil = famil;
    this.name = name;
    this.middleName = middleName;
    this.birthday = birthday;
    this.drivLicense = drivLicense;
    this.licenseDate = licenseDate;
    this.address = address;
  }

  public String getNumber() { return number; }

  public String getFamil() {
    return famil;
  }

  public String getName() {
    return name;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getBirthday() {
    return birthday;
  }

  public String getDrivLicense() {
    return drivLicense;
  }

  public String getLicenseDate() {
    return licenseDate;
  }

  public String getAddress() {
    return address;
  }
}
