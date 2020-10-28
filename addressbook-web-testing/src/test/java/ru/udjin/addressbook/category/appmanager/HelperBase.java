package ru.udjin.addressbook.category.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.udjin.addressbook.category.model.FillDataField;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void clearDataField(FillDataField fillDataField) {
    wd.findElement(By.name(fillDataField.getGroup_name())).clear();
  }

  public void clickToElemnt(String s) {
    wd.findElement(By.name(s)).click();
  }
}
