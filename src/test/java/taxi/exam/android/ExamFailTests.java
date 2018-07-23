package taxi.exam.android;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by prohorova on 19.07.2018.
 */
public class ExamFailTests extends TestBase{



  @Test
  public void testExamPass() {
    System.out.println("Starting Test ExamPass");
    Assert.assertEquals(driver.findElementById("welcomeTextView").getText(), "Добро пожаловать в Яндекс Такси");
    registerDriver(new DriverData("9001590102", "Famil", "Name", "MiddleName", "21041969", "app000191122", "21072011", "Moscow"));
    enterCode("123456");
    takePhotos();
    startProgram();
    failExam();


  }


 }
