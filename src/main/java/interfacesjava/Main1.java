package interfacesjava;

public class Main1 {

	public static void main(String[] args) {

		// Not Possible.. It will force us to override the methods in the object body of the interface
		//interfaceA intA = new interfaceA();
		
		System.out.println(Test1.name);
		// cannot change the value of the interface variable as it is final and static in nature
		// Test1.name ="changed";
		
		// Upcasting for the interface
		
		intrfaceB objIntB = new Test1();
		objIntB.B1();
		
		Test1 tt = new Test1();
		
		System.out.println(tt.isOdd(4));
	}

}
