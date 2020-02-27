package seleniumPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomateLoginPage {

	@Test
	public void TestCase1() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://qdpm.net/demo/v9/index.php"); // navigate
		
		WebElement emailBox = driver.findElement(By.name("login[email]"));
		emailBox.sendKeys("administrator@localhost.com");
		
		driver.findElement(By.name("login[password]")).sendKeys("administrator");
		
		driver.findElement(By.xpath("//button[text()='Login ']")).click();  // click on login button
		
		//verify page title
		String expectedPageTitle = "qdPM | Dashboard1";
		
		String actualPageTitle = driver.getTitle();

//		if(expectedPageTitle.equals(actualPageTitle)) {
//			System.out.println("test passed");
//		} else {
//			System.out.println("Test failed");
//		}
		
		//TestNG --> Assert is used for comparison
		
		Assert.assertEquals(actualPageTitle, expectedPageTitle);
		
	}

}
