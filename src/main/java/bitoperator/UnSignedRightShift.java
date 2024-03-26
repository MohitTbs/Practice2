package bitoperator;

public class UnSignedRightShift {
	
	
	//21       -->   00010101
	
	//21>>2
	
	//     00010101       --> 21
	//   00000101         --> 5
	
	int x = 21;
	
	void disp() {
		System.out.println("Right Shift: "+(x>>3));   //   x/(2^3)
	}
	

	public static void main(String[] args) {

		UnSignedRightShift obj = new UnSignedRightShift();
		obj.disp();
				
	}

}
