package ru.udjin.addressbook.category.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {

  private final SessionHelper sessionHelper = new SessionHelper();
  WebDriver wd;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private String browser;

  public ApplicationManager(String browser) {

    this.browser = browser;
  }

  public void init() {


    if (browser.equals(BrowserType.FIREFOX)) {
      // Это тоже вариант. Если не в корне проекта запускающие браузер файлы.
      // System.setProperty("webdriver.gecko.driver", "C:\\java\\java_code\\java_test_lerning\\addressbook-web-testing\\geckodriver.exe");
      wd = new FirefoxDriver();
    } else if (browser.equals(BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (browser.equals(BrowserType.EDGE)) {
      wd = new EdgeDriver();
    } else if (browser.equals(BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    } else if (browser.equals(BrowserType.OPERA)) {
      wd = new OperaDriver();
    }



    baseUrl = "https://www.google.com/";
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    sessionHelper.navigationHelper.groupHelper = new GroupHelper(wd);
    sessionHelper.loginForm("admin", "secret");
  }

  public void stop() {
    wd.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public String closeAlertAndGetItsText() {
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

  public GroupHelper getGroupHelper() {
    return sessionHelper.navigationHelper.groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return sessionHelper.navigationHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
}
