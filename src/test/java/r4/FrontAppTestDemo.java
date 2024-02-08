package r4;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrontAppTestDemo {

	@Test
	public void test1() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://front.com/");
		WebElement frontAppSignInBtn = driver.findElement(By.xpath("(//a[text()='Sign In'])[1]"));
		frontAppSignInBtn.click();
		WebElement frontAppEmailField = driver.findElement(By.cssSelector("#email-login"));
		frontAppEmailField.sendKeys("vikram@technobrains.io");
		WebElement frontAppPassField = driver.findElement(By.cssSelector("#password-login"));
		frontAppPassField.sendKeys("Vikram@123");
		WebElement frontAppLoginSubmitBtn = driver.findElement(By.cssSelector("[type='submit']"));
		frontAppLoginSubmitBtn.click();
		Thread.sleep(5000);
		WebElement Pi_BillingTab = driver.findElement(
				By.xpath("(//div[contains(@class,'tooltipOverflowCondition') and text()='PI - Billing'])[2]"));
		Pi_BillingTab.click();
		Thread.sleep(5000);

		// Selecting the mail from the inbox
		List<WebElement> mailSubjectList = driver
				.findElements(By.xpath("//div[contains(@class,'cellMiddle__StyledSubject')]/span"));
		for (WebElement e : mailSubjectList) {
			String subText = e.getText();
			if (subText.contains("TestDemo")) {
				e.click();
				break;
			}
		}

		Thread.sleep(2000);

		WebElement pluginBtn;

		// Clicking on the Plugin

		pluginBtn = driver.findElement(By.xpath("//div[contains(@class,'entryPointSwitcherItem__') and text() = 'D']"));
		pluginBtn.click();
		Thread.sleep(10000);
		String frontAppMailPage = driver.getWindowHandle();

		// Clicking on the Send Mail to
		WebElement pluginFrame = driver.findElement(By.xpath("//iframe[@title='Dev ENV Plugin']"));
		driver.switchTo().frame(pluginFrame);
		WebElement senFilesTo360Btn = driver.findElement(By.id("sendlien"));
		senFilesTo360Btn.click();

		Thread.sleep(20000);

		Set<String> windowHandles2 = driver.getWindowHandles();
		String uploadReplyFrontPage;

		// Switching to  uploadReplyFrontPage
		
		for (String singleWindow : windowHandles2) {

			if (!singleWindow.equalsIgnoreCase(frontAppMailPage)) {
				uploadReplyFrontPage = singleWindow;
				driver.switchTo().window(singleWindow);
			}
		}

		WebElement fileNameCheckbox = driver.findElement(By.xpath("//input[@class='label-info check-box pointer']"));
		fileNameCheckbox.click();
		Thread.sleep(2000);

		WebElement uploadAndReplyLiensBtn = driver.findElement(By.cssSelector("#sendliensdemo"));
		uploadAndReplyLiensBtn.click();

		//// Now Deleting the Mail from Front App
/*
		driver.switchTo().window(frontAppMailPage);
		
		WebElement threeDotsMenu = driver.findElement(By.xpath("//div[contains(@class,'messageViewerMore_')]/div/div/div/div"));
		threeDotsMenu.click();
		Thread.sleep(2000);
		WebElement DeleteMailBtn = driver.findElement(By.xpath("//div[contains(@class,'dropdownItemContent') and text() = 'Delete']"));
		DeleteMailBtn.click();
		Thread.sleep(2000);
		WebElement deleteConfirmBtn = driver.findElement(By.xpath("//div[text() = 'Delete conversation']"));
		deleteConfirmBtn.click();
*/
	}

}
