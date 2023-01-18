package br.com.cod3r.composite.folders;

import br.com.cod3r.composite.folders.model.File;
import br.com.cod3r.composite.folders.model.FileSystemItem;
import br.com.cod3r.composite.folders.model.Folder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {

	public static void main(String[] args) {

		FileSystemItem file1 = new File("File1.txt");
		FileSystemItem file2 = new File("File2.txt");
		FileSystemItem file3 = new File("File3.txt");
		FileSystemItem file4 = new File("File4.txt");
		FileSystemItem sf1 = new Folder("sf1", List.of(file1));
		FileSystemItem sf2 = new Folder("sf2", Arrays.asList(file2, sf1));
		FileSystemItem folder = new Folder("folder", Arrays.asList(sf2, file3, file4));

		folder.print("");

		System.out.println("------------");

		String dir = System.getProperty("user.dir");
		FileSystemItem fromDisk = createCompositeFromFile(
				new java.io.File(dir));
		fromDisk.print("");
	}

	private static FileSystemItem createCompositeFromFile(java.io.File file) {
		if(!file.isDirectory()) return new File(file.getName());
		List<FileSystemItem> childs = new ArrayList<>();
		java.io.File[] files = file.listFiles();
		for (java.io.File jFile : files) {
			childs.add(createCompositeFromFile(jFile));
		}
		return new Folder(file.getName(), childs);
	}
}
