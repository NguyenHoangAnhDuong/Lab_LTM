package File_Class;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RemoveImage {
	public void rmImage(String folder, String ext) {
		File myFolder = new File(folder);
		if(!myFolder.isDirectory()) {
			System.out.println("No derectory");
		}else {
			for(File file : myFolder.listFiles()) {
				if(file.getAbsolutePath().endsWith(ext)) {
					file.delete();
				}
			}
			System.out.println("delete completely");
		}
	}
	public void findImage(String path, String string) {
		File myFolder = new File(path);
		int count = 0;
		if(!myFolder.isDirectory()) {
			System.out.println("No derectory");
		}else {
			for(File file : myFolder.listFiles()) {
				if(file.getAbsolutePath().contains(string)) {
					System.out.println(file.getAbsolutePath());
					count++;
				}
			}
		}
		System.out.println(count);
	}
	public static void main(String[] args) {
		RemoveImage image = new RemoveImage();
		image.findImage("F:\\DoAnLTW\\WebsiteOfBHD\\Image\\Product", " ");
	}

}
