package multithreadconcept;

public class ThreadMethod {
	
	//get the name of the thread
	static void getCurrentThreadName() {
		System.out.println(Thread.currentThread().getName());
	}
	
	//set the name of the thread
	static void setThreadName() {
		Thread.currentThread().setName("Test1");
	}
	
	// gives the status of the thread
	static void isAlive() {
		System.out.println(Thread.currentThread().isAlive());
	}
	

	public static void main(String[] args) {

		setThreadName();
		getCurrentThreadName();
		System.out.println(Thread.currentThread().getId());
		isAlive();
		
	}

}
