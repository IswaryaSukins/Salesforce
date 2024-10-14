package learning.locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SalesforceEdit {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		ChromeOptions option = new ChromeOptions();
	    option.addArguments("--disable-notificatons");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get("https://login.salesforce.com/");
	    driver.findElement(By.id("username")).sendKeys("dilip@testleaf.com");
	    driver.findElement(By.id("password")).sendKeys("leaf@2024");
	    driver.findElement(By.id("Login")).click();
	    driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	    driver.findElement(By.xpath("//button[text()='View All']")).click();
	    driver.findElement(By.xpath("//p[text()='Sales']")).click();
	    WebElement oppur = driver.findElement(By.xpath("//span[text()='Opportunities']"));
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", oppur);
	    driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Salesforce Automation by Iswarya",Keys.ENTER);
	    Thread.sleep(3000);
	    
	    WebElement drop = driver.findElement(By.xpath("//a[contains(@class,'slds-button--icon-x-small')]"));
	    executor.executeScript("arguments[0].click();", drop);
	    
	    WebElement edit = driver.findElement(By.xpath("//li[@class='uiMenuItem']//a"));
	    executor.executeScript("arguments[0].click();", edit);
	    
	    driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
	    driver.findElement(By.xpath("//span[text()='10']")).click();
	    Thread.sleep(3000);
	   
	    driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("//span[@title='Perception Analysis']")).click();
		
		WebElement dd2 = driver.findElement(By.xpath("(//button[@class='slds-combobox_input slds-input_faux fix-slds-input_faux slds-combobox_input-value'])[4]"));
		executor.executeScript("arguments[0].click();",dd2);
		
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("SalesForce");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String stage = driver.findElement(By.xpath("//span[text()='Perception Analysis']")).getText();
		if(stage.contains("Perception Analysis")) {
			System.out.println("Perception verified");
		}else {
			System.out.println("Perception not verified");
	    
	}
}
}
