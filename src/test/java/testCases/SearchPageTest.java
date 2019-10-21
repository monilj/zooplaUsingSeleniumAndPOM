package testCases;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.PropertyPage;
import page.SearchPage;

import java.util.ArrayList;
import java.util.Collections;

public class SearchPageTest extends Base {
    HomePage homePage;
    SearchPage searchPage;
    PropertyPage propertyPage;
    String cityName="London";
    int nthCheapestProperty=4;

    public SearchPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        homePage= new HomePage();
        searchPage= homePage.search(cityName);
    }

    @Test
    public void testHeader(){
        String pageHeader =searchPage.getPageHeader();
        Assert.assertTrue(pageHeader.contains(cityName));
    }

    @Test
    public void testFilter() throws InterruptedException {
        ArrayList<Integer> flatPricesBeforeFilter=searchPage.getPrices();
        ArrayList<Integer> flatPricesAfterFilter=searchPage.getFilteredPrices();
        Collections.sort(flatPricesBeforeFilter);
        Assert.assertTrue(flatPricesBeforeFilter.equals(flatPricesAfterFilter));
    }

    @Test
    public void propertyCheck(){
        propertyPage=searchPage.getCheapestProperty(nthCheapestProperty);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
