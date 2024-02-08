package r3;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class GetTestName {
	
	
	@Test(description = "Test 1 Name")
	public void Test1(ITestResult r) {
		System.out.println("Inside a Test");
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult r) {
		System.out.println(r.getTestName());
	}

}
