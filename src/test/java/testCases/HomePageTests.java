package testCases;

import base.Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.HomePage;

public class HomePageTests extends Base {
    HomePage homePage;
    public HomePageTests(){
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
