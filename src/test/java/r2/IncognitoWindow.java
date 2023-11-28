package r2;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IncognitoWindow {

	public static void main(String[] args) {

		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		
		//op.addArguments("--incognito","--start-maximized"); -- Passing arguments as varArgs
		//op.addArguments(Arrays.asList("--incognito","--start-maximized")); -- using Arrays.asList
		
		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("http://omayo.blogspot.com/");
	}

}
