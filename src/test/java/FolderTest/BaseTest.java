package FolderTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<>();

    //Before (Open browser, additional)
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();

        //Getter dan setter untuk bukan browser dan url
        driver.set(new FirefoxDriver(options));
        driver.get().manage().window().maximize();//Maximize window
        driver.get().get("https://demoblaze.com/");
        explicitWait.set(new WebDriverWait((driver.get()), Duration.ofSeconds((120))));
    }

    //After (Close browser)
    @AfterMethod
    public void closeBrowser() {
        driver.get().quit();
    }
}
