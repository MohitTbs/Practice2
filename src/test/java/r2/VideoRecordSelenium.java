package r2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class VideoRecordSelenium {

	WebDriver driver;
	ATUTestRecorder recorder;
	
	@BeforeMethod
	public void startRec() throws ATUTestRecorderException {
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		//E:\Automation Projetcs\Practice\src\test\resources\downloads
		recorder = new ATUTestRecorder("E:\\Automation Projetcs\\Practice\\src\\test\\resources\\downloads","RecordedVideo-"+dateFormat.format(date),false);
		recorder.start();
	}
	
	@AfterMethod
	public void stopRec() throws ATUTestRecorderException {
		driver.quit();
		recorder.stop();
	}
	
	@Test
	public void Test() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qavbox.github.io/demo/shadowDOM/");

		Thread.sleep(2000);

		SearchContext e1 = driver.findElement(By.cssSelector("my-open-component")).getShadowRoot();
		e1.findElement(By.cssSelector("input")).sendKeys("Test");

		driver.get("https://shop.polymer-project.org/");

		Thread.sleep(2000);

		SearchContext e2 = driver.findElement(By.cssSelector("shop-app")).getShadowRoot();

		SearchContext e3 = e2.findElement(By.cssSelector("iron-pages > shop-home")).getShadowRoot();

		String txt = e3.findElement(By.cssSelector("div:nth-child(2) > h2")).getText();
		System.out.println(txt);
	}
}
