package javaoops;

public class AssignTheVariableTOAnotherVariale {


	 final void getName() {
		System.out.println("I am in AssignTheVariableTOAnotherVariale");
	}
	
	
	
	public static void main(String[] args) {

		int a = 15;
		int b = a;
		a = 20;
		
		AssignTheVariableTOAnotherVariale ab = new AssignTheVariableTOAnotherVariale();
		
		System.out.println(b);
	}

}
