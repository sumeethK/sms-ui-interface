package com.sumeeth.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.sumeeth.model.FileInfo;
import com.sumeeth.model.FileInfoList;

public class TestDirectoryScanner {

	private static final File TARGET_PATH = new File(
			"E:\\software");

	@Test
	public void testNuberOfFiles() {
		int filesCount = DirectoryScanner
				.numberOfFiles(TARGET_PATH);
		System.out.println("Files Count : " + filesCount);

	}

	@Test
	public void testNuberOfDirectories() {
		int dirCount = DirectoryScanner
				.numberOfDir(TARGET_PATH);
		System.out.println("DIR Count : " + dirCount);

	}

	@Test
	public void testNuberOfFilesOrDirectories() {
		int count = DirectoryScanner
				.numberOfFilesOrDir(TARGET_PATH);
		System.out.println("FilesOrDirectories Count : "
				+ count);

	}

	@Test
	public void testListAllFiles()
			throws InterruptedException {
		List<FileInfo> files = DirectoryScanner
				.listAllFiles(TARGET_PATH)
				.getFileInfoList();
		System.out.println("Files found" + files.size());
		Thread.sleep(3000);
		for (FileInfo file : files)
			System.out.println(" " + file.getName());

	}

	@Test
	public void testListAllExEFiles() throws IOException {
		File TARGET_PATH = new File(
				"C:\\Users\\daljit\\Documents\\files");
		String[] extensions = { "txt", "properties" };
		FileInfoList fl = DirectoryScanner
				.listAllFilesWithExtension(TARGET_PATH,
						extensions);
		List<FileInfo> files = fl.getFileInfoList();
		if (files != null)
			for (FileInfo file : files) {
				System.out.println(file);
			}
		JAXBUtil.marshalFileList(fl);
	}

	@Test
	public void testUnmarshalFileList() throws IOException {
		FileInfoList fl = JAXBUtil.unmarshalFileList();
		List<FileInfo> files = fl.getFileInfoList();
		if (files != null)
			for (FileInfo file : files) {
				System.out.println(file);
			}
	}

	@Test
	public void testpersist() throws IOException {
		File TARGET_PATH = new File(
				"C:\\Users\\daljit\\Documents\\files");
		String[] extensions = { "txt", "properties" };
		FileInfoList fl = DirectoryScanner
				.listAllFilesWithExtension(TARGET_PATH,
						extensions);
		JAXBUtil.marshalFileList(fl, "files");

		// List<FileInfo> files = fl.getFileInfoList();
		// if (files != null)
		// for (FileInfo file : files) {
		// System.out.println(file);
		// }
	}
}
