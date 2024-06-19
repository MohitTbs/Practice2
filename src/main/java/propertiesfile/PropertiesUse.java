package propertiesfile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUse {

	public static void main(String[] args) throws IOException {
		
		
		Properties prop = new Properties();
		
		prop.setProperty("Name", "Amul");
		prop.setProperty("place", "Parlour");
				
		System.out.println(prop.getProperty("Name"));
		prop.store(new FileWriter(".\\src\\main\\java\\propertiesfile\\info.properties",true), null);
	}

}
