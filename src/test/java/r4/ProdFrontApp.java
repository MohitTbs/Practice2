package r4;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ProdFrontApp {

	@Test(/*invocationCount = 15*/)
	public void test1() throws InterruptedException {

		
		
		ChromeDriver driver = new ChromeDriver();
		
		Map coordinates = Map.of(
                "latitude", 20.3079823,
                "longitude", -97.893803,
                "accuracy", 1
        );
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://front.com/");
		WebElement frontAppSignInBtn = driver.findElement(By.xpath("(//a[text()='Sign In'])[1]"));
		frontAppSignInBtn.click();

		/*
		 * WebElement frontAppEmailField =
		 * driver.findElement(By.cssSelector("#email-login"));
		 * frontAppEmailField.sendKeys("vikram@technobrains.io"); WebElement
		 * frontAppPassField = driver.findElement(By.cssSelector("#password-login"));
		 * frontAppPassField.sendKeys("Vikram@123"); WebElement frontAppLoginSubmitBtn =
		 * driver.findElement(By.cssSelector("[type='submit']"));
		 * frontAppLoginSubmitBtn.click(); Thread.sleep(5000);
		 */

		WebElement signInWithGoogleBtn = driver.findElement(By.xpath("//button[text()='Sign in with Google']"));
		signInWithGoogleBtn.click();

		WebElement emailTextBox = driver.findElement(By.xpath("//input[@type='email']"));
		emailTextBox.sendKeys("dev@technobrains.io");

		WebElement nextButton1 = driver.findElement(By.id("identifierNext"));
		nextButton1.click();
		Thread.sleep(6000);

		WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
		passwordField.sendKeys("TechTBS#@^%*&*0147");

		WebElement nextBtn2 = driver.findElement(By.xpath("//span[text() = 'Next']"));
		nextBtn2.click();
		Thread.sleep(10000);
/*
		WebElement sharedInboxesLink = driver
				.findElement(By.xpath("(//nav[@aria-label='Workspaces']/div[7]//div[text() = 'Shared inboxes'])[2]"));
		sharedInboxesLink.click();
		Thread.sleep(10000);

//		WebElement draftLink = driver.findElement(By.xpath("//a[@data-testid='workspace-user-drafts']"));
//		draftLink.click();

		WebElement radflow360Plugin = driver
				.findElement(By.xpath("//div[text()='Radflow 360 Plugin']/preceding-sibling::div"));

		//// iframe[@title='Radflow 360 Plugin']
		List<WebElement> mailSubjectList = driver
				.findElements(By.xpath("//div[contains(@class,'cellMiddle__StyledSubject')]/span"));
		for (WebElement e : mailSubjectList) {
			String subText = e.getText();
			if (subText.contains("TestDemo Rad PSL")) {
				e.click();
				break;
			}
		}

		Thread.sleep(2000);

		WebElement draftMsg = driver.findElement(By.xpath("//*[text() = 'Personal draft']"));

		System.out.println(draftMsg.isDisplayed());
*/
	}
}
