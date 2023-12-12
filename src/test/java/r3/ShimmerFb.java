package r3;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;



public class ShimmerFb {

	public static void main(String[] args) throws MalformedURLException {

		
		AndroidDriver driver;
		UiAutomator2Options caps = new UiAutomator2Options(); 
		caps.setAppPackage("com.facebook.katana");
		caps.setAppActivity("com.facebook.katana.LoginActivity");
		caps.setPlatformName("Android");
		caps.setNoReset(true);
		
		driver = new AndroidDriver(new URL("http://" + "127.0.0.1" + ":" + "4723" + "/"),
				caps);

	}

}
