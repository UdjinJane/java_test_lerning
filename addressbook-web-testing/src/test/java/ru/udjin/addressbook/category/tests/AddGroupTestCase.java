package ru.udjin.addressbook.category.tests;

import org.testng.annotations.*;
import ru.udjin.addressbook.category.model.FillDataField;

public class AddGroupTestCase extends TestBase {

  @Test
  public void testUntitledTestCase() throws Exception {

    app.navigateByURL("//a[@href='group.php']");
    app.clickToElemnt("new");
    app.clickToElemnt("group_name");
    app.clearAndFillDatainForm(new FillDataField("group_name", "test4"));
    app.clickToElemnt("group_header");
    app.clearAndFillDatainForm(new FillDataField("group_header", "test4"));
    app.clickToElemnt("group_footer");
    app.clearAndFillDatainForm(new FillDataField("group_footer", "test4"));
    app.clickToElemnt("submit");
    app.navigateAcrossLabelEllow("group page");
  }

}
