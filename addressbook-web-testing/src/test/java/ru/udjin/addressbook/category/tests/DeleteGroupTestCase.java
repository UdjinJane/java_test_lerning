package ru.udjin.addressbook.category.tests;

import org.testng.annotations.*;

public class DeleteGroupTestCase  extends TestBase {

  @Test
  public void testDeleteGroupTestCase() throws Exception {

    app.getNavigationHelper().navigateByURL("//a[@href='group.php']");
    app.getGroupHelper().selectCheckBox("(//input[@name='selected[]'])[11]");
    app.getGroupHelper().selectCheckBox("(//input[@name='delete'])[2]");
    app.getNavigationHelper().navigateByURL("//a[@href='group.php']");
  }


}
