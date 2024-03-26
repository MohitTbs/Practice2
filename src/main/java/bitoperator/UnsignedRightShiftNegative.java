package bitoperator;

public class UnsignedRightShiftNegative {
	
	
	// This converts the system's architecture to 32 bits..
	// We have taken 8 bits just for the simplicity
	//-11         -->      11110101
	//-11>>>2     -->    00111101           --> As it is unsigned, we will consider 0 as the occupant, last 2 digit from the left
	
	int x=-11;
	void disp() {
		
		System.out.println("UnSigned Right Shift: "+(x>>>2));   //---   1073741821
	}

	public static void main(String[] args) {
		UnsignedRightShiftNegative obj = new UnsignedRightShiftNegative();
		obj.disp();
		
	}

}
