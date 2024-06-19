package quest1;

public class WithoutMainMethod {
	
	// Go to the location of this java file
	// type javac WithoutMainMethod
	// type java WithoutMainMethod
	// This will run this file
	// If you remove "System.exit(0);" then error will be thrown
	// saying no main method

	static {
		System.out.println("In a static block");
		System.exit(0);
	}
}
