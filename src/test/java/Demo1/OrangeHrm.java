package Demo1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import junit.framework.Assert;


public class OrangeHrm {
	
	 
	public WebDriver driver;
	public String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@BeforeTest
	public void setup() 
	{
		driver = new ChromeDriver();	
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test(priority = 2)
	public void loginValid()
	{
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")).click();
		
		 String title  = driver.getTitle();
		 Assert.assertEquals("OrangeHRM" , title);
		 
/*		if(title.equals("OrangeHRM"))
		{
			System.out.println("Successful");
		}  else {
			System.out.println("Not Successful");
		}
	
		 // Logout
		driver.findElement(By.cssSelector(".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon")).click();
		driver.findElement(By.xpath("(//a[@class=\"oxd-userdropdown-link\"])[4]")).click();
*/
	}
	
	
	@Test (priority = 1)
	public void loginInvalid()
	{
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("name");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("name123");
		driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")).click();
		
		System.out.println(driver.findElement(By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text")).getText());	
	}
	
	
	@Test (priority = 3)
	public void addEmp() {
		
		driver.findElement(By.xpath("//a[@href=\"/web/index.php/pim/viewPimModule\"]")).click();
		driver.findElement(By.xpath("(//a[@href=\"#\"])[2]")).click();
		driver.findElement(By.cssSelector(".oxd-input.oxd-input--active.orangehrm-firstname")).sendKeys("Anup");
		driver.findElement(By.cssSelector(".oxd-input.oxd-input--active.orangehrm-lastname")).sendKeys("Tarone");
		driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")).click();
	 
		// catch toast 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 WebElement toastContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='oxd-toaster_1'])[1]")));
		 System.out.println(driver.findElement(By.xpath("(//div[@id='oxd-toaster_1'])[1]")).getText());
		 
	}
	
	@Test (priority = 4)
	public void searchEmployee() {
		
	//	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));                                                          // Explicit Wait
	//	  WebElement element = wait.until(ExpectedConditions.elementToBeClickable( By.cssSelector("span[rel=\"tooltip\"]")  ));
		 
		
		driver.findElement(By.xpath("(//a[normalize-space()='Employee List'])[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active'])[1]")).sendKeys("ramu");
		 
		
		
	}
	
	  
	
	@AfterTest
	public void TearDown() throws InterruptedException
	{		
		Thread.sleep(3000);
		//driver.close();
		//driver.quit();		
	}
	
	

}




 