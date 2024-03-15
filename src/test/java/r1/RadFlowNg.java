package r1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class RadFlowNg {

	@Test
	public void test1() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		NgWebDriver ngWebDriver = new NgWebDriver(jse);
		ngWebDriver.waitForAngularRequestsToFinish();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait  = new WebDriverWait(driver,Duration.ofSeconds(15));
		driver.get("https://staging-precise.radflow360.com/login");
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("tbs.chiragk@gmail.com");
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Test@1234");
		driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
		// ngWebDriver.waitForAngularRequestsToFinish();
		driver.findElement(By.xpath("//span[@class='link_name' and text() = 'REFERRERS']/..")).click();
		// ngWebDriver.waitForAngularRequestsToFinish();
		try {
			driver.findElement(By.xpath("(//a[@data-target='#ReferrerDetailWindow'])[1]")).click();
		} catch (Exception e) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//a[@data-target='#ReferrerDetailWindow'])[1]")).click();
		}
		//ngWebDriver.withRootSelector("root-app").waitForAngularRequestsToFinish();
		//ngWebDriver.waitForAngularRequestsToFinish();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("loader"))));
		driver.findElement(By.xpath("(//a[text()='Contact Details'])[1]")).click();
		
		
	}
}
