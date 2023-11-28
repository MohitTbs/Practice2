package abstractjava;

public class child1 extends parent1{

	public child1(int a, String name) {
		super(a, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	void m1() {
		System.out.println("overriding m1() in child ");
		
	}

	@Override
	void m2() {
		System.out.println("overriding m2() in child ");
		
	}

}
