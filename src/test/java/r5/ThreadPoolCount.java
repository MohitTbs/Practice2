package r5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ThreadPoolCount {
	
	// This will invoke the test case three times parallelly
	
	@Test(invocationCount = 3, threadPoolSize = 3)
	public void testInvocationCount() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://apps.timeclockwizard.com/Login?Subdomain=qcqae");
		driver.close();
	}

}
