package configurations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class SeleniumBase {

    static WebDriver driver;
    static WebDriverWait wait;

    public void openBrowser(String URL)
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.navigate().to(URL);
        wait.until(ExpectedConditions.urlContains(URL));
    }

    public WebDriver getChromeDriver()
    {
        return driver;
    }

    public WebDriverWait getChromeDriverWait()
    {
        return wait;
    }


    public void closeBrowser()
    {
        driver.quit();
    }



  


}
