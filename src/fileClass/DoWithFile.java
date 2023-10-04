package fileClass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DoWithFile {
	public void createFile(String path) {
		File myFile = new File(path);
		try {
			if (myFile.createNewFile()) {
				System.out.println("Create File success");
			} else {
				System.out.println("File created");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeFile(String path) {
		File myFile = new File(path);
		if (myFile.exists() == true) {
			if (myFile.delete()) {
				System.out.println("File removed");
			} else {
				System.out.println("File hasn't removed");
			}
		} else {
			System.out.println("File doesn't exists");
		}
	}

	public void createFolder(String path) {
		File myFolder = new File(path);
		if (myFolder.mkdirs()) {
			System.out.println("Create Folder success");
		} else {
			System.out.println("Folder created");
		}

	}

	public void removeFolder(String path) {
		File myFolder = new File(path);
		if (myFolder.isDirectory() && myFolder.listFiles() == null) {
			myFolder.delete();
		}
		if (myFolder.isDirectory() && myFolder.listFiles() != null) {
			for (File file : myFolder.listFiles()) {
				if (file.isFile()) {
					file.delete();
				}
				removeFolder(file.getAbsolutePath());
			}
			myFolder.delete();
		}

	}

	public void removePlus(String path, boolean action) {
		File myFolder = new File(path);
		if (action == true) {
			if (myFolder.isDirectory() && myFolder.listFiles() != null) {
				for (File file : myFolder.listFiles()) {
					if (file.isFile()) {
						file.delete();
					}
					removePlus(file.getAbsolutePath(), action);
				}
			}

		} else {
			removeFolder(path);
		}
	}

	public void findAll(String path, String... exts) {
		File myFolder = new File(path);
		if (myFolder.isDirectory()) {
			if (myFolder.listFiles() != null) {
				for (File file : myFolder.listFiles()) {
					for (String ext : exts) {
						if (file.getAbsolutePath().endsWith("." + ext)) {
							System.out.println(file.getAbsolutePath());
						}
					}
				}
			} else {
				System.out.println(path + "is null");
			}

		} else {
			System.out.println(path + " is illegal");
		}
	}

	public void deleteAll(String path, String... exts) {
		File myFolder = new File(path);
		if (myFolder.isDirectory()) {
			if (myFolder.listFiles() != null) {
				for (File file : myFolder.listFiles()) {
					for (String ext : exts) {
						if (file.getAbsolutePath().endsWith("." + ext)) {
							file.delete();
							System.out.println("All File are deleted");
						}
					}
				}
			} else {
				System.out.println(path + "is null");
			}

		} else {
			System.out.println(path + " is illegal");
		}
	}

	public static void main(String[] args) {
		DoWithFile test = new DoWithFile();
		// test.createFile("E:\\Lab_LTMang\\filetest.txt");
		// test.removeFile("E:\\Lab_LTMang\\filetest.txt");
//		test.createFolder("E:\\Lab_LTMang\\root");
//		test.createFolder("E:\\Lab_LTMang\\root\\folder1");
//		test.createFolder("E:\\Lab_LTMang\\root\\folder1\\folder");
//		test.createFile("E:\\Lab_LTMang\\root\\folder1\\folder\\file.txt");
//		test.createFile("E:\\Lab_LTMang\\root\\folder1\\a.txt");
//		test.createFile("E:\\Lab_LTMang\\root\\folder1\\b.txt");
//		test.createFile("E:\\Lab_LTMang\\root\\folder1\\c.txt");
//		test.createFile("E:\\Lab_LTMang\\root\\folder1\\x.txt");
//		test.createFile("E:\\Lab_LTMang\\root\\folder1\\y.txt");
//		test.createFile("E:\\Lab_LTMang\\root\\folder1\\z.txt");
//		test.createFolder("E:\\Lab_LTMang\\root\\folder2");
//		test.createFolder("E:\\Lab_LTMang\\root\\folder3");
//		test.createFile("E:\\Lab_LTMang\\root\\file1.docx");
//		test.createFile("E:\\Lab_LTMang\\root\\file2.docx");
//		test.createFile("E:\\Lab_LTMang\\root\\file3.docx");
//		test.removeFolder("E:\\Lab_LTMang\\root");
//		test.removePlus("E:\\Lab_LTMang\\root", false);
		String[] exts = { "jpg", "docx" };
		test.findAll("E:\\Lab_LTMang\\root", exts);
		test.deleteAll("E:\\Lab_LTMang\\root", exts);
	}
}
