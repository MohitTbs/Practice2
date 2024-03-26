package bitoperator;


public class LeftShiftNegative {
// Addition on bits
	//1+1=0,  1->carry forward
	//1+0=1
	//0+1=1
	//0+0=1
	
	
	
	
	//10 -->    00001010 
	
	// 1s complement
	//-10 -->   11110101
	// 2s complement
	//-10 -->          1
	//output-   11110110        --> -10
	
	
	
	//-10<<2
	//  1 1 1 1 0 1 1 0          --> -10
	//      1 1 0 1 1 0 0 0      --> Left Shift    --> -40
	//  2^6=64
	//  2^4=16
	//  2^3=8
	
	// -64+16+8=-40
	
	//-----------------------------------
	
	//-8<<1
	
	//8       -->   00001000
	//1s com  -->   11110111
	//2s com  -->          1
	//out     -->   11111000    -->-8
	
	
	//    1 1 1 1 1 0 0 0
	//      1 1 1 1 0 0 0 0
	
	//  2^6 = 64
	//  2^5 = 32
	//  2^4 = 16
	// -64+32+16 = -16
	
	
	int x=-10;
	
	void disp() {
		System.out.println("Negative Left Shift: "+(x<<2));
	}
	
	
	public static void main(String[] args) {
		
		LeftShiftNegative obj = new LeftShiftNegative();
		obj.disp();
	}
}
