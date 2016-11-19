package com.sumeeth.service;

import com.sumeeth.model.FileInfoList;

public interface IFilesService {

	FileInfoList getAllMovies();

	FileInfoList getAllMusic();

	FileInfoList readFileListFrom(String fileName,
			String fileType);

	void persistFileListToFile(FileInfoList fileInfoList,
			String fileName, String fileType);

	FileInfoList getAllMovies(String fileName,
			String fileType);

	FileInfoList getAllMusic(String fileName,
			String fileType);

}
