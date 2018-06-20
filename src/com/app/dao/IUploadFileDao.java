package com.app.dao;

import java.util.List;

import com.app.model.UploadFile;

public interface IUploadFileDao {
	public int saveFile(UploadFile file);
	public List<Object[]> getFileIdAndNames();
	public UploadFile getFileById(int fileId);
}





