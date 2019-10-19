package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import util.WebEventListener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public static WebDriver driver;
    public static Properties properties;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public Base() {
        try {
            properties = new Properties();
            FileInputStream propertyReader = new FileInputStream("$project.buildDir/src/main/java/config/config.properties");
            properties.load(propertyReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = properties.getProperty("browser");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        browserOperations();
        e_driver=new EventFiringWebDriver(driver);
        eventListener= new WebEventListener();
        e_driver.register(eventListener);
        driver=e_driver;
    }

    private static void browserOperations() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(properties.getProperty("url"));
    }

}
