package File_Class;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		DoWithFile doWithFile = new DoWithFile();
//		doWithFile.createFolder("E://Lab_LTMang//root");
//		doWithFile.createFolder("E://Lab_LTMang//root//folder1");
//		doWithFile.createFolder("E://Lab_LTMang//root//folder2");
//		doWithFile.createFolder("E://Lab_LTMang//root//folder3");
//		doWithFile.createFile("E://Lab_LTMang//root//t1.txt");
//		doWithFile.createFile("E://Lab_LTMang//root//t2.txt");
//		doWithFile.createFile("E://Lab_LTMang//root//t3.txt");
//		doWithFile.createFolder("E://Lab_LTMang//root//folder1//folder1_1");
//		doWithFile.createFile("E://Lab_LTMang//root//folder1//folder1_1//x.txt");
//		doWithFile.createFile("E://Lab_LTMang//root//folder1//folder1_1//y.txt");
//		doWithFile.createFile("E://Lab_LTMang//root//folder1//folder1_1//z.txt");
//		doWithFile.createFile("E://Lab_LTMang//root//folder1//a.txt");
//		doWithFile.createFile("E://Lab_LTMang//root//folder1//b.txt");
//		doWithFile.createFile("E://Lab_LTMang//root//folder1//c.txt");
//		doWithFile.deleteFile("E://Lab_LTMang//root//t1.txt");
//		doWithFile.deleteFile("E://Lab_LTMang//root//t2.txt");
//		doWithFile.deleteFile("E://Lab_LTMang//root//t3.txt");
//		doWithFile.deleteFolderPlus("E://Lab_LTMang//root", true);
//		doWithFile.findFirst("E://Lab_LTMang//root", "t3.txt");
//		doWithFile.dirTree("E://Lab_LTMang//root");
		String[] exts = {"txt", "docx"};
//		doWithFile.findAll("E://Lab_LTMang//root", exts);
		doWithFile.deleteAll("E://Lab_LTMang//root", exts);
	}

}
