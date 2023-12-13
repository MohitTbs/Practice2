package r2;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

public class RadflowError {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.BROWSER, Level.ALL);
		options.setCapability(options.LOGGING_PREFS, logPrefs);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.get("https://testkru.com/TestUrls/TestConsoleLogs");
		driver.get("https://staging-precise.radflow360.com/login");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("tbs.chiragk@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("Test@1234");
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		Thread.sleep(10000);
		LogEntries entry = driver.manage().logs().get(LogType.BROWSER);

		// Retrieving all logs
		List<LogEntry> logs = entry.getAll();

		// Printing details separately
		int cc =0;
		for (LogEntry e : logs) {
			if (e.getLevel().toString().equals("SEVERE")) {
//				System.out.println("Message: " + e.getMessage());
//				System.out.println("Level: " + e.getLevel());
//				System.out.println("Timestamp: " + e.getTimestamp());
				cc++;
			}
			
			
		}
		System.out.println("Total Errors: "+cc);
	}

}
