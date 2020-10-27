package ru.udjin.addressbook.category;

import org.testng.annotations.*;

public class DeleteGroupTestCase  extends TestBase {

  @Test
  public void testDeleteGroupTestCase() throws Exception {

    app.navigateByURL("//a[@href='group.php']");
    app.selectCheckBox("(//input[@name='selected[]'])[11]");
    app.selectCheckBox("(//input[@name='delete'])[2]");
    app.navigateByURL("//a[@href='group.php']");
  }


}
