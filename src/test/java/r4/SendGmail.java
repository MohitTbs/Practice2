package r4;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SendGmail {

	@Test
	public void test1() throws InterruptedException, AWTException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://gmail.com");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("viral@technobrains.io");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Vc@tbs.io1");
		driver.findElement(By.id("passwordNext")).click();
		driver.findElement(By.xpath("//div[text() = 'Compose']")).click();
		WebElement subTo = driver.findElement(By.xpath("//input[@aria-label='To recipients']"));
		Thread.sleep(2000);
		subTo = driver.findElement(By.xpath("//input[@aria-label='To recipients']"));
		subTo.sendKeys("tbs.shubahmr@gmail.com");
		//driver.findElement(By.xpath("//input[@aria-label='To recipients']")).sendKeys("tbs.shubahmr@gmail.com");
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Hi there subject");
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("Hi there message body");
		WebElement attachFile = driver.findElement(By.xpath("//div[@aria-label='Attach files']"));
		
		StringSelection s = new StringSelection("C:\\Users\\Technobrain\\Downloads\\Download2.pdf");
	      // Clipboard copy
	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
	      //identify element and click
	      driver.findElement(By.xpath("//div[@aria-label='Attach files']")).click();
	      // Robot object creation
	      Thread.sleep(3000);
	      Robot r = new Robot();
	      //pressing enter
	      r.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      r.keyRelease(KeyEvent.VK_ENTER);
	      //pressing ctrl+v
	      r.keyPress(KeyEvent.VK_CONTROL);
	      r.keyPress(KeyEvent.VK_V);
	      //releasing ctrl+v
	      r.keyRelease(KeyEvent.VK_CONTROL);
	      r.keyRelease(KeyEvent.VK_V);
	      //pressing enter
	      r.keyPress(KeyEvent.VK_ENTER);
	      //releasing enter
	      
	      r.keyRelease(KeyEvent.VK_V);
		
		//attachFile.sendKeys("C:\\Users\\Technobrain\\Downloads\\Download2.pdf");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//div[contains(@data-tooltip,'Send')]")).click();
	}
}
