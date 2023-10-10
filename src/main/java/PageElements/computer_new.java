package PageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.utility;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class computer_new {
    WebDriver driver;
    static utility util = new utility();
    private By addbtn = By.id("add");
    private By computername = By.xpath("//input[@id='name']");
    private By introdate = By.id("introduced");
    private By discontdate = By.id("discontinued");
    private By companyoptions = By.id("company");
    private By submitbtn = By.xpath("//input[@value='Create this computer']");
    private By alertmsg = By.xpath("//div[@class='alert-message warning']");

    private By goback = By.xpath("//a[@class='fill' and text()='Computer database']");


    public void addComputer(String computerName, String introducedDate, String discontinuedDate, String companyName) {

        driver.findElement(this.addbtn).click();

        driver.findElement(this.computername).sendKeys(computerName);
        driver.findElement(this.introdate).sendKeys(introducedDate);
        driver.findElement(this.discontdate).sendKeys(discontinuedDate);

        WebElement selectElement = driver.findElement(this.companyoptions);
        Select select = new Select(selectElement);
        select.selectByVisibleText(companyName);

        // Check for an empty computer name
        if (computerName.isEmpty()) {
            util.logerror("Name field should not be empty");
            driver.findElement(this.goback).click();
            return;
        }

        // Check for the correct date format for introducedDate and discontinuedDate
        if (!isValidDateFormat(introducedDate)) {
            util.logerror("Invalid date format for Introduction date");
            driver.findElement(this.goback).click();
            return;
        }

        if (!isValidDateFormat(discontinuedDate)) {
            util.logerror("Invalid date format for Discontinue date");
            driver.findElement(this.goback).click();
            return;
        }

        // Check if discontinuedDate is before introducedDate
        LocalDate introDate = LocalDate.parse(introducedDate, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate discontDate = LocalDate.parse(discontinuedDate, DateTimeFormatter.ISO_LOCAL_DATE);

        if (discontDate.isBefore(introDate)) {
            util.logerror("Discontinue date is before Introduction date");
            driver.findElement(this.goback).click();
            return;
        }


        driver.findElement(this.submitbtn).click();
        String successAlert = driver.findElement(this.alertmsg).getText();
        util.loginfo("Successfully added new computer");
        System.out.println(successAlert);
    }

    public computer_new(WebDriver driver) {
        this.driver = driver;
    }

    private boolean isValidDateFormat(String date) {
        // Define the expected date format using a regular expression
        String dateFormatRegex = "\\d{4}-\\d{2}-\\d{2}";

        // Check if the provided date matches the expected format
        return date.matches(dateFormatRegex);
    }
}
