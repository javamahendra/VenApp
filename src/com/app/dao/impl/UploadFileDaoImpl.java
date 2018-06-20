package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUploadFileDao;
import com.app.model.UploadFile;
@Repository
public class UploadFileDaoImpl implements IUploadFileDao {
	@Autowired
	private HibernateTemplate ht;
	public int saveFile(UploadFile file) {
		return (Integer)ht.save(file);
	}
	public List<Object[]> getFileIdAndNames() {
		String hql="select fileId,fileName from "+UploadFile.class.getName();
		return (List<Object[]>)ht.find(hql);
	}
	public UploadFile getFileById(int fileId) {
		return ht.get(UploadFile.class, fileId);
	}
}






