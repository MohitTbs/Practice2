package abstractjava;

public class Watch implements Clock{

	@Override
	public void m1() {
		System.out.println("implemented by Watch m1");
		
	}

	@Override
	public void m2() {
		System.out.println("implemented by Watch m2");
		
	}
	
	public void m3() {
		System.out.println("method m3 of Watch class");
	}

}
