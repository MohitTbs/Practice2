package interfacesjava;

public interface defaultinterface {

	default void fun() {
		System.out.println("defaultinterface_fun()");
	}
	
	int fun2();
	
	static void m2() {
		
	}
}
