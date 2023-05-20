package grooming;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NotificationPopup {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		HashMap<String,Integer> content = new HashMap<>();
		content.put("geolocation", 1);
		content.put("notifications", 2);
		
		HashMap<String, Object> profile = new HashMap<>();
		profile.put("managed_default_content_settings", content);
		
		HashMap<String, Object> preference = new HashMap<>();
		preference.put("profile", profile);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preference);
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
	}

}
