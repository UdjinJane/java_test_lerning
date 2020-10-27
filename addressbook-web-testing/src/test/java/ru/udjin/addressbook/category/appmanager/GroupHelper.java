package ru.udjin.addressbook.category.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.udjin.addressbook.category.model.FillDataField;

public class GroupHelper extends HelperBase{

  public GroupHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void clearAndFillDatainForm(FillDataField fillDataField) {
    clearDataField(fillDataField);
    sendKeyAndFillDataToField(fillDataField);
  }

  private void sendKeyAndFillDataToField(FillDataField fillDataField) {
    wd.findElement(By.name(fillDataField.getGroup_name())).sendKeys(fillDataField.getTest4());
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
