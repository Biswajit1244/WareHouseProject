package com.biss.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.biss.model.Document;
import com.biss.service.IDocumentService;

@Controller
@RequestMapping("/doc")
public class DocumentController {
	@Autowired
	private IDocumentService ser;
	
	@RequestMapping("/show")
	public String showDocPage(Model m) {
		List<Object[]> list=ser.getFileIdAndName();
		System.out.println(list.toString());
		m.addAttribute("list", list);
		return "Documents";
	}
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadData(@RequestParam("fileNo") Integer fileNo,
							@RequestParam("fileData") CommonsMultipartFile fileData,Model m) {
		if(fileData!=null) {
			Document doc=new Document();
			doc.setFileId(fileNo);
			doc.setFileName(fileData.getOriginalFilename());
			doc.setFileData(fileData.getBytes());
			ser.saveDocument(doc);
			String msg=fileNo+" is Uploaded";
			m.addAttribute("msg",msg);
		}
		return "redirect:show";
	}
	@RequestMapping("/download")
	public void doDownload(@RequestParam("fid")Integer id,HttpServletResponse resp) {
		Document doc=ser.getOneDocument(id);
		
		resp.addHeader("Content-Disposition","attachment;filename="+doc.getFileName());
		
		try {
			FileCopyUtils.copy(doc.getFileData(),resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
