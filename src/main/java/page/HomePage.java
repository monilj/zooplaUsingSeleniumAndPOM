package page;

import base.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class HomePage extends Base {

    @FindBy(css = "#search-input-location")
    private WebElement locationTextBox;

    @FindBy(css = "#search-submit")
    private WebElement searchButton;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String homePageTitle() {
        return driver.getTitle();
    }

    public SearchPage search(String location) throws InterruptedException {
        locationTextBox.sendKeys(location);
        locationTextBox.sendKeys(Keys.ENTER);
//        searchButton.click();
        Thread.sleep(1000);
        return new SearchPage();
    }
}
