package seleniumPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleRadioButton {

	@Test
	public void RadioButtonTestCase() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtalks.com/"); // navigate
		
		String radioToBeSelected = "No";

		//first way--> not to be prefered
//		if(radioToBeSelected.equals("Yes")) {
//			driver.findElement(By.xpath("//*[text()='Yes']")).click();  // click on YES radio button
//		} else if(radioToBeSelected.equals("No")) {
//			driver.findElement(By.xpath("//*[text()='No']")).click();  // click on YES radio button
//		}
		
		//second ways -- by writting dynamic xpath
//		driver.findElement(By.xpath("//*[text()='"+radioToBeSelected+"']")).click();
		
		//third way --> using list and iterate on it.
		List<WebElement> radioList = driver.findElements(By.xpath("//input[@name='Right Hand Drive']/parent::label"));
		
		System.out.println("number of items in radioList: "+radioList.size());
		
		//how to retrive webElements from List???
	//	String str1 = radioList.get(0).getAttribute("value");   //return first webElement
	//	String str2 = radioList.get(1).getAttribute("value");   //return second webElement
	
		//iterate on List
		for(int i = 0; i< radioList.size(); i++) {
			if(radioList.get(i).getText().equals(radioToBeSelected)){
				radioList.get(i).click();
			}
		}
	}

}
