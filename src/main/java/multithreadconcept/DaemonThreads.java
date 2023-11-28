package multithreadconcept;

public class DaemonThreads extends Thread{

	// It runs in the background of another Thread
	// It provides service to the thread
	// E.g. Garbage Collector, Finalizer, Attach Listener, Signal dispatcher, etc
	// Methods: setDaemon --  public final void, isDaemon --  public final boolean
	
	
	public void run() {
		System.out.println("child");
	}
	
	public static void main(String[] args) {

		DaemonThreads t = new DaemonThreads();
		t.setDaemon(true);
		t.start();
		System.out.println("I am main");
	}

}
