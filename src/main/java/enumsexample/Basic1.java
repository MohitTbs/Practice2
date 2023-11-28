package enumsexample;



public class Basic1 {

	enum Week {
		Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
		//these are enum constants
		// public, static and final
		// since it is final you cannot create child enums
		// type is Week
		// enum cannot extend anything else as it extends Enum
		// it cannot be a super class
		// this keyword prints the Constant values
		// enum can implement as many interfaces as we want
		
		Week() {
			System.out.println("Constructor called for "+ this);
		}
		// Constructor is not public or protected, only private or default
		// why? -> if it was public or protected, it would allow initialization of more than one object
		// we only want the constant number of objects for Week.
		// fixed number of objects. i.e 7 in this case
		// internally: public static final Week Monday = new Week();
	}
	
	public static void main(String[] args) {

		Week week;
		week = Week.Monday;
		
		for(Week day : Week.values()) {
			System.out.println(day);
		}
		
		System.out.println(week.ordinal());
	}

}
