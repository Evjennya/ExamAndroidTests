package taxi.exam.android;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PassExamTests extends TestBase {

  @Test
  public void testExamPass() {
    System.out.println("Starting Test ExamPass");
    Assert.assertEquals(driver.findElementById("welcomeTextView").getText(), "Добро пожаловать в Яндекс Такси");
    registerDriver(new DriverData("9001234050","Famil", "Name", "MiddleName", "27111979", "app000111112", "20092010", "Moscow"));
    enterCode("123456");
    takePhotos();
    startProgram();
    passExam();


  }


}
