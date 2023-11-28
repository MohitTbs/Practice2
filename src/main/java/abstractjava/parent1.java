package abstractjava;

public abstract class parent1 {

	int a;
	String name;
	final int Value = 15542;
	static String career;
	
	
	// The constructor can be called via child class constructor
	// We cannot make the object of this class parent1 p = new parent1();
	public parent1(int a, String name) {
		this.a = a;
		this.name = name;
	}
	
	
	abstract void m1();
	abstract void m2();
	
	// static abstract method is not allowed 
	//abstract static void m3();
	
	void m4() {
		System.out.println("I am m4() which is non static");
	}
	
	static void m5() {
		System.out.println("I am m5() which is static");
	}
	
}
