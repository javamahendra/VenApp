package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUploadFileDao;
import com.app.model.UploadFile;
import com.app.service.IUploadFileService;
@Service
public class UploadFileServiceImpl implements IUploadFileService{
	@Autowired
	private IUploadFileDao dao;
	public int saveFile(UploadFile file) {
		return dao.saveFile(file);
	}
	public List<Object[]> getFileIdAndNames() {
		return dao.getFileIdAndNames();
	}
	public UploadFile getFileById(int fileId) {
		return dao.getFileById(fileId);
	}
}





