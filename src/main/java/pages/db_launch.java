package pages;

import PageElements.launch_first;
import org.openqa.selenium.WebDriver;
import utilities.utility;

public class db_launch {

    static utility util = new utility();
    static WebDriver driver = util.CreateWebDriver();

    static  launch_first lf = new launch_first(driver);


    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.get("https://computer-database.gatling.io/computers");
        lf.searchComputer("test");
    }

}
