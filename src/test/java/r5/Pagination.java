package r5;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Pagination {

	public WebDriver driver;
	WebDriverWait wait1;

	@BeforeTest
	public void Setup() throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		Actions action = new Actions(driver);
		wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		driver.get("https://staging-precise.radflow360.com/attorney-portal");

		Thread.sleep(3000);

		WebElement emailtxt = driver.findElement(By.xpath("//input[@type='email']"));

		// emailtxt.sendkeys("tbs.mohitk@gmail.com");
		emailtxt.sendKeys("tbs.mohitk@gmail.com");

		WebElement passordtxt = driver.findElement(By.xpath("//input[@type='password']"));
		passordtxt.sendKeys("Test@1234");

		WebElement loginbtn = driver.findElement(By.xpath("//div[@class='form-btn']//button"));
		loginbtn.click();

		// Thread.sleep(3000);
		wait1.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='ldio-vrezsu839x loader']")));

	}

	@Test
	public void pagination() throws InterruptedException {

		WebElement link_MakepaymentBtn = driver
				.findElement(By.xpath("(//app-attorney-list//div//a[@class='f-bigCount'])[4]"));
		link_MakepaymentBtn.click();

		Thread.sleep(3000);

		Actions act = new Actions(driver);
		WebElement nextPageBtn = driver.findElement(By.xpath("(//li[contains(@class,'pagination-next')])[1]"));

		List<WebElement> patientIds = null;
		boolean flag1 = nextPageBtn.getAttribute("class").contains("disable");
		while (!flag1) {
			Thread.sleep(4500);
			try {
				patientIds = driver.findElements(By.xpath(
						"//div[@class=\"attroneyGrid-table\"]//div[@class=\"dx-datagrid-content\"]//tr[contains(@class,'dx-data-row')]//td[3]"));
				for (WebElement e : patientIds) {
					System.out.println(e.getText());
				}
			} catch (StaleElementReferenceException e) {
				patientIds = driver.findElements(By.xpath(
						"//div[@class=\"attroneyGrid-table\"]//div[@class=\"dx-datagrid-content\"]//tr[contains(@class,'dx-data-row')]//td[3]"));
				for (WebElement e1 : patientIds) {
					System.out.println(e1.getText());
				}
			}

			nextPageBtn = driver.findElement(By.xpath("(//li[contains(@class,'pagination-next')])[1]"));
			boolean flag = nextPageBtn.getAttribute("class").contains("disable");
			flag1 = flag;
			if (!flag) {
				act.moveToElement(nextPageBtn).click().build().perform();
			}
		}
	}

}
