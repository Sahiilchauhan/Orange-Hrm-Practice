package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pdashboard {
    WebDriver driver;
    
    // Locators
    By icon = By.xpath("//a[@href='/web/index.php/pim/viewMyDetails']");
    By show = By.xpath("(//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title'])[1]");
    
    // Constructor
    public Pdashboard(WebDriver d) {
        driver = d;
    }
    
    // Methods
    public void ClickMyInfo() {
        driver.findElement(icon).click();
        System.out.println(driver.findElement(show).getText());
    }
}
