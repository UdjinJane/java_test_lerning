package ru.udjin.addressbook.category;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
  FirefoxDriver wd;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  protected void init() {
    System.setProperty("webdriver.gecko.driver", "C:\\java\\java_code\\java_test_lerning\\addressbook-web-testing\\geckodriver.exe");
    wd = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    loginForm("admin", "secret");
  }

  protected void loginForm(String username, String userpassword) {
    clearAndFillDatainForm(new FillDataField("user", username));
    clearAndFillDatainForm(new FillDataField("pass", userpassword));
    navigateByURL("//form[@id='LoginForm']/input[3]");
  }

  protected void clearAndFillDatainForm(FillDataField fillDataField) {
    wd.findElement(By.name(fillDataField.getGroup_name())).clear();
    wd.findElement(By.name(fillDataField.getGroup_name())).sendKeys(fillDataField.getTest4());
  }

  protected void clickToElemnt(String s) {
    wd.findElement(By.name(s)).click();
  }

  protected void navigateByURL(String s) {
    wd.findElement(By.xpath(s)).click();
  }

  protected void stop() {
    wd.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = wd.switchTo().alert();
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

  protected void findInputAndClckByXPASS(String s) {
    wd.findElement(By.xpath(s)).click();
  }

  protected void selectCheckBox(String s) {
    findInputAndClckByXPASS(s);
  }

  protected void navigateAcrossLabelEllow(String labelUrlTxtLink) {
    wd.findElement(By.linkText(labelUrlTxtLink)).click();
  }
}
