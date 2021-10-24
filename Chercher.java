package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chercher {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("(//div[@class='row']//iframe)[1]"));
		driver.switchTo().frame(element);
		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Not a friendly topic");
		WebElement element2 = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(element2);
		driver.findElement(By.id("a")).click();
		driver.switchTo().defaultContent();
		WebElement element3 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(element3);
		WebElement webElement = driver.findElement(By.id("animals"));
		Select dropDown=new Select(webElement);
		dropDown.selectByIndex(2);
		
		
	
	}

}
