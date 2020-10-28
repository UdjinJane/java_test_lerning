package ru.udjin.addressbook.category.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import ru.udjin.addressbook.category.appmanager.ApplicationManager;

public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(BrowserType.EDGE);

  @BeforeSuite(alwaysRun = true)
  public void setUp() throws Exception {
   //  app.stop();
    app.init();

  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

  public ApplicationManager getApp() {
    return app;
  }
}
