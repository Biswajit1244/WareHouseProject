package com.biss.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.biss.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//change file name
		response.addHeader("Content-Disposition", "attachment;filename=WhUserType.xlsx");
		Sheet s=workbook.createSheet("WhUserType");
		//construct row(0)
		setHead(s);
		//read model Data
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>) model.get("list");
		setBody(list,s);
	}


	private void setHead(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("USER FOR");
		r.createCell(4).setCellValue("EMAIL");
		r.createCell(5).setCellValue("CONTACT");
		r.createCell(6).setCellValue("ID TYPE");
		r.createCell(7).setCellValue("OTHER ID_TYPE");
		r.createCell(8).setCellValue("ID NUMBER");
		
	}
	private void setBody(List<WhUserType> list, Sheet s) {
		int count=1;
		for(WhUserType wh:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(wh.getUserId());
			r.createCell(1).setCellValue(wh.getWhUserType());
			r.createCell(2).setCellValue(wh.getWhUserCode());
			r.createCell(3).setCellValue(wh.getWhUserFor());
			r.createCell(4).setCellValue(wh.getWhUserEmail());
			r.createCell(5).setCellValue(wh.getWhUserCont());
			r.createCell(6).setCellValue(wh.getWhUserIdType());
			r.createCell(7).setCellValue(wh.getWhUserIdOther());
			r.createCell(8).setCellValue(wh.getWhUserIdNum());
		}
	}

}
