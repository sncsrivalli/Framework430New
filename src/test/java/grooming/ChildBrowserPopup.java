package grooming;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChildBrowserPopup {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/search?q=headphones&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Boult Audio X60 ANC (30dB), Quad Mic ENC, 30 Hrs Batter...']")).click();
		
		String parentID = driver.getWindowHandle();
		Set<String> windowIDs = driver.getWindowHandles();
		
		for (String id : windowIDs) {
			driver.switchTo().window(id);
		}
		Thread.sleep(2000);
		String price = driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']")).getText();
		System.out.println(price);
		
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(parentID);
		driver.findElement(By.xpath("//div[text()='Price -- Low to High']")).click();
		driver.close();
	}

}
