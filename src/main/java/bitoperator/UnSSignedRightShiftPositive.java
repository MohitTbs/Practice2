package bitoperator;

public class UnSSignedRightShiftPositive {

	//  >>>
	
	//17            -->    00010001
	//17>>>2        -->  00000100        --> 2^2=4
	
	int x=17;
	void disp() {
		
		System.out.println("Right Shift: "+(x>>>2));
	}
	
	public static void main(String[] args) {
		UnSSignedRightShiftPositive obj = new UnSSignedRightShiftPositive();
		obj.disp();
		
	}

}
