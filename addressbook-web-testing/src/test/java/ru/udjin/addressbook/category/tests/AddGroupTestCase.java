package ru.udjin.addressbook.category.tests;

import org.testng.annotations.*;
import ru.udjin.addressbook.category.model.FillDataField;

public class AddGroupTestCase extends TestBase {

  @Test
  public void testUntitledTestCase() throws Exception {

    app.getNavigationHelper().navigateByURL("//a[@href='group.php']");
    app.getGroupHelper().clickToElemnt("new");
    app.getGroupHelper().clickToElemnt("group_name");
    app.getGroupHelper().clearAndFillDatainForm(new FillDataField("group_name", "test4"));
    app.getGroupHelper().clickToElemnt("group_header");
    app.getGroupHelper().clearAndFillDatainForm(new FillDataField("group_header", "test4"));
    app.getGroupHelper().clickToElemnt("group_footer");
    app.getGroupHelper().clearAndFillDatainForm(new FillDataField("group_footer", "test4"));
    app.getGroupHelper().clickToElemnt("submit");
    app.getGroupHelper().navigateAcrossLabelEllow("group page");
  }

}
