package hardcodedTests;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateEventTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(driver.getTitle().contains("vtiger"))
			System.out.println("Login page displayed");
		else
			System.out.println("Login page not found");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();
		
		if(driver.getTitle().contains("Home"))
			System.out.println("Home page is displayed");
		else
			System.out.println("Home page not found");
		
		WebElement quickCreateDD = driver.findElement(By.id("qccombo"));
		Select s = new Select(quickCreateDD);
		s.selectByValue("Events");
		
		String createToDo = driver.findElement(By.xpath("//b[text()='Create To Do']")).getText();
		if(createToDo.equals("Create To Do"))
			System.out.println("Create Event Page Displayed");
		else
			System.out.println("Create Event Page not Displayed");
		
		driver.findElement(By.name("subject")).sendKeys("Event1");
		driver.findElement(By.xpath("//img[@id='jscal_trigger_date_start']")).click();
		
		int reqDate = 18;
		int reqMonth = 6;
		int reqYear = 2026;
		
		String calendarHeader = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
		String[] str = calendarHeader.split(" ");
		
		int actYear = Integer.parseInt(str[1]);
		
		while(actYear < reqYear) {
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='»']")).click();
			calendarHeader = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			str = calendarHeader.split(", ");
			
			actYear = Integer.parseInt(str[1]);	
		}
		
		int actMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
		
		while(actMonth < reqMonth) {
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='›']")).click();
			calendarHeader = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			str = calendarHeader.split(", ");
			actMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
		}
		
		while(actMonth > reqMonth) {
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='‹']")).click();
			calendarHeader = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			str = calendarHeader.split(", ");
			actMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
		}
		
		driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='"+reqDate+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@id='jscal_trigger_due_date']")).click();
		
		int reqDate2 = 28;
		int reqMonth2 = 6;
		int reqYear2 = 2026;
		String calendarHeader2 = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
		String[] str2 = calendarHeader2.split(" ");
		
		int actYear2 = Integer.parseInt(str2[1]);
		
		while(actYear2 < reqYear2) {
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='»']")).click();
			calendarHeader2 = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			str2 = calendarHeader2.split(", ");
			
			actYear2 = Integer.parseInt(str2[1]);	
		}
		
		int actMonth2 = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str[0]).get(ChronoField.MONTH_OF_YEAR);
		
		while(actMonth2 < reqMonth2) {
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='›']")).click();
			calendarHeader2 = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			str2 = calendarHeader2.split(", ");
			actMonth2 = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str2[0]).get(ChronoField.MONTH_OF_YEAR);
		}
		
		while(actMonth2 > reqMonth2) {
			driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='‹']")).click();
			calendarHeader2 = driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[@class='title']")).getText();
			str2 = calendarHeader2.split(", ");
			actMonth2 = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(str2[0]).get(ChronoField.MONTH_OF_YEAR);
		}
		
		driver.findElement(By.xpath("//div[@class='calendar' and contains(@style,'block')]/descendant::td[text()='"+reqDate2+"']")).click();
		
		
	}

}
