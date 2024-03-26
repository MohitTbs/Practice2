package bitoperator;

public class SignedRightShift {
	
	
	//9      -->  		00001001
	//1s com -->  		11110110
	//2s com -->		       1
	//out    -->        11110111   --->  -9
	
	//    11110111      --> -9
	//  11111101 		--> Right Shift   -->  -3
	
	// 2^6=64
	// 2^5=32
	// 2^4=16
	// 2^3=8
	// 2^2=4
	// 2^0=1

	// -64+32+16+8+4+1 = -3
	
	
	int x =-9;
	
	void disp() {
		System.out.println("Right Shift: "+ (x>>2)); //  -9/(2^2)
	}
	
	public static void main(String[] args) {
		SignedRightShift obj = new SignedRightShift();
		obj.disp();
	}

}
