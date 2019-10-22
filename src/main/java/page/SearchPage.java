package page;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import util.SelectFromDropDown;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends Base {


    @FindBy(css = "div>div>h1")
    private WebElement headerOfThePage;

    @FindAll({@FindBy(css = ".listing-results-right.clearfix>a.listing-results-price")})
    private List<WebElement> propertyRate;

//    @FindBy(name = "results_sort")
//    private WebElement dropDownTitle;
    @FindAll({@FindBy(css = "select.js-redirects-to-option.js-check.js-touched")})
    private List<WebElement> dropDownLists;

    public SearchPage() {
        PageFactory.initElements(driver, this);
    }


    public ArrayList<Integer> getFilteredPrices() throws InterruptedException {
        WebElement dropDownForFilter= dropDownLists.get(1);
        System.out.printf(dropDownForFilter.getTagName());
        SelectFromDropDown.selectSingleOptionFromDropDown(dropDownForFilter,"Lowest price");
        Thread.sleep(2000);
        ArrayList<Integer> pricesAfterSorting=getPrices();
        return pricesAfterSorting;
    }

    public ArrayList<Integer> getPrices() {
        ArrayList<Integer> flatPrices = new ArrayList<Integer>();
        for (WebElement ele : propertyRate) {
            String price = ele.getText();
            price = price.replaceAll("[^\\d.]", "");
            System.out.println(price);
            int priceAfterRemovingNonDigitsChar = Integer.parseInt(price);
            flatPrices.add(priceAfterRemovingNonDigitsChar);
        }
        return flatPrices;
    }

    public String getPageHeader() {
        return headerOfThePage.getText();
    }

    public PropertyPage getCheapestProperty(int nthCheapestProperty) {
        propertyRate.get(nthCheapestProperty).click();
        return new PropertyPage();

    }
}
