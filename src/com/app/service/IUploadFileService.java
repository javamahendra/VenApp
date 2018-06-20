package com.app.service;

import java.util.List;

import com.app.model.UploadFile;

public interface IUploadFileService {
	public int saveFile(UploadFile file);
	public List<Object[]> getFileIdAndNames();
	public UploadFile getFileById(int fileId);
}






