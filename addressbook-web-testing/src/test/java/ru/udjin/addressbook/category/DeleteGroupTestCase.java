package ru.udjin.addressbook.category;

import org.testng.annotations.*;

public class DeleteGroupTestCase  extends TestBase {

  @Test
  public void testDeleteGroupTestCase() throws Exception {

    navigateByURL("//a[@href='group.php']");
    selectCheckBox("(//input[@name='selected[]'])[11]");
    selectCheckBox("(//input[@name='delete'])[2]");
    navigateByURL("//a[@href='group.php']");
  }


}
