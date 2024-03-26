package bitoperator;

public class BitWiseXOR {

	// gives true if both the values are different
	
	// 1^1=0, 0^0=1, 1^0=1, 0^1=1

	// Bitwise XOR (^)
	// 31 ^ 18

	// 31 --> 11111
	// 18 --> 10010
	// --> 	  01101 --> 13

	void disp() {
		System.out.println("Bits wise &: " + (31 ^ 18));
	}

	public static void main(String[] args) {

		BitWiseXOR obj = new BitWiseXOR();
		obj.disp();
	}

}
