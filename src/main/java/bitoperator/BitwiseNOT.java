package bitoperator;

public class BitwiseNOT {

	// it inverts all the bits
	// ~
	
	//23              -->  00010111
	//~               -->  11101000   --> -24
	
	void disp() {
		System.out.println("Bits wise ~: " + (~23));
	}

	
	public static void main(String[] args) {
		BitwiseNOT obj = new BitwiseNOT();
		obj.disp();
		
	}

}
