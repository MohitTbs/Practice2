package bitoperator;

public class LeftShit {

	int x = 10;
	
	void disp() {
		// 10<<1
		// 0 0 0 0 1 0 1 0     -- 10
		//   0 0 0 1 0 1 0 0     -- Left shift -- 20   -- x*(2^1)
		
		
		//10<<2
		// 0 0 0 0 1 0 1 0       		--10
		//     0 0 1 0 1 0 0 0			-- Left Shift -- 40   -- x*(2^2)
		
		
		//10<<3
		// 0 0 0 0 1 0 1 0       		--10
		//       0 1 0 1 0 0 0 0		-- Left Shift  -- 80       --10*(2^3)
		
		System.out.println("Left Shift : "+ (x<<3)); 
	}
	
	public static void main(String[] args) {

		LeftShit obj = new LeftShit();
		obj.disp();
	}
	
	// Uses of Shift:
	// Encryption, Compression, Graphics, Communication, ports/sockets 

}
