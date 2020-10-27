package ru.udjin.addressbook.category;

import org.testng.annotations.*;
import org.openqa.selenium.*;

public class AddGroupTestCase extends TestBase {

  @Test
  public void testUntitledTestCase() throws Exception {

    navigateByURL("//a[@href='group.php']");
    clickToElemnt("new");
    clickToElemnt("group_name");
    clearAndFillDatainForm(new FillDataField("group_name", "test4"));
    clickToElemnt("group_header");
    clearAndFillDatainForm(new FillDataField("group_header", "test4"));
    clickToElemnt("group_footer");
    clearAndFillDatainForm(new FillDataField("group_footer", "test4"));
    clickToElemnt("submit");
    driver.findElement(By.linkText("group page")).click();
  }

}
