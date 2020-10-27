package ru.udjin.addressbook.category.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.udjin.addressbook.category.model.FillDataField;

public class GroupHelper {
  FirefoxDriver wd;

  public void clearAndFillDatainForm(FillDataField fillDataField) {
    wd.findElement(By.name(fillDataField.getGroup_name())).clear();
    wd.findElement(By.name(fillDataField.getGroup_name())).sendKeys(fillDataField.getTest4());
  }

  public void clickToElemnt(String s) {
    wd.findElement(By.name(s)).click();
  }

  public void findInputAndClckByXPASS(String s) {
    wd.findElement(By.xpath(s)).click();
  }

  public void selectCheckBox(String s) {
    findInputAndClckByXPASS(s);
  }

  public void navigateAcrossLabelEllow(String labelUrlTxtLink) {
    wd.findElement(By.linkText(labelUrlTxtLink)).click();
  }
}
