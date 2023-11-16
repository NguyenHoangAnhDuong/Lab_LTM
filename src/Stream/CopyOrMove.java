package Stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyOrMove {
//	7.	Bài 5: (SV Tự làm ở nhà) Viết CT copy/move file dùng byte array kết hợp với BIS, BOS: 
//		boolean fileCopy(String sFile, String destFile, boolean moved);
	public void CopyFile(String pathBegin, String pathEnd, boolean move) throws IOException {
		InputStream begin = new BufferedInputStream(new FileInputStream(pathBegin));
		File fileEnd = new File(pathEnd);
		fileEnd.createNewFile();
		OutputStream end = new BufferedOutputStream(new FileOutputStream(pathEnd));
		long timebegin = System.currentTimeMillis();
		int data;
		while ((data = begin.read()) != -1) {
			end.write(data);
		}
		begin.close();
		end.close();
		long timeEnd = System.currentTimeMillis();
		if (move == true) {
			File myFile = new File(pathBegin);
			myFile.delete();
			System.out.println("File is move " + (timeEnd - timebegin) + "ms");
		} else {
			System.out.println("File is copy " + (timeEnd - timeEnd) + "ms");
		}
	}

//	8.	Bài 6: (SV Tự làm ở nhà) Viết CT copy/move thư mục dùng byte array kết hợp với BIS, BOS:
//		boolean folderCopy(String sFolder, String destFolder, boolean moved);
	public void CopyFolder(String pathBegin, String pathEnd, boolean move) throws IOException {
		long timebegin = System.currentTimeMillis();
		File folderBegin = new File(pathBegin);
		File folderEnd = new File(pathEnd);
		folderEnd.mkdirs();
		int data;
		if (folderBegin.isDirectory()) {
			for (File file : folderBegin.listFiles()) {
				InputStream begin = new BufferedInputStream(new FileInputStream(file));
				File fileEnd = new File(folderEnd.getAbsolutePath() + "\\" + file.getName());
				fileEnd.createNewFile();
				OutputStream end = new BufferedOutputStream(new FileOutputStream(fileEnd));
				while ((data = begin.read()) != -1) {
					end.write(data);
				}
				begin.close();
				end.close();
			}
		}
		long timeEnd = System.currentTimeMillis();
		if (move == true) {
			for (File file : folderBegin.listFiles()) {
				file.delete();
			}
			folderBegin.delete();
			System.out.println("Folder is move " + (timeEnd - timebegin) + "ms");
		} else {
			System.out.println("Folder is copy " + (timeEnd - timeEnd) + "ms");
		}
	}

//	9.	Bài XX: Hiện thực hàm void copyAll(String sDir, String dDir String ext1, String ext2, …) 
//	copy từ thư mục nguồn sDir vào thư mục đích dDir tất cả các file có 
//	phần mở rộng quy định bởi ext1, ext2,…, extn; 
	public void findAndCopyFolder(String pathBegin, String pathEnd, String... exts) throws IOException {
		File folderBegin = new File(pathBegin);
		File folderEnd = new File(pathEnd);
		int data;
		long timebegin = System.currentTimeMillis();
		folderEnd.mkdirs();
		if (folderBegin.isDirectory()) {
			for (File file : folderBegin.listFiles()) {
				for (String st : exts) {
					if (file.getAbsolutePath().endsWith(st)) {
						InputStream begin = new BufferedInputStream(new FileInputStream(file));
						File fileCopy = new File(folderEnd.getAbsoluteFile() + "\\" + file.getName());
						fileCopy.createNewFile();
						OutputStream end = new BufferedOutputStream(new FileOutputStream(fileCopy));
						while ((data = begin.read()) != -1) {
							end.write(data);
						}
						begin.close();
						end.close();
					}
				}
			}
		}
		long timeEnd = System.currentTimeMillis();
		System.out.println("Folder is copy " + (timeEnd - timeEnd) + "ms");
	}

//	10.	(3) Viết CT File Spliter chia 1 file thành nhiều phần 
//	theo dung lượng hoặc số lượng. 
//	Viết CT File Joiner ghép các file thành phần thành file ban đầu
	public void spliter(String pathFileBegin, String pathFolderSave, long size) throws IOException {
		File myFile = new File(pathFileBegin);
		File folderSave = new File(pathFolderSave);
		int SumNumFile = (int) (myFile.length() / size);
		long sizefileresidual = (myFile.length() - (SumNumFile * size));
		InputStream begin = new BufferedInputStream(new FileInputStream(myFile));
		for (int i = 1; i <= SumNumFile; i++) {
			File newFile = new File(folderSave.getAbsoluteFile() + "\\file" + i);
			newFile.createNewFile();
			OutputStream end = new BufferedOutputStream(new FileOutputStream(newFile));
			for(int z = 0; z < size; z++) {
				end.write(begin.read());
			}
			end.close();
		}
		if (sizefileresidual > 0) {
			File endFile = new File(folderSave.getAbsoluteFile() + "\\end");
			endFile.createNewFile();
			OutputStream opEnd = new BufferedOutputStream(new FileOutputStream(endFile));
			for(int z = 0; z < sizefileresidual; z++) {
				opEnd.write(begin.read());
			}
			opEnd.close();
		}
		begin.close();
		System.out.println("Split success");
	}
	public void joiner(String pathFolderJoin, String pathFileSave) throws IOException {
		File fileDad = new File(pathFileSave);
		fileDad.createNewFile();
		OutputStream end = new BufferedOutputStream(new FileOutputStream(fileDad));
		File folderJoin = new File(pathFolderJoin);
		if(folderJoin.isDirectory()) {
			for(File file : folderJoin.listFiles()) {
				InputStream begin = new BufferedInputStream(new FileInputStream(file));
				for(int i = 0; i < file.length(); i++) {
					end.write(begin.read());
				}
				begin.close();
			}
		}
		end.close();
		System.out.println("Join success");
	}
}
