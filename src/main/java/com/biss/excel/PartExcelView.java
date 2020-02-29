package com.biss.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.biss.model.Part;

public class PartExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//change file name
		response.addHeader("Content-Disposition", "attachment;filename=Part.xlsx");
		Sheet s=workbook.createSheet("Part");
		//construct row(0)
		setHead(s);
		//read model Data
		@SuppressWarnings("unchecked")
		List<Part> list=(List<Part>) model.get("list");
		setBody(list,s);
	}


	private void setHead(Sheet s) {
		Row r=s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("WIDTH");
		r.createCell(2).setCellValue("LENGTH");
		r.createCell(3).setCellValue("HEIGHT");
		r.createCell(4).setCellValue("CURRENCY");
		r.createCell(5).setCellValue("DESCRIPTION");
	}
	private void setBody(List<Part> list, Sheet s) {
		int count=1;
		for(Part om:list) {
			Row r=s.createRow(count++);
			r.createCell(0).setCellValue(om.getPartId());
			r.createCell(1).setCellValue(om.getPartWidth());
			r.createCell(2).setCellValue(om.getPartLength());
			r.createCell(3).setCellValue(om.getPartHeight());
			r.createCell(4).setCellValue(om.getPartCurrency());
			r.createCell(5).setCellValue(om.getPartDesc());
		}
	}
}

