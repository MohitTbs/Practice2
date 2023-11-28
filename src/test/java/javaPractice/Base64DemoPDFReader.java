package javaPractice;

import java.io.IOException;
import java.util.Base64;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class Base64DemoPDFReader {

	public static void main(String[] args) throws IOException {
		
		String st = "I am a computer";
		String encodedString = Base64.getEncoder().encodeToString(st.getBytes());

		System.out.println(encodedString);
		
		
		byte[] decodedByteArray = Base64.getDecoder().decode(encodedString);
		
		String ss = new String(decodedByteArray);
		
		System.out.println(ss);
		
		PdfReader reader = new PdfReader(System.getProperty("user.dir")+"\\src\\test\\resources\\files\\RPT_Reimbursement.pdf");
		
		System.out.println(reader.getNumberOfPages());
		
		String tyu = PdfTextExtractor.getTextFromPage(reader, 1);
		
		System.out.println(tyu);
	}

}
