package interfacesjava;

public class Test1 implements interfaceA, intrfaceB{

	@Override
	public void B1() {

		System.out.println("Inside B1");
	}

	@Override
	public void B2() {

		System.out.println("Inside B2");
	}

	@Override
	public void A1() {

		System.out.println("Inside A1");
	}

	@Override
	public void A2() {

		System.out.println("Inside A2");
	}

	@Override
	public void AB1() {

		System.out.println("Inside AB1");
	}
	
	public void t1() {
		System.out.println("Inside t1");
	}
	
	public boolean isOdd(int num) {
		return (num & 1) == 1;
	}

}
