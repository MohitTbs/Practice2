package javaPractice;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PdfBoxDemo {

	public static void main(String[] args) throws IOException {

		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\RPT_Reimbursement.pdf";
		String path2 = System.getProperty("user.dir") + "\\src\\test\\resources\\files\\";
		
		PDDocument.load(new File(path));
		  //Creating PDF document object 
		
		
	      PDDocument document = new PDDocument();  
	      
	      //adding pages
	      PDPage my_page = new PDPage();
	      
	      document.addPage(my_page);
	      document.addPage(my_page);
	      
	      //Saving the document
	      document.save(path2+"my_doc.pdf");
	      
	    //Closing the document  
	      document.close();

		
	}

}
