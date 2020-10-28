package ru.udjin.addressbook.category.tests;

import org.testng.annotations.*;
import ru.udjin.addressbook.category.model.FillDataField;

public class DeleteGroupTestCase  extends TestBase {

  @Test
  public void testDeleteGroupTestCase() throws Exception {

    app.getNavigationHelper().navigateByURL("//a[@href='group.php']");

    if (!app.getGroupHelper().isThereAGroup()) {
      app.getNavigationHelper().navigateByURL("//a[@href='group.php']");
      app.getGroupHelper().clickToElemnt("new");
      app.getGroupHelper().clickToElemnt("group_name");
      app.getGroupHelper().clearAndFillDatainForm(new FillDataField("group_name", "test5"));
      app.getGroupHelper().clickToElemnt("group_header");
      app.getGroupHelper().clearAndFillDatainForm(new FillDataField("group_header", "test4"));
      app.getGroupHelper().clickToElemnt("group_footer");
      app.getGroupHelper().clearAndFillDatainForm(new FillDataField("group_footer", "test4"));
      app.getGroupHelper().clickToElemnt("submit");
      app.getGroupHelper().navigateAcrossLabelEllow("group page");
    }
    app.getGroupHelper().selectCheckBox("(//input[@name='selected[]'])[11]");
    app.getGroupHelper().selectCheckBox("(//input[@name='delete'])[2]");
    app.getNavigationHelper().navigateByURL("//a[@href='group.php']");
  }


}
