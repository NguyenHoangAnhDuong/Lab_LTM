package File_Class;

import java.io.File;
import java.io.IOException;

public class DoWithFile {
	public void createFile(String path) throws IOException {
		File myFile = new File(path);
		if(myFile.createNewFile()== true) {
			System.out.println(path + " da duoc tao thanh cong");
		}else {
			System.out.println(path + " tao file that bai");
		}
	}
	public void deleteFile(String path) {
		File myFile = new File(path);
		if(myFile.exists()== true) {
			myFile.delete();
			System.out.println("Xoas file thanh cong");
		}else {
			System.out.println("Xoa file that bai");
		}
	}
	public void createFolder(String path) {
		File myFolder = new File(path);
		if(myFolder.mkdirs() == true) {
			System.out.println(myFolder + " da tao thanh cong");
		}else {
			System.out.println(myFolder + " tao that bai");
		}
	}
//	1. Bài 1:(1)
//
//	Hiện thực hàm
//
//	boolean delete(String path) xóa tất cả những gì có thể trong thư mục được chỉ định bởi path;
//	trả về true nếu xóa thành công, false nếu xóa không thành công
//	Mở rộng: Chỉ xóa files giữa nguyên cấu trúc thư mục

	public void deleteFolder(String path) {
		File myFolder = new File(path);
		if(myFolder.isFile()) {
			System.out.println(path + " La File, File nay da duoc xoa");
			myFolder.delete();
		}if(myFolder.isDirectory() && myFolder.listFiles() == null) {
			myFolder.delete();
			System.out.println(path + " Folder nay da duoc xoa");
		}if(myFolder.isDirectory() && myFolder.listFiles() != null) {
			for(File f : myFolder.listFiles()) {
				if(f.isFile()) {
					f.delete();
				}
				deleteFolder(f.getAbsolutePath());
			}
			System.out.println(path + " Da duoc xoa");
		}
		myFolder.delete();
	}
	public void deleteFolderPlus(String path, boolean action) {
		File myFolder = new File(path);
		if(action==true) {
			if(myFolder.isFile()) {
				System.out.println(path + " La File, File nay da duoc xoa");
				myFolder.delete();
			}if(myFolder.isDirectory() && myFolder.listFiles() != null) {
				for(File f : myFolder.listFiles()) {
					if(f.isFile()) {
						f.delete();
						System.out.println(path + " Da duoc xoa");
					}
					deleteFolderPlus(path, action);
				}
				
			}
		}
		else {
			deleteFolder(path);
		}
	}
//	2.	Bài 2: Hiện thực hàm boolean findFirst(String path, String pattern) tìm và hiển thị
//	đường dẫn đầy đủ file/folder chỉ định bởi path có chứa chuỗi quy định bởi pattern; 
//	trả về true nếu tìm thấy, false nếu không tìm thấy
	public void findFirst(String path, String partern) {
		File myFolder = new File(path);
		if(!myFolder.isDirectory()) {
			System.out.println(myFolder + " Khong phai la folder");
		}else {
			for(File file : myFolder.listFiles()) {
				if(file.getAbsolutePath().contains(partern)) {
					System.out.println(file.getAbsolutePath() + " Day la duong dan can tim");
				}
			}
		}
		
	}
//	3.	Bài 3 (Advanced): Viết hàm hiển thị cấu trúc cây của thư mục void dirTree(String path); 
//	dùng các ký tự + - | để vẽ cấu trúc cây. Cần hiển thị được cấp con hay ngang cấp,… 
//	(tương tự lệnh tree trong DOS)
	public void dirTree(String path) {
		File myFolder = new File(path);
		if(myFolder.isDirectory() && myFolder.listFiles() != null) {
			for(File f : myFolder.listFiles()) {
				if(f.isFile()) {
					System.out.println("\t+" + f.getName() + "\n");
				}
				if(f.isDirectory()) {
					System.out.println("-" + f.getName() + "\n");
				}
				dirTree(f.getAbsolutePath());
			}
		}
	}
//	5.	Bài XX:  (2a) Hiện thực hàm void findAll(String path, String ext1, String ext2, …) 
//	tìm và hiển thị đường dẫn đầy đủ file trong thư mục path có phần mở rộng quy định bởi 
//	ext1, ext2,…, extn; 
	public void findAll(String path, String...exts) {
		File myFile = new File(path);
		if(myFile.isDirectory()) {
			for(File file : myFile.listFiles()) {
				for(String st : exts) {
					if(file.getAbsolutePath().endsWith("." + st)) {
						System.out.println(file.getAbsolutePath());
					}
				}
				
			}
		}
		else {
			System.out.println(path + " is illegal");
		}
	}
//	6.	Bài XX: (2b) Hiện thực hàm boolean deleteAll(String path, String ext1, String ext2, …)
//	tìm và xóa tất cả các file trong thư mục path có phần mở rộng quy định bởi 
//	ext1, ext2,…,extn; 
	public void deleteAll(String path, String...exts) {
		File myFile = new File(path);
		if(myFile.isDirectory()) {
			for(File file : myFile.listFiles()) {
				for(String st : exts) {
					if(file.getAbsolutePath().endsWith("." + st)) {
						file.delete();
						System.out.println(file.getAbsolutePath()+ " is deleted");
					}
				}
			}
		}
		else {
			System.out.println(path + " is illegal");
		}
	}
	
	

}
