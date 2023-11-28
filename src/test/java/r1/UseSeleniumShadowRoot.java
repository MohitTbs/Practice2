package r1;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseSeleniumShadowRoot {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
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
