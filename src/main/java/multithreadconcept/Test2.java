package multithreadconcept;

public class Test2 implements Runnable{

	public static void main(String[] args) {

		Test2 t2 = new Test2();
		Thread td = new Thread(t2);
		td.start();
		Integer.parseInt("454");
	}

	@Override
	public void run() {
		System.out.println("Inside Test2 Class");
	}

}
