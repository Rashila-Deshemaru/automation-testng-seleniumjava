package PageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class computer_new {
    WebDriver driver;

    private By addbtn = By.id("add");
    private By computername = By.xpath("//input[@id='name']");
    private By introdate = By.id("introduced");
    private By discontdate = By.id("discontinued");
    private By companyoptions = By.id("company");
    private By submitbtn = By.xpath("//input[@value='Create this computer']");
//    private By alertmsg = By.xpath("//div[@class='alert-message warning']");

    private By errormsg = By.xpath("//span[@class='help-inline']");

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
            System.out.println("empty name error");
            String error = driver.findElement(this.errormsg).getText();
            System.out.println(error);
        }

        // Check for the correct date format for introducedDate and discontinuedDate
        if (!isValidDateFormat(introducedDate)) {
            System.out.println("intro date error");
            String error = driver.findElement(this.errormsg).getText();
            System.out.println(error);
        }

        if (!isValidDateFormat(discontinuedDate)) {
            System.out.println("discontinue date error");
            String error = driver.findElement(this.errormsg).getText();
            System.out.println(error);
        }

        // Check if discontinuedDate is before introducedDate
        LocalDate introDate = LocalDate.parse(introducedDate, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate discontDate = LocalDate.parse(discontinuedDate, DateTimeFormatter.ISO_LOCAL_DATE);

        if (discontDate.isBefore(introDate)) {
            System.out.println("discontinue date is before intro date");
            String error = driver.findElement(this.errormsg).getText();
            System.out.println(error);
        }


        driver.findElement(this.submitbtn).click();
//        String successAlert = driver.findElement(this.alertmsg).getText();
//        System.out.println("Success message: " + successAlert);
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
