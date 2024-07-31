package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Plogin {
    WebDriver driver;
    
    // Find Locators
    By username = By.xpath("//input[@name='username']");
    By password = By.xpath("//input[@type='password']");
    By loginBtn = By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button");
    
    // Constructor
    public Plogin(WebDriver d) {
        driver = d;
    }
    
    // For actions
    public void applicationLogin(String name, String pass) {
        driver.findElement(username).sendKeys(name);
        driver.findElement(password).sendKeys(pass);    
        driver.findElement(loginBtn).click();
    }
}
