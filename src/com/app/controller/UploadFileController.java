package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.UploadFile;
import com.app.service.IUploadFileService;
@Controller
public class UploadFileController {
	@Autowired
	private IUploadFileService service;
	
	/***
	 * 1. This method is used to
	 * display the Document Page(Upload and
	 * Download Page)
	 */
	@RequestMapping("/showUpload")
	public String showDocument(ModelMap map){
		//get all DB records and send to UI
		List<Object[]> ob=service.getFileIdAndNames();
		map.addAttribute("listOb", ob);
		return "UploadFile";
	}
	
	
	/**
	 * 2. On click upload it
	 * will read two inputs
	 *  i=>id
	 *  ii=> CommonsMultiplpartFile
	 */
	@RequestMapping(value="/fileUpload",method=RequestMethod.POST)
	public String uploadData(
	  @RequestParam("fid")int fid,
	  @RequestParam("fdatas")CommonsMultipartFile fOb){
		if(fOb!=null){
			//converted input data to model obj
			UploadFile f=new UploadFile();
			f.setFileId(fid);
			f.setFileName(fOb.getOriginalFilename());
			f.setFileData(fOb.getBytes());
			service.saveFile(f);
		}
		return "redirect:showUpload";
	}
	
	
	/**
	 * 3. Download document
	 */
	@RequestMapping("/downloadFile")
	public void downloadFile(HttpServletResponse res,@RequestParam("fid")int fileId){
		//1.load UploadFile obj from DB
		UploadFile f=service.getFileById(fileId);
		//2. specify attachment details
		res.addHeader("Content-Disposition","attachment;fileName="+f.getFileName());
		//3. copy data to OS
		try {
			FileCopyUtils.copy(f.getFileData(), res.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}










