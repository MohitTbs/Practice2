package r2;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableChromeAutomatedInfobar {

	public static void main(String[] args) {

		ChromeOptions op = new ChromeOptions();
		op.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking","enable-automation"));
		//op.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking")); -- This will disable all the popup windows
		//op.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation")); -- This will disable the info bar saying chrome is being automated by software
		WebDriver driver = new ChromeDriver(op); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("http://omayo.blogspot.com/");

	}

}
