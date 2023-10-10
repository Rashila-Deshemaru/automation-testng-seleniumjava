package testscenarios;

import PageElements.computer_edit;
import PageElements.computer_new;
import PageElements.launch_first;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.utility;

public class testcases {
    static utility util = new utility();
    static WebDriver driver = util.CreateWebDriver();

    computer_edit editPage = new computer_edit(driver);
    computer_new addPage = new computer_new(driver);
    launch_first launchPage = new launch_first(driver);

    @BeforeTest
    public void setup(){
        driver.manage().window().maximize();
        driver.get("https://computer-database.gatling.io/computers");
    }

    @Test(priority = 1)
    public void Computeredit(){
       editPage.editComputer();
    }

    @Test(priority = 2)
    public void Computeraddinvalidname(){
        addPage.addComputer("", "2020-02-22", "2022-02-11", "Sony");
    }

    @Test(priority = 3)
    public void Computeraddwrongintrodate(){
        addPage.addComputer("aceee", "2020-02-yy", "2022-02-11", "Sony");
    }

    @Test(priority = 4)
    public void Computeraddwrongdisdate(){
        addPage.addComputer("aceee", "2020-02-11", "02-11-2020", "Sony");
    }

    @Test(priority = 5)
    public void Computeraddinvaliddisdate(){
        addPage.addComputer("aceee", "2023-02-12", "2000-02-11", "Sony");
    }

    @Test(priority = 6)
    public void Computeraddvalid(){
        addPage.addComputer("sony11ee", "2020-02-22", "2022-02-11", "Sony");
    }
    @Test(priority = 7)
    public void Computerdelete(){
        editPage.deleteComputer();
    }
    @Test(priority = 8)
    public void Computersearch(){
        launchPage.searchComputer("test");
    }
    @AfterTest
    public void teardown(){
        driver.quit();
    }

}
