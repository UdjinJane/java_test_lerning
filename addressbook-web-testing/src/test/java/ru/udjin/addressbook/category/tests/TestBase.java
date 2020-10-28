package ru.udjin.addressbook.category.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.udjin.addressbook.category.appmanager.ApplicationManager;

public class TestBase {

  protected final ApplicationManager app = new ApplicationManager(BrowserType.EDGE);

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    app.init();

  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    app.stop();
  }

  public ApplicationManager getApp() {
    return app;
  }
}
