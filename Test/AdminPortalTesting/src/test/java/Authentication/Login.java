package Authentication;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class Login {
  @Test
  public void LoginTest() throws InterruptedException {
    
	  System.setProperty("webdriver.chrome.driver", "C:\\testtools\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
    
    driver.get("http://localhost:4201");
    driver.manage().window().maximize();
    Thread.sleep(3000);
    
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 driver.findElement(By.name("inputUserName")).sendKeys("admin");
	 Thread.sleep(2000);
	  driver.findElement(By.name("password")).sendKeys("12345");
	  Thread.sleep(2000);
	  //Login Button
	  driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/button")).click();
	  String actualUrl="http://localhost:4201/user-account";
	  String expectedUrl= driver.getCurrentUrl();
	  if(actualUrl.equalsIgnoreCase(expectedUrl)) {
	  System.out.println("Login Successful"); }
	  driver.manage().window().maximize();

	try 
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("http://localhost:4201/user-account")));
		System.out.println("Login Successfull");

//		driver.findElement(By.xpath("/html/body/app-root/nav/ul/li[5]/div/a[2]")).click();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-login/div/form/h3")));
//		System.out.println("Signed Out");
	}
	catch(Exception e) 
	{
		System.out.println("Error in browser!!\nPlease have a look");
	}
	
    Thread.sleep(5000);  
    driver.quit();
  } 
}