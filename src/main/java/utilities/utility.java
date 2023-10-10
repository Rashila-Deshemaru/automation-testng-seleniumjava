package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class utility {
     WebDriver driver;
    private static final Logger log = LogManager.getLogger(utility.class);
    public WebDriver CreateWebDriver()
    {
        driver = new ChromeDriver();
        return driver;
    }
    public void loginfo(String infos) {
        log.info(infos);
    }

    public void logerror(String error) {
        log.error(error);
    }

}
