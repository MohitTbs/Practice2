package r2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotClassKeyPressDemo {

	public static void main(String[] args) throws AWTException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("http://omayo.blogspot.com/");
		WebElement tBox = driver.findElement(By.id("ta1"));
		tBox.sendKeys("lkdaskjd s");
		
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_A);
		rb.keyRelease(KeyEvent.VK_A);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_DELETE);
		
		List<WebElement> multiDropDown = driver.findElements(By.xpath("//select[@id='multiselect1']/option"));

		rb.keyPress(KeyEvent.VK_CONTROL);
		for (WebElement e : multiDropDown) {
			e.click();
		}
		rb.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(4000);
		rb.keyPress(KeyEvent.VK_CONTROL);
		for (WebElement e : multiDropDown) {
			e.click();
		}
		rb.keyRelease(KeyEvent.VK_CONTROL);
	}

}
