package r3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.RequestId;

public class NetworkResponseSelenium {

	public static void main(String[] args) throws InterruptedException, IOException {

		getResponseBody();
	}

	public static void getResponseHeaders() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
		devTools.addListener(Network.responseReceived(), responseReceived -> {
			String responseUrl = responseReceived.getResponse().getUrl();
			if (responseUrl.contains("makemytrip")) {
				System.out.println("Url: " + responseUrl);
				System.out.println("Response headers: " + responseReceived.getResponse().getHeaders().toString());
			}

		});

		driver.get("https://www.makemytrip.com");
		Thread.sleep(10000);
		driver.quit();
	}

	public static void getResponseStatus() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
		devTools.addListener(Network.responseReceived(), responseReceived -> {
			String responseUrl = responseReceived.getResponse().getUrl();
			if (responseUrl.contains("makemytrip")) {
				System.out.println("Url: " + responseUrl);
				System.out.println("Response status: " + responseReceived.getResponse().getStatus());
			}

		});

		driver.get("https://www.makemytrip.com");
		Thread.sleep(10000);

	}

	public static void getResponseBody() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();

		String Partialpath = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\";
		FileWriter writer = new FileWriter(new File(Partialpath + "writtenfile.txt"));

		StringBuffer sb = new StringBuffer();

		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
		devTools.addListener(Network.responseReceived(), responseReceived -> {
			String responseUrl = responseReceived.getResponse().getUrl();
			RequestId requestId = responseReceived.getRequestId();
			if (responseUrl.contains("makemytrip")) {
				System.out.println("Url: " + responseUrl);
				System.out.println("Response body: " + devTools.send(Network.getResponseBody(requestId)).getBody());
				sb.append("Url: "+requestId+": " + responseUrl);
				sb.append("\n");
				sb.append("Response body: "+requestId+": " + devTools.send(Network.getResponseBody(requestId)).getBody());
				sb.append("\n");
			}

		});

		driver.get("https://www.makemytrip.com");
		System.out.println("///////////////////ldsldaslkd//////////");
		Thread.sleep(10000);

		driver.quit();
		System.out.println("driver was quit");
		
		writer.write(sb.toString());
		writer.close();
		System.out.println("File Written");
	}

}
