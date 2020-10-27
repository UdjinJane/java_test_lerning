package ru.udjin.addressbook.category.appmanager;

public class NavigationHelper {
  // тут был Final, его нужно убрать
  protected GroupHelper groupHelper;

  public void navigateByURL(String s) {
    groupHelper.findInputAndClckByXPASS(s);
  }
}
