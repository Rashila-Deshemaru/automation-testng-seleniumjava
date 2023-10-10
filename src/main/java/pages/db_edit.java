package pages;

import PageElements.computer_edit;
import org.openqa.selenium.WebDriver;
import utilities.utility;

public class db_edit {
    static utility util = new utility();

    static WebDriver driver = util.CreateWebDriver();

    static computer_edit ed = new computer_edit(driver);

    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.get("https://computer-database.gatling.io/computers");

        ed.editComputer();
        ed.deleteComputer();

    }

}
