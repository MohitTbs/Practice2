package r3;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;

public class ConsoleLog2 {

	public static void main(String[] args) {
		 ChromeOptions options = new ChromeOptions();
	        LoggingPreferences logPrefs = new LoggingPreferences();
	        logPrefs.enable(LogType.BROWSER, Level.ALL);
	        options.setCapability(options.LOGGING_PREFS, logPrefs);
	         
	        WebDriver driver = new ChromeDriver(options);
	       // driver.get("https://testkru.com/TestUrls/TestConsoleLogs");
	        driver.get("https://rahulshettyacademy.com/blog/index.php/2021/11/04/selenium-4-feature-chrome-dev-tools-protocol/");
	        LogEntries entry = driver.manage().logs().get(LogType.BROWSER);
	 
	        // Retrieving all logs  
	        List<LogEntry> logs = entry.getAll();
	 
	        // Printing details separately
	        for (LogEntry e : logs) {
	            System.out.println("Message: " + e.getMessage());
	            System.out.println("Level: " + e.getLevel());
	            System.out.println("Timestamp: "+ e.getTimestamp());
	        }
	}

}
