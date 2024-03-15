package r5;

import java.io.File;

public class GetSpaceOfSystem {

	public static void main(String[] args) {

		getUsableSpace("D");
		getTotalSpace("D");
	}

	public static void getUsableSpace(String driveName) {
		double size = new File(driveName + ":\\").getUsableSpace() / (1024.0 * 1024 * 1024);
		System.out.printf("%.3f GB\n", size);
	}

	public static void getTotalSpace(String driveName) {
		double size = new File(driveName + ":\\").getTotalSpace() / (1024.0 * 1024 * 1024);
		System.out.printf("%.3f GB\n", size);

	}

}
