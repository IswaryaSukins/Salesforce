package learning.locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SalesforceGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		ChromeOptions option = new ChromeOptions();
	    option.addArguments("--disable-notificatons");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://login.salesforce.com/");
	    driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
	    driver.findElement(By.id("password")).sendKeys("August@2024");
	    driver.findElement(By.id("Login")).click();
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    driver.findElement(By.xpath("//button[text()='View All']")).click();
	    
	    Actions drop=new Actions(driver);
	    WebElement groupId = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
	    drop.moveToElement(groupId).click().perform();
	    
	    driver.findElement(By.xpath("//div[text()='New']")).click();
	    driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Salesforce Automation by Iswarya",Keys.ENTER);
	    driver.findElement(By.xpath("//button[text()='Save']")).click();
	    
	    String text = driver.findElement(By.xpath("(//lightning-formatted-text[@slot='primaryField'])[2]")).getText();
	    System.out.println(text);
	    
	    if(text.contains("Iswarya")) {
	    	System.out.println("verified");
	    }else {
	    	System.out.println("Not Verified");
	    	
	    
	    }
	}

}
