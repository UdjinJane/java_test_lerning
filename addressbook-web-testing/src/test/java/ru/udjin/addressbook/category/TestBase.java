package ru.udjin.addressbook.category;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class TestBase {
  protected WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.gecko.driver", "C:\\java\\java_code\\java_test_lerning\\addressbook-web-testing\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("http://localhost/addressbook/");
    loginForm("admin", "secret");

  }

  protected void loginForm(String username, String userpassword) {
    clearAndFillDatainForm(new FillDataField("user", username));
    clearAndFillDatainForm(new FillDataField("pass", userpassword));
    navigateByURL("//form[@id='LoginForm']/input[3]");
  }

  protected void clearAndFillDatainForm(FillDataField fillDataField) {
    driver.findElement(By.name(fillDataField.getGroup_name())).clear();
    driver.findElement(By.name(fillDataField.getGroup_name())).sendKeys(fillDataField.getTest4());
  }

  protected void clickToElemnt(String s) {
    driver.findElement(By.name(s)).click();
  }

  protected void navigateByURL(String s) {
    driver.findElement(By.xpath(s)).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
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
    driver.findElement(By.xpath(s)).click();
  }

  protected void selectCheckBox(String s) {
    findInputAndClckByXPASS(s);
  }

  protected void navigateAcrossLabelEllow(String labelUrlTxtLink) {
    driver.findElement(By.linkText(labelUrlTxtLink)).click();
  }
}
