package multithreadconcept;

public class Test1 extends Thread {

	@Override
	public void run() {
		System.out.println("Inside the Test1 class");
	}
	
	public static void main(String[] args) {

		Test1 t1 = new Test1();
		t1.start();
		
	}

}
