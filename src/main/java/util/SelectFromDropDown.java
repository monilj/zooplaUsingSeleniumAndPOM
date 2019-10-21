package util;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectFromDropDown {

    public static void selectSingleOptionFromDropDown(WebElement dropDownTitle, String option){
        Select results = new Select(dropDownTitle);
        results.selectByVisibleText(option);

    }
}
