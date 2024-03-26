package bitoperator;

public class BitwiseOR {
	
	//10              -->          1010
	//9               -->          1001
	//true or false   -->          1011
	
	

	void disp() {
		System.out.println("Bits wise &: "+(10 | 9));
	}
	
	public static void main(String[] args) {

		BitwiseOR obj = new BitwiseOR();
		obj.disp();
	}

}
