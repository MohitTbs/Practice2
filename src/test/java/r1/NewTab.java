package r1;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTab {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qavbox.github.io/demo/shadowDOM/");
		String firstWindow = driver.getWindowHandle();
		// driver.switchTo().newWindow(WindowType.TAB);
		// driver.switchTo().newWindow(WindowType.WINDOW);
		((JavascriptExecutor) driver).executeScript("window.open('https://google.com')");

		// driver.get("https://apps.timeclockwizard.com/Timesheet");
		// String secondWindow = driver.getWindowHandle();

		// System.out.println(firstWindow+" --------- "+secondWindow);

		Set<String> multipleWimdows = driver.getWindowHandles();
		for (String e : multipleWimdows) {
			if (!e.equals(firstWindow)) {
				driver.switchTo().window(e);
			}
		}
		
		System.out.println("Parent: "+ firstWindow);
		System.out.println("Another: "+ driver.getWindowHandle());
	}

}
