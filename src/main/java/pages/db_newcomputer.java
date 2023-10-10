package pages;

import PageElements.computer_new;
import org.openqa.selenium.WebDriver;
import utilities.utility;

public class db_newcomputer {
    static utility util = new utility();
    static WebDriver driver = util.CreateWebDriver();
    static computer_new cn = new computer_new(driver);

    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.get("https://computer-database.gatling.io/computers");
        cn.addComputer("", "2020-02-22", "2022-02-11", "Sony");
        cn.addComputer("Sony11e", "yyy", "2022-02-11", "Sony");
        cn.addComputer("Sony11e", "2022-02-11", "yyy", "Sony");
        cn.addComputer("Sony113", "2022-02-22", "2020-02-11", "Sony");
        cn.addComputer("mac", "2020-01-11", "2023-01-11", "Apple Inc.");

    }
}
