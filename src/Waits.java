import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\akotkar\\Downloads\\chromedriver_win32\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		
		/*
		Dynamic Waits
		
		Implicit wait 
		PageTimeOut
		Explicit waits 
		
		*/
		
		/*PageLoad Time out
		Page load time out is used for page loading and not by element 
		*/
		
		/*Implicit wait
		available  for all elements
		it is gloablly applied on driver
		Dynamic in nature
		wait can be changed anywhere by overloading the method */
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		WebElement firstname=driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
		
		WebElement forgot=driver.findElement(By.linkText("Forgotten account?"));
		
		sendkeysMethod(driver,firstname, 10, "Ankita");
		forgot(driver, forgot, 5);
		
		
	}
	
	
		/*Explicit Wait
	    Dynamic in nature
		No need to mention exlicit keyword
		We need to do by WebDriverWait class
		We need to use it by expected condition
		It is specific to element
		we should never use implicit wait and explicit wait together*/
		
	public static void sendkeysMethod(WebDriver driver, WebElement element, int timeout, String value) {
		
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	public static void forgot(WebDriver driver, WebElement element, int timeout) {
		
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

}
