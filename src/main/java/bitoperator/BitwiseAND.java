package bitoperator;

public class BitwiseAND {

	// &
	
	// 5 & 6
	//6     -->    			110
	//5     -->    			101
	//true or false -->		100          --> 2^2=4
	
	void disp() {
		System.out.println("Bits wise &: "+(5 & 6));
	}
	
	public static void main(String[] args) {

		BitwiseAND obj = new BitwiseAND();
		obj.disp();
	}

}
