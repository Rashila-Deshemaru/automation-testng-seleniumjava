package PageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class computer_edit {
    WebDriver driver;

    private By singlecomp = By.xpath("//a[text()='ACE']");
    private By computername = By.xpath("//input[@id='name']");
    private By introdate = By.id("introduced");
    private By discontdate = By.id("discontinued");
    private By companyoptions = By.id("company");
    private By submitbtn = By.xpath("//input[@value='Save this computer']");
    private By alertmsg = By.xpath("//div[@class='alert-message warning']");
    private By deletebtn = By.xpath("//input[@value='Delete this computer']");

    public void editComputer(){
        driver.findElement(this.singlecomp).click();
        driver.findElement(this.computername).sendKeys("ACE12");
        driver.findElement(this.introdate).sendKeys("2020-03-21");
        driver.findElement(this.discontdate).sendKeys("2023-01-11");
        WebElement selectElement = driver.findElement(this.companyoptions);
        Select select = new Select(selectElement);
        select.selectByVisibleText("Apple Inc.");
        driver.findElement(this.submitbtn).click();
        String successAlert = driver.findElement(this.alertmsg).getText();
        System.out.println("Success message: " + successAlert);
    }

    public void deleteComputer(){
        driver.findElement(this.singlecomp).click();
        driver.findElement(this.deletebtn).click();
        String successAlert = driver.findElement(this.alertmsg).getText();
        System.out.println("Success message: " + successAlert);
    }

    public computer_edit(WebDriver driver) {
        this.driver = driver;
    }
}
