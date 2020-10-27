package ru.udjin.addressbook.category.appmanager;

import ru.udjin.addressbook.category.model.FillDataField;

public class SessionManager {
  protected final NavigationHelper navigationHelper = new NavigationHelper();

  public void loginForm(String username, String userpassword) {
    navigationHelper.groupHelper.clearAndFillDatainForm(new FillDataField("user", username));
    navigationHelper.groupHelper.clearAndFillDatainForm(new FillDataField("pass", userpassword));
    navigationHelper.navigateByURL("//form[@id='LoginForm']/input[3]");
  }
}
