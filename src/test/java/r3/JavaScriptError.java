package r3;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v113.log.Log;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import java.util.Set;
import java.util.logging.Level;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;

public class JavaScriptError {

	public static void main(String[] args) {

		DevTools devTools;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//		devTools = ((ChromeDriver) driver).getDevTools();
//		devTools.createSession();
//		devTools.send(Log.enable());
//		devTools.addListener(Log.entryAdded(), logEntry -> {
//			System.out.println("Log Text: " + logEntry.getText());
//			System.out.println("Log Level: " + logEntry.getLevel());
//		});
		
		
		driver.get("https://www.youtube.com/watch?v=DpfjFn19AIg");
		//driver.get("https://apps.timeclockwizard.com/Login?subDomain=qcqae");
		  LogEntries jsErrors = driver.manage().logs().get(LogType.BROWSER);
		//  System.out.println(jsErrors.getAll());
		  
		  
//		  for(LogEntry entry : jsErrors) {
//			  System.out.println(entry.getMessage());
//		  }
		  
		  Set<String> logtyp = driver.manage().logs().getAvailableLogTypes();
	      for (String s : logtyp) {
	         System.out.println(logtyp);
	      }
	      
	      List<LogEntry> lg = jsErrors.getAll();
	      for(LogEntry logEntry : lg) {
	         System.out.println(logEntry);
	      }

//		  List<LogEntry> logs= jsErrors.getAll();
//		  
//		// Print one by one
//	        for(LogEntry e: logs)
//	        {
//	        	System.out.println(e);
//	        }
//	        
//	        // Printing details separately 
//	        for(LogEntry e: logs)
//	        {
//	        	System.out.println("Message is: " +e.getMessage());
//	        	System.out.println("Level is: " +e.getLevel());
//	        }
	}

}
