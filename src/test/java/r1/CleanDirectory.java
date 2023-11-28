package r1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class CleanDirectory {

	static File fe = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\downloads");

	public static void deleteFilesInDirectory(File file) {
		// store all the paths of files and folders present
		// inside directory
		for (File subfile : file.listFiles()) {

			// if it is a subfolder,e.g Rohan and Ritik,
			// recursively call function to empty subfolder
			if (subfile.isDirectory()) {
				deleteFilesInDirectory(subfile);
			}

			// delete files and empty subfolders
			subfile.delete();

		}
		// file.delete(); //-- To delete the Folder
	}

	public static void main(String[] args) throws Exception {

		// FileUtils.cleanDirectory(fe);

		deleteFilesInDirectory(fe);
		System.out.println("Files Deleted");
	}

}
