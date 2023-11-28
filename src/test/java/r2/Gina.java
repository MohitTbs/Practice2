package r2;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Gina {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//1.
		/*
		driver.get("https://www.gina.com/en/flats");

		List<WebElement> li = driver
				.findElements(By.xpath("//div[contains(@class,'gallery-grid')]//div[@class='gallery-info']/span"));

		System.out.println(li.size());
		for (WebElement e : li) {
			System.out.println(e.getAttribute("innerText"));
		}

		List<WebElement> itemList = driver.findElements(By.xpath("//div[contains(@class,'gallery-grid')]"));
		itemList.get(0).click();

		WebElement dropdown = driver.findElement(By.id("productOptionId"));
		// dropdown.click();
		getDDValues(dropdown);

		WebElement EU = driver.findElement(By.xpath("//button[@data-type='EU']"));
		EU.click();
		getDDValues(dropdown);

		WebElement US = driver.findElement(By.xpath("//button[@data-type='US']"));
		US.click();
		getDDValues(dropdown);
		*/
		
		//2. 
		driver.get("https://www.gina.com/en/faqs/delivery-and-returns");
		
		List<WebElement> li = driver
				.findElements(By.xpath("//h3[@class='menuheader expandable']"));
		
		for(WebElement e : li) {
			e.click();
			String classAtt = e.getAttribute("class");
			Thread.sleep(500);
			System.out.println(classAtt);
		}
		li.get(li.size()-1).click();
	}

	static void getDDValues(WebElement dropdown) {

		Select se = new Select(dropdown);
		List<WebElement> options = se.getOptions();
		for (WebElement e : options) {
			System.out.println(e.getText());
		}
		options.get(options.size()-1).click();
	}

}
