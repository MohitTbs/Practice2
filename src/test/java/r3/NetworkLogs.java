package r3;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NetworkLogs {

	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeOptions options = new ChromeOptions();
		LoggingPreferences logPrefs = new LoggingPreferences();
		logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		options.setCapability("goog:loggingPrefs", logPrefs);
		// WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://apps.timeclockwizard.com/Login?subDomain=qcqae");
		driver.findElement(By.cssSelector("#UserName")).sendKeys("sa");
		driver.findElement(By.cssSelector("#Password")).sendKeys("123456");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[value='LogIn']")).click();

		String Partialpath = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\";
		FileWriter writer = new FileWriter(new File(Partialpath + "writtenfile.txt"));

		StringBuffer sb = new StringBuffer();

		List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
		System.out.println(entries.size() + " " + LogType.PERFORMANCE + " log entries found");
		for (LogEntry entry : entries) {
			// System.out.println(entry.getMessage());
			sb.append(entry.getMessage().toString());
			sb.append("\n");
		}

		String str = sb.toString();
		writer.write(str);
		System.out.println("File Written");

	}

}
