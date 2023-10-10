package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utility {
     WebDriver driver;

    public WebDriver CreateWebDriver()
    {
        driver = new ChromeDriver();
        return driver;
    }

}
