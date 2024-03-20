package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {

	
	
	public static void ex1() {
		// Write the regular expression
		
		//1st way 
		Pattern p = Pattern.compile(".s"); //. represents single character  
		Matcher m = p.matcher("as");
		System.out.println(m.matches());
		
		//2nd way
		boolean b2 = Pattern.compile(".s").matcher("as").matches();
		System.out.println(b2);
		
		//3rd way
		boolean b3 = Pattern.matches(".s", "as");
		System.out.println(b3);
		
	}
	
	public static void ex2() {
		System.out.println(Pattern.matches(".s", "as"));//true (2nd char is s)  
		System.out.println(Pattern.matches(".s", "mk"));//false (2nd char is not s)  
		System.out.println(Pattern.matches(".s", "mst"));//false (has more than 2 char)  
		System.out.println(Pattern.matches(".s", "amms"));//false (has more than 2 char)  
		System.out.println(Pattern.matches("..s", "mas"));//true (3rd char is s)
		System.out.println(Pattern.matches("..s..", "masdb"));//true (3rd char is s and total char is 5)
		
		
	}
	
	public static void ex3() {
		//Regular Expression Character classes Example
		System.out.println(Pattern.matches("[amn]", "abcd"));//false (not a or m or n)  
		System.out.println(Pattern.matches("[amn]", "a"));//true (among a or m or n)  
		System.out.println(Pattern.matches("[amn]", "ammmna"));//false (m and a comes more than once)  
		System.out.println(Pattern.matches("[amn]", "mn"));// false
		System.out.println(Pattern.matches("[p-z]", "w"));// true
		System.out.println(Pattern.matches("[a-zA-Z]", "cw")); // false
		
	}
	
	public static void ex4() {
		//Regex Quantifiers
		System.out.println("? quantifier ....");  
		System.out.println(Pattern.matches("[amn]?", "a"));//true (a or m or n comes one time)  
		System.out.println(Pattern.matches("[amn]?", "aaa"));//false (a comes more than one time)  
		System.out.println(Pattern.matches("[amn]?", "aammmnn"));//false (a m and n comes more than one time)  
		System.out.println(Pattern.matches("[amn]?", "aazzta"));//false (a comes more than one time)  
		System.out.println(Pattern.matches("[amn]?", "am"));//false (a or m or n must come one time)  
		  
		System.out.println("+ quantifier ....");  
		System.out.println(Pattern.matches("[amn]+", "a"));//true (a or m or n once or more times)  
		System.out.println(Pattern.matches("[amn]+", "aaa"));//true (a comes more than one time)  
		System.out.println(Pattern.matches("[amn]+", "aammmnn"));//true (a or m or n comes more than once)  
		System.out.println(Pattern.matches("[amn]+", "aazzta"));//false (z and t are not matching pattern)  
		  
		System.out.println("* quantifier ....");  
		System.out.println(Pattern.matches("[amn]*", "ammmna"));//true (a or m or n may come zero or more times)  
		
	}
	
	public static void ex5() {
		
		boolean b = Pattern.matches(".pdf", "sdusdiu.pdf");
		System.out.println(b);
	}
	
	public static void ex6() {
        //String input = "Sample document1.pdf contains useful information. document2.pdf is another file.";
		//String input = "This was to see if patientId and patientMob was successfully saved with PatientData";
		String input = "This was to see if newpatientId and alphapatientMob was successfully saved with PatientData";

        // Define the regex pattern
        //String regex = "\\b\\w+\\.pdf\\b";
		//String regex = "patient\\w+\\b";
		String regex = "\\b\\w*patient\\w*\\b";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);

        // Create a matcher object
        Matcher matcher = pattern.matcher(input);
        
        // Find and print all matches
        while (matcher.find()) {
            String match = matcher.group();
            System.out.println("Match: " + match);
        }
    }
	
	public static void main(String[] args) {
		
		//ex1();
		//ex2();
		//ex3();
		//ex4();
		//ex5();
		ex6();

	}

}
