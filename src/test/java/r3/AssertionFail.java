package r3;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionFail {

	
	@AfterMethod
	public void tearDown(ITestResult r) {
		
		if(r.getStatus() == r.FAILURE) {
			
			System.out.println("///////////////////////////");
			System.out.println(r.getThrowable().getMessage());
			
			System.out.println("///////////////////////////");
			StackTraceElement[] arr = r.getThrowable().getStackTrace();
			System.out.println(arr.length);
			for(StackTraceElement a1 : arr) {
				System.out.println(a1.toString());
			}
			System.out.println("///////////////////////////");
		}
	}
	
	
	@Test
	public void test1() {
		
		SoftAssert sa = new SoftAssert();
		
		System.out.println("1");
		sa.fail("after 1");
		
		System.out.println("2");
		sa.fail("after 2");
		
		System.out.println("3");
		sa.assertTrue(true);
		
		Method[] as = AssertionFail.class.getDeclaredMethods();
		for(int k =0 ; k <as.length ; k++) {
			System.out.println(as[k].getName());
		}
		sa.assertAll();
		
		
	}
}
