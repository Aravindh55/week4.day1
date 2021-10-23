package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("(//ul[@class='shortcuts']//a)[4]")).click();
		driver.findElement(By.xpath("//img[@alt='Lookup'][1]")).click();
		Set<String> wh1 = driver.getWindowHandles();
		List<String> listwh1 = new ArrayList(wh1);
		driver.switchTo().window(listwh1.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-panel-body xedit-grid']//a)[23]")).click();
		driver.switchTo().window(listwh1.get(0));
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> wh2 = driver.getWindowHandles();
		List<String> listwh2 = new ArrayList<String>(wh2);
		driver.switchTo().window(listwh2.get(1));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-panel-body xedit-grid']//a)[28]")).click();
		driver.switchTo().window(listwh2.get(0));
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();
		if (title.contains("View Contact")) {
			System.out.println("page verified");
			
		}
		else {
			System.out.println("page not verified");
		}
		driver.quit();

	}

}
