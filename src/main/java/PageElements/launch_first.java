package PageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.utility;

public class launch_first {
    WebDriver driver;
    static utility util = new utility();
    private By searchbox = By.id("searchbox");
    private By submitbtn = By.id("searchsubmit");
    private By searchresult = By.xpath("//*[@id=\"main\"]/h1");

    public void searchComputer(String searchkeyword){
        driver.findElement(this.searchbox).sendKeys(searchkeyword);
        driver.findElement(this.submitbtn).click();
        String searchresultout = driver.findElement(this.searchresult).getText();
        util.loginfo("Getting search result");
        System.out.println("Search result: " + searchresultout);

        WebElement table = driver.findElement(By.className("computers"));

        java.util.List<WebElement> computerNameElements = table.findElements(By.xpath("//tbody/tr/td/a"));

        util.loginfo("Listing Computer Names");
        for (WebElement computerNameElement : computerNameElements) {
            String computerName = computerNameElement.getText();
            System.out.println("Computer Name: " + computerName);
        }
    }

    public launch_first(WebDriver driver){
        this.driver = driver;
    }
}
