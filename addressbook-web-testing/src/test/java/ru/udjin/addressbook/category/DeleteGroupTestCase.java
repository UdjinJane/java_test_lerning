package ru.udjin.addressbook.category;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DeleteGroupTestCase  extends TestBase {


  @Test
  public void testDeleteGroupTestCase() throws Exception {

    navigateByURL("//a[@href='group.php']");
    selectCheckBox("(//input[@name='selected[]'])[11]");
    fineInputAndClckByXPASS("(//input[@name='delete'])[2]");
    navigateByURL("//a[@href='group.php']");
  }

  private void fineInputAndClckByXPASS(String s) {
    driver.findElement(By.xpath(s)).click();
  }

  private void selectCheckBox(String s) {
    fineInputAndClckByXPASS(s);
  }


}
