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
    
    driver.get("http://localhost:4200/login");
    driver.manage().window().maximize();
    Thread.sleep(3000);
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[1]/input")).sendKeys("maziz");
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/input")).sendKeys("Teksystems@2021");
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[3]/button")).click();
	try 
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("http://localhost:4200/home")));
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