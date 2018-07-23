package taxi.exam.android;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class TestBase {


  AppiumDriver<MobileElement> driver;

  @BeforeTest
  public void setup() {
    System.out.println("Starting BeforeTest");
    DesiredCapabilities cap = new DesiredCapabilities();
    cap.setCapability("platformName", "Android");
    cap.setCapability("deviceName", "Lenovo TB3-X70L");
    cap.setCapability("autoGrantPermissions", "true");
    cap.setCapability("app", "/Users/prohorova/Desktop/Apk/TaxiExam/Dev/YTaxiExam-v0.33.18-4-62ea577-feature_exam_questions-dirty-debug.apk");
    cap.setCapability("appActivity", "com.voltmobi.ytaxiexam.ui.activity.bootstrap.BootstrapActivity");
    cap.setCapability("appWaitActivity", "com.voltmobi.ytaxiexam.ui.activity.activation.ActivationActivity");
    try {
      driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    System.out.println("Driver is created");
    insertKey("c13b7a4824274e69a4856b63006db643");
    System.out.println("End od BeforeTest");
  }


  public void insertKey(String key) {
    System.out.println("insert key method");
    driver.findElementById("activationEditText").sendKeys(key);
    driver.findElementById("activationButton").click();
  }

  public void registerDriver(DriverData driverData) {
    System.out.println("Start register driver");
    driver.findElementById("continueButton").click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElementById("input").sendKeys(driverData.getNumber());;
    driver.findElementById("loginButton").click();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElementById("lastNameEditText").sendKeys(driverData.getFamil());
    driver.findElementById("firstNameEditText").sendKeys(driverData.getName());
    driver.findElementById("middleNameEditText").sendKeys(driverData.getMiddleName());
    driver.findElementById("birthdayEditText").sendKeys(driverData.getBirthday());
    driver.findElementById("driverLicenseEditText").sendKeys(driverData.getDrivLicense());
    driver.findElementById("driverLicenseDateEditText").sendKeys(driverData.getLicenseDate());
    submitRegistration();
    driver.findElementById("docRegistrationAddressEditText").sendKeys(driverData.getAddress());
    submitRegistration();
    System.out.println("End of registration");
  }

  public void startProgram() {
    MobileElement program = driver.findElementByXPath("//*[@text='Автотест']");
    program.click();
  }

  public void takePhotos() {
    //while (driver.findElementById("takePhotoButton").isExist()) {}
    System.out.println("Start taking photos");
    MobileElement photoBut = driver.findElementById("takePhotoButton");
    photoBut.click();
    MobileElement nextBut = driver.findElementById("continueButton");
    nextBut.click();



    photoBut.click();
    nextBut.click();

    photoBut.click();
    nextBut.click();
  }

  public void enterCode(String code) {
    System.out.println("Enter pin");
    driver.findElementById("pincodeEditText").sendKeys(code);
    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void submitRegistration() {
    driver.findElementById("registerButton").click();
  }

  public void passExam() {
    System.out.println("Start answer questions method");
//1
    selectAnswer(0);
    selectAnswer(1);
    driver.findElementById("nextQuestionButton").click();
//2
    selectAnswer(0);
    selectAnswer(1);
    selectAnswer(2);
    driver.findElementById("nextQuestionButton").click();
//3
    selectAnswer(0);
    selectAnswer(1);
    driver.findElementById("nextQuestionButton").click();
    //4
    selectAnswer(0);
    selectAnswer(1);
    selectAnswer(2);
    driver.findElementById("nextQuestionButton").click();
//5
    driver.findElementById("answerTextView").click();
    driver.findElementById("nextQuestionButton").click();
//6
    driver.findElementById("answerTextView").click();
    driver.findElementById("nextQuestionButton").click();
//7
    selectAnswer(0);
    selectAnswer(1);
    selectAnswer(2);
    driver.findElementById("nextQuestionButton").click();
//8
    driver.findElementById("answerTextView").click();
    driver.findElementById("nextQuestionButton").click();
//9
    driver.findElementById("answerTextView").click();
    driver.findElementById("nextQuestionButton").click();
//10
    driver.findElementById("answerTextView").click();
    driver.findElementById("nextQuestionButton").click();
  }

  public void failExam() {
    System.out.println("Start fail answer questions method");
//1
    selectAnswer(2);
    driver.findElementById("nextQuestionButton").click();
//2
    selectAnswer(0);
    selectAnswer(3);
    driver.findElementById("nextQuestionButton").click();
//3
    selectAnswer(2);
    driver.findElementById("nextQuestionButton").click();
    //4
    selectAnswer(3);
    driver.findElementById("nextQuestionButton").click();
//5
    selectAnswer(2);
    driver.findElementById("nextQuestionButton").click();
//6
    selectAnswer(2);
    driver.findElementById("nextQuestionButton").click();
//7
    selectAnswer(0);
    selectAnswer(3);
    driver.findElementById("nextQuestionButton").click();
//8
    selectAnswer(1);
    driver.findElementById("nextQuestionButton").click();
//9
    selectAnswer(2);
    driver.findElementById("nextQuestionButton").click();
//10
    selectAnswer(1);
    driver.findElementById("nextQuestionButton").click();
  }

  public void selectAnswer(int index) {
    driver.findElementsById("answerTextView").get(index).click();

  }

  @AfterTest
  public void tearDown() {
    System.out.println("AfterTest");
    driver.quit();
  }
}
