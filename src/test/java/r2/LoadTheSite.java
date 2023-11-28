package r2;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoadTheSite {

	WebDriver driver;

	static ThreadLocal<Method> td = new ThreadLocal<>();

	//@Test
	public void getTheTest() {
		driver = new ChromeDriver();
		// JavascriptExecutor jse = (JavascriptExecutor) driver;
		// NgWebDriver ngWebDriver = new NgWebDriver(jse);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.gina.com/en/flats");
		for (int i = 0; i < 10; i++)

			driver.switchTo().newWindow(WindowType.TAB).get("https://www.gina.com/en/flats");
	}

	public static void getUrl() throws IOException {

		URL url = new URL("https://www.gina.com/en/flats");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		//Object scs = connection.getContent();
		//System.out.println(scs.toString());
		System.out.println("Hi");

	}

	public static void main(String[] args) throws IOException {

		for (int k = 0; k < 10; k++)
			getUrl();
	}
	
	@Test
	public void getTheTest1() {
		driver = new ChromeDriver();
		// JavascriptExecutor jse = (JavascriptExecutor) driver;
		// NgWebDriver ngWebDriver = new NgWebDriver(jse);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.gina.com/en/flats");
		
	}
}
