package ru.udjin.addressbook.category.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.udjin.addressbook.category.model.FillDataField;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
  private final GroupHelper groupHelper = new GroupHelper();
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  public void init() {
    System.setProperty("webdriver.gecko.driver", "C:\\java\\java_code\\java_test_lerning\\addressbook-web-testing\\geckodriver.exe");
    groupHelper.wd = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    groupHelper.wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    groupHelper.wd.get("http://localhost/addressbook/");
    loginForm("admin", "secret");
  }

  public void loginForm(String username, String userpassword) {
    groupHelper.clearAndFillDatainForm(new FillDataField("user", username));
    groupHelper.clearAndFillDatainForm(new FillDataField("pass", userpassword));
    navigateByURL("//form[@id='LoginForm']/input[3]");
  }

  public void navigateByURL(String s) {
    groupHelper.findInputAndClckByXPASS(s);
  }

  public void stop() {
    groupHelper.wd.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  public boolean isElementPresent(By by) {
    try {
      groupHelper.wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      groupHelper.wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public String closeAlertAndGetItsText() {
    try {
      Alert alert = groupHelper.wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }
}
