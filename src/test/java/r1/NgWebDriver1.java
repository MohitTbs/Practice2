package r1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class NgWebDriver1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		NgWebDriver ngWebDriver = new NgWebDriver(jse);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://13.58.75.61/login");
		ngWebDriver.waitForAngularRequestsToFinish();
		driver.findElement(By.xpath("//input[@formcontrolname='email']")).sendKeys("bhavik");
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("tbs@67789");
		driver.findElement(By.xpath("//button//span[normalize-space(text()) = 'Log In']")).click();
		ngWebDriver.waitForAngularRequestsToFinish();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Thread.sleep(6000);
		ngWebDriver.waitForAngularRequestsToFinish();
		driver.findElement(By.xpath("//a[@href='dashboard/MonthlyRecurringRevenue']")).click();
		// Thread.sleep(5000);
		ngWebDriver.waitForAngularRequestsToFinish();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader']")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement graph = driver
				.findElement(By.xpath("(((//*[name()='svg'])[2]//*[local-name()='g'])[5]//*[local-name()='g'])[1]"));

		//// div[@class='loader']
		int xAxis = (graph.getSize().getWidth()) / 2 - graph.getSize().getWidth();
		int yAxis = (graph.getSize().getHeight()) / 2 - graph.getSize().getHeight() + 100;

		Actions act = new Actions(driver);
		// ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",
		// graph);
		/*
		 * act.moveToElement(graph).perform(); act.moveToElement(graph).perform();
		 * WebElement pointer = driver .findElement(By.xpath(
		 * "(((//*[name()='svg'])[2]//*[local-name()='g'])[5]//*[local-name()='g'])[2]")
		 * ); for (int j = 0; j <= graph.getSize().getWidth(); j = j + 57) {
		 * 
		 * act.moveToElement(graph, xAxis + j, yAxis).perform(); //
		 * System.out.println(j); String text =
		 * driver.findElement(By.xpath("//div[contains(@class,'highcharts-label')]/span"
		 * )).getText(); System.out.println(text); }
		 */

		WebElement pieChart = driver
				.findElement(By.xpath("//*[local-name()='svg']//*[local-name()='clipPath'][contains(@id,'-10-')]/*"));
		try {
			act.moveToElement(pieChart).perform();
		} catch (Exception e) {

		}
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,522);");

		int xAxis1 = (pieChart.getSize().getWidth()) / 2 - pieChart.getSize().getWidth();
		int yAxis1 = (pieChart.getSize().getHeight()) / 2 - pieChart.getSize().getHeight() + 20;

		List<Map<String, String>> list1 = new ArrayList<Map<String, String>>();
		List<Map<String, String>> list2 = new ArrayList<Map<String, String>>();
		Map<String, String> map1 = new HashMap<String, String>();
		for (int b = 0; b < (pieChart.getSize().getHeight()); b = b + 50) {
			for (int l = 0; l < (pieChart.getSize().getWidth()); l = l + 50) {
				act.moveToElement(pieChart, xAxis1 + l, yAxis1 + b).perform();
				// System.out.println(l+"----"+b);

				try {
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
					System.out
							.println(driver.findElement(By.cssSelector("div[id='graph-donut-chart-monthly'] >div>div"))
									.getAttribute("class"));

				} catch (Exception e) {
					System.out.println("Inside catch");

				}

				try {
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

					String plan = driver
							.findElement(By.cssSelector("div[id='graph-donut-chart-monthly'] >div>div>span>span"))
							.getText();
					// System.out.println(plan);
					String percent = driver
							.findElement(By.cssSelector("div[id='graph-donut-chart-monthly'] >div>div>span>b"))
							.getText();
					// System.out.println(percent);
					map1.put(plan, percent);
					list1.add(map1);

				} catch (Exception e) {
					System.out.println("Inside catch 2");

				}
			}
		}
		for (int d = 0; d < list1.size(); d++) {
			if (!list2.contains(list1.get(d))) {
				list2.add(list1.get(d));
			}
		}
		list2.get(0).remove("");

		System.out.println("size: " + list2.get(0).size());
		System.out.println(list2);
	}
}
